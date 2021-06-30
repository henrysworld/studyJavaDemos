package week01;

import java.util.Base64;

public class HelloClassLoader extends ClassLoader{

    public static void main(String[] args){
        try {
            new HelloClassLoader().findClass("week01.Hello").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String base64 = "yv66vgAAADQAHQoABgAPCQAQABEIABIKABMAFAcAFQcAFgEABjxpbml0PgEAAygpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAARtYWluAQAWKFtMamF2YS9sYW5nL1N0cmluZzspVgEAClNvdXJjZUZpbGUBAApIZWxsby5qYXZhDAAHAAgHABcMABgAGQEAI0hlbGxvIHRoaXMgaXMgbXkgZmlyc3QgY2xhc3Nsb2FkZXIhBwAaDAAbABwBAAx3ZWVrMDEvSGVsbG8BABBqYXZhL2xhbmcvT2JqZWN0AQAQamF2YS9sYW5nL1N5c3RlbQEAA291dAEAFUxqYXZhL2lvL1ByaW50U3RyZWFtOwEAE2phdmEvaW8vUHJpbnRTdHJlYW0BAAdwcmludGxuAQAVKExqYXZhL2xhbmcvU3RyaW5nOylWACEABQAGAAAAAAACAAEABwAIAAEACQAAAB0AAQABAAAABSq3AAGxAAAAAQAKAAAABgABAAAAAwAJAAsADAABAAkAAAAlAAIAAQAAAAmyAAISA7YABLEAAAABAAoAAAAKAAIAAAAGAAgABwABAA0AAAACAA4=";
        byte[] bytes = decode(base64);
        return defineClass(name, bytes, 0, bytes.length);
    }

    public static byte[] decode(String base64){
        return Base64.getDecoder().decode(base64);
    }
}
