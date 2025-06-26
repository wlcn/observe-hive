package org.now.wlcn.observe.hive.core.log;

import org.now.wlcn.observe.hive.api.log.LogEvent;
import org.now.wlcn.observe.hive.api.log.LogPlugin;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LogCollector implements AutoCloseable {
    private final List<LogPlugin> plugins;
    private final ExecutorService executor;

    public LogCollector(List<LogPlugin> plugins) {
        this.plugins = plugins;
        this.executor = Executors.newVirtualThreadPerTaskExecutor();
    }

    public void collect(LogEvent event) {
        plugins.forEach(plugin -> {
            if (plugin.supports(event)) {
                executor.execute(() -> {
                    try {
                        plugin.store(event);
                    } catch (Exception e) {
                        System.err.printf("[%s] Failed to store log: %s%n",
                                plugin.pluginId(), e.getMessage());
                    }
                });
            }
        });
    }

    @Override
    public void close() throws Exception {
        executor.close();
        plugins.forEach(plugin -> {
            try {
                plugin.close();
            } catch (Exception e) {
                System.err.printf("[%s] Failed to close: %s%n",
                        plugin.pluginId(), e.getMessage());
            }
        });
    }
}
