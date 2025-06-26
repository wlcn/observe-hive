# observe-hive
Logs/Metrics/Traces. The hive for your observability data

## yaml

```yaml
logging:
  collector:
    enabled: true
    plugins:
      - file
      - kafka
      - elasticsearch
    elasticsearch:
      hosts: http://localhost:9200
      index-pattern: "logs-{date}"
    kafka:
      bootstrap-servers: localhost:9092
      topic: app-logs
```
