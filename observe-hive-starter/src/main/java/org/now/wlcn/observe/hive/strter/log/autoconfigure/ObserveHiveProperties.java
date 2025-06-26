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
        private H2 h2;

        @Data
        public static class H2 {
            private boolean enabled;
            private String hosts;
        }

        @Data
        public static class Elasticsearch {
            private boolean enabled;
            private String hosts;
        }
    }
}
