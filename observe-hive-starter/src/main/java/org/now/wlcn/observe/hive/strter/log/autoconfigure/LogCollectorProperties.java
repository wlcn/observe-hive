package org.now.wlcn.observe.hive.strter.log.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "observe.hive")
public class LogCollectorProperties {
    private boolean enabled = true;
    private Storage storage = new Storage();

    // getters/setters...

    public static class Storage {
        private Elasticsearch elasticsearch = new Elasticsearch();

        // getters/setters...

        public static class Elasticsearch {
            private boolean enabled;
            private String[] hosts = new String[]{"http://localhost:9200"};
            private String indexPattern = "logs-{date}";

            // getters/setters...
        }
    }
}
