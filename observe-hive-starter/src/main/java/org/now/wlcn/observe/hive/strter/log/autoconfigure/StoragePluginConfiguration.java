package org.now.wlcn.observe.hive.strter.log.autoconfigure;

import org.now.wlcn.observe.hive.api.log.LogPlugin;
import org.now.wlcn.observe.hive.storage.file.log.ConsolePlugin;
import org.now.wlcn.observe.hive.storage.file.log.FilePlugin;
import org.now.wlcn.observe.hive.storage.h2.log.H2Plugin;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "observe.hive.enabled", havingValue = "true")
public class StoragePluginConfiguration {

    @Bean
    @ConditionalOnProperty(name = "observe.hive.storage.file.enabled", havingValue = "true")
    public LogPlugin filePlugin() {
        return new FilePlugin();
    }

    @Bean
    @ConditionalOnProperty(name = "observe.hive.storage.console.enabled", havingValue = "true")
    public LogPlugin consolePlugin() {
        return new ConsolePlugin();
    }

    @Bean
    @ConditionalOnProperty(name = "observe.hive.storage.h2.enabled", havingValue = "true")
    public LogPlugin h2Plugin() {
        return new H2Plugin();
    }
}
