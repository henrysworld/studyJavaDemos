package week03.nio02.gateway.outbound.httpclient4;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class NamedThreadFactory implements ThreadFactory {
    private final ThreadGroup group;
    private final AtomicInteger threadNumber = new AtomicInteger(1);

    private final String namePrefix;
    private final boolean daemon;

    public NamedThreadFactory(String namePrefix, boolean daemon) {
        this.namePrefix = namePrefix;
        this.daemon = daemon;
        SecurityManager s = System.getSecurityManager();
        group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
    }

    public NamedThreadFactory(String namePrefix) {
        this(namePrefix, false);
    }


    @Override
    public Thread newThread(Runnable runnable) {
        Thread t = new Thread(group, runnable, namePrefix + "-thread-" + threadNumber.getAndIncrement(), 0);
        t.setDaemon(daemon);
        return t;
    }
}
