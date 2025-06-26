package org.now.wlcn.observe.hive.strter.log.autoconfigure;

import org.now.wlcn.observe.hive.api.log.LogPlugin;
import org.now.wlcn.observe.hive.core.log.LogCollector;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@AutoConfiguration
@EnableConfigurationProperties(LogCollectorProperties.class)
public class LogCollectorAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public LogCollector logCollector(List<LogPlugin> plugins) {
        return new LogCollector(plugins);
    }
}
