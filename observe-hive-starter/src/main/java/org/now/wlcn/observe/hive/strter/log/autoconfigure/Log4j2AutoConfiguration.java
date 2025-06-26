package org.now.wlcn.observe.hive.strter.log.autoconfigure;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@ConditionalOnProperty(name = "observe.hive.enabled", havingValue = "true")
@ConditionalOnProperty(name = "observe.hive.adapters.log4j2.enabled", havingValue = "true")
@AutoConfiguration
@ConditionalOnClass(value = {
        org.apache.logging.log4j.core.Logger.class
})
@EnableConfigurationProperties(ObserveHiveProperties.class)
public class Log4j2AutoConfiguration {


}


