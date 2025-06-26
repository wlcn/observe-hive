package org.now.wlcn.observe.hive.api.log;

public interface LogPlugin extends AutoCloseable {
    String pluginId();

    boolean supports(LogEvent event);

    void store(LogEvent event);

    default void init() {
    }

    @Override
    default void close() {
    }
}
