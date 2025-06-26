package org.now.wlcn.observe.hive.strter.log;

public interface LogPlugin {
    boolean supports(LogEvent event);

    void store(LogEvent event);

    default void init() {
    }

    default void destroy() {
    }
}
