package week01;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class XlassLoader extends ClassLoader{
    public static void main(String [] args) {

        String className = "week01.Hello";
        String methodName = "hello";
        XlassLoader xlassLoader = new XlassLoader();
        try {
            Class<?> xlass = xlassLoader.loadClass(className);

            for (Method m : xlass.getMethods()){
                System.out.println(xlass.getSimpleName() + "." + m.getName());
            }

            Object instance = xlass.getDeclaredConstructor().newInstance();
            Method method = xlass.getMethod(methodName);
            method.invoke(instance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String path = name.replace(".", "/");
        String suffix = ".xlass";

        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(path + suffix);
        try {
            int length = inputStream.available();
            byte[] bytesArray = new byte[length];
            inputStream.read(bytesArray);
            bytesArray = decode(bytesArray);
            return defineClass(name, bytesArray, 0, bytesArray.length);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ClassNotFoundException(name, e);
        } finally {
            close(inputStream);
        }
    }


    private static void close(InputStream res){
        if (res != null){
            try {
                res.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 解码
     * @param bytes
     * @return
     */
    private static byte[] decode(byte[] bytes){
        byte[] lastBytes = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++){
            lastBytes[i] = (byte) (255 - bytes[i]);
        }

        return lastBytes;
    }
}
