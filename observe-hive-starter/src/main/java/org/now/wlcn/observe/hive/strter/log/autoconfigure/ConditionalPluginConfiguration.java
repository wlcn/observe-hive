package org.now.wlcn.observe.hive.strter.log.autoconfigure;

import org.now.wlcn.observe.hive.api.log.LogPlugin;
import org.now.wlcn.observe.hive.storage.file.log.log.ConsolePlugin;
import org.now.wlcn.observe.hive.storage.file.log.log.FilePlugin;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "observe.hive.enabled", havingValue = "true")
public class ConditionalPluginConfiguration {

    @Bean
    @ConditionalOnProperty(name = "observe.hive.enabled", havingValue = "true")
    public LogPlugin filePlugin() {
        return new FilePlugin();
    }

    @Bean
    @ConditionalOnProperty(name = "observe.hive.enabled", havingValue = "true")
    public LogPlugin consolePlugin() {
        return new ConsolePlugin();
    }
}
