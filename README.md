# observe-hive

Logs/Metrics/Traces. The hive for your observability data
A modular, extensible log collection system built with Spring Boot 3 and Java 21.

## Key Features
- **Multi-logger Support**: SLF4J, Log4j2, JUL
- **Pluggable Storage**: Elasticsearch, Kafka, S3
- **Spring-native**: Auto-configuration & Actuator support
- **Virtual Threads**: High-throughput processing

## Modules

### Core
| Module | Description |
|--------|-------------|
| `api` | Interfaces and data models |
| `core` | Collection engine and pipeline |
| `starter` | Spring Boot auto-configuration |

### Adapters
```gradle
implementation 'org.now.wlcn:observe-hive-slf4j' // SLF4J support
implementation 'org.now.wlcn:observe-hive-log4j2' // Log4j2 support
```

### Storage Plugins

```yaml
observe:
  hive:
    enabled: true
    adapters:
      logback:
        enabled: true
      log4j2:
        enabled: true
    storage:
      console:
        enabled: true
      file:
        enabled: true
      elasticsearch:
        enabled: true
        hosts: http://localhost:9200
        index-pattern: "app-logs-{date}"
```

## Quick Start

1. Add dependencies:

```gradle
dependencies {
    implementation 'org.now.wlcn:observe-hive-starter'
    implementation 'org.now.wlcn:observe-hive-slf4j'
    implementation 'org.now.wlcn:observe-hive-storage-elasticsearch'
}
``` 

2. Configure (application.yml):

```yaml
observe:
  hive:
    enabled: true
    adapters:
      logback:
        enabled: true
      log4j2:
        enabled: true
    storage:
      console:
        enabled: true
      file:
        enabled: true
      elasticsearch:
        enabled: true
        hosts: http://localhost:9200
        index-pattern: "app-logs-{date}"
```

3. Verify:

```bash
curl http://localhost:8080/any_api_whih_log
```

## Extending

1. Create module:

```bash
mkdir observe-hive-storage-redis
```

2. Implement interface:

```java
@Component
public class RedisPlugin implements LogPlugin {
    // implementation...
}
```

3. Add conditional:

```java
@ConditionalOnClass(name = "redis.clients.jedis.Jedis")
```

## Performance Tips

```java
@Bean
public Executor logExecutor() {
    return Executors.newVirtualThreadPerTaskExecutor(); // Java 21+
}
```

## License

Apache 2.0 © [Long Wang]
