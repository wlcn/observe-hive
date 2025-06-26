package org.now.wlcn.observe.hive.strter.log;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class LogCollector {
    private final List<LogPlugin> plugins = new CopyOnWriteArrayList<>();

    public void collect(LogEvent event) {
        plugins.stream()
                .filter(p -> p.supports(event))
                .forEach(p -> p.store(event));
    }

    public void registerPlugin(LogPlugin plugin) {
        plugins.add(plugin);
        plugin.init();
    }

    public void deregisterPlugin(LogPlugin plugin) {
        plugins.remove(plugin);
        plugin.destroy();
    }
}
