package week02.nio02.gateway.filter;

import io.netty.handler.codec.http.FullHttpResponse;

public class HeaderHttpResponseFilter implements HttpResponseFilter{

    public void filter(FullHttpResponse response) {
        response.headers().set("Ch", "java-2-nio");
    }
}
