package com.ch.rpcfxcore.netty.server;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ch.rpcfxcore.api.RpcRequest;
import com.ch.rpcfxcore.api.RpcResponse;
import com.ch.rpcfxcore.netty.common.RpcProtocol;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @Autor: HE CHEN
 * @Date: 2021/8/22 0:07
 * @Version: 1.0
 */
@Slf4j
public class RpcServerHandler extends SimpleChannelInboundHandler<RpcProtocol> {
    private final ApplicationContext applicationContext;

    public RpcServerHandler(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }


    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, RpcProtocol rpcProtocol) throws Exception {
        log.info("Netty server receive message:");
        log.info("Message length:" + rpcProtocol.getLen());
        log.info("Message content: " + new String(rpcProtocol.getContent(), CharsetUtil.UTF_8));

        // 获取 RpcProtocol 中的RpcRequest 内容，反序列化成RpcRequest对象
        RpcRequest rpcRequest = JSON.parseObject(new String(rpcProtocol.getContent(), CharsetUtil.UTF_8), RpcRequest.class);
        log.info("Netty server serializer : " + rpcRequest.toString());

        //获取相应的bean,反射调用方法，获取结果
        RpcResponse rpcResponse = invoke(rpcRequest);

        //返回结果给netty客户端
        RpcProtocol message = new RpcProtocol();
        String requestJson = JSON.toJSONString(rpcResponse);
        message.setLen(requestJson.getBytes(CharsetUtil.UTF_8).length);
        message.setContent(requestJson.getBytes(CharsetUtil.UTF_8));

        channelHandlerContext.writeAndFlush(message).sync();
        log.info("return response to client end");

    }

    private RpcResponse invoke(RpcRequest request) {
        RpcResponse response = new RpcResponse();
        String serviceClass = request.getServiceClass();

        //作业1：改成泛型和反射
        Object service = applicationContext.getBean(serviceClass);

        Method method = resolveMethodFromClass(service.getClass(), request.getMethod());
        try {
            Object result = method.invoke(service, request.getArgv());
            log.info("Server method invoke result: " + result.toString());
            //两次json序列号能否合成1个
            response.setResult(JSON.toJSONString(result, SerializerFeature.WriteClassName));
            response.setStatus(true);
            log.info("server Response serialize to string return");
            return response;
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            response.setException(e);
            response.setStatus(false);
            return response;
        }
    }

    private Method resolveMethodFromClass(Class<?> klass, String methodName) {
        return Arrays.stream(klass.getMethods()).filter(m -> methodName.equals(m.getName())).findFirst().get();
    }
}
