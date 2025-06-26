package org.now.wlcn.observe.hive.strter.log.autoconfigure;

import org.now.wlcn.observe.hive.core.log.LogCollector;
import org.now.wlcn.observe.hive.slf4j.log.Slf4jAppender;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@ConditionalOnClass(value = {
        ch.qos.logback.classic.Logger.class,
        org.now.wlcn.observe.hive.slf4j.log.Slf4jAppender.class
})
@EnableConfigurationProperties(ObserveHiveProperties.class)
public class Slf4jAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public Slf4jAppender slf4jAppender(LogCollector logCollector) {
        final Slf4jAppender appender = Slf4jAppender.create(logCollector);
        appender.setName("ObserveHive_Slf4jAppender");
        return appender;
    }
}
