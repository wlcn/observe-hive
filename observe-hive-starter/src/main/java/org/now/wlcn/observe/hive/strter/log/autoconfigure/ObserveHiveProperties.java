package org.now.wlcn.observe.hive.strter.log.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "observe.hive")
@Data
public class ObserveHiveProperties {
    private boolean enabled;
    private Storage storage;


    @Data
    public static class Storage {
        private Elasticsearch elasticsearch;

        @Data
        public static class Elasticsearch {
            private boolean enabled;
            private String hosts;
        }
    }
}
