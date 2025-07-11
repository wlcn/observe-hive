package org.now.wlcn.observe.hive.strter.log.autoconfigure;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;
import jakarta.annotation.Nonnull;
import lombok.RequiredArgsConstructor;
import org.now.wlcn.observe.hive.core.log.LogCollector;
import org.now.wlcn.observe.hive.slf4j.log.Slf4jAppender;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@ConditionalOnProperty(name = "observe.hive.enabled", havingValue = "true")
@ConditionalOnProperty(name = "observe.hive.adapters.logback.enabled", havingValue = "true")
@AutoConfiguration
@ConditionalOnClass(value = {
        ch.qos.logback.classic.Logger.class
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


@ConditionalOnProperty(name = "observe.hive.enabled", havingValue = "true")
@ConditionalOnProperty(name = "observe.hive.adapters.logback.enabled", havingValue = "true")
@AutoConfigureAfter(Slf4jAutoConfiguration.class)
@Component
@RequiredArgsConstructor
@ConditionalOnClass(value = {
        ch.qos.logback.classic.Logger.class,
        org.now.wlcn.observe.hive.slf4j.log.Slf4jAppender.class
})
class LogbackAutoConfigurator implements ApplicationListener<ContextRefreshedEvent> {

    private final List<Appender<ILoggingEvent>> appenderList;

    @Override
    public void onApplicationEvent(@Nonnull ContextRefreshedEvent event) {
        final LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();

        Optional.ofNullable(loggerContext)
                .map(f -> f.getLogger(Logger.ROOT_LOGGER_NAME))
                .ifPresent(logger ->
                        appenderList.forEach(a -> {
                            a.setContext(loggerContext);
                            a.start();
                            logger.addAppender(a);
                        }));


    }
}