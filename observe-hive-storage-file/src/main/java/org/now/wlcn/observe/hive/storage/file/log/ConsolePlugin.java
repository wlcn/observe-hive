package org.now.wlcn.observe.hive.storage.file.log;

import org.now.wlcn.observe.hive.api.log.LogEvent;
import org.now.wlcn.observe.hive.api.log.LogPlugin;

public class ConsolePlugin implements LogPlugin {

    @Override
    public String pluginId() {
        return "console";
    }

    @Override
    public boolean supports(LogEvent event) {
        return true;
    }

    @Override
    public void store(LogEvent event) {
        System.err.printf("%s %s", pluginId(), event);
    }


}
