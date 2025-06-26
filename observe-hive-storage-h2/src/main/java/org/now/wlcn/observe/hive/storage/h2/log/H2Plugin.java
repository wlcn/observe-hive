package org.now.wlcn.observe.hive.storage.h2.log;

import org.now.wlcn.observe.hive.api.log.LogEvent;
import org.now.wlcn.observe.hive.api.log.LogPlugin;

public class H2Plugin implements LogPlugin {

    @Override
    public String pluginId() {
        return "h2";
    }

    @Override
    public boolean supports(LogEvent event) {
        return true;
    }

    @Override
    public void store(LogEvent event) {
        System.err.println(pluginId() + event);
    }


}
