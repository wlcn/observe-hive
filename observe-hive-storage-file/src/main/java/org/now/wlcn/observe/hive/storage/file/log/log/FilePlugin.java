package org.now.wlcn.observe.hive.storage.file.log.log;

import org.now.wlcn.observe.hive.api.log.LogEvent;
import org.now.wlcn.observe.hive.api.log.LogPlugin;

public class FilePlugin implements LogPlugin {

    @Override
    public String pluginId() {
        return "file";
    }

    @Override
    public boolean supports(LogEvent event) {
        return true;
    }

    @Override
    public void store(LogEvent event) {
        System.out.println(event);
    }


}
