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
implementation 'com.example:observe-hive-slf4j' // SLF4J support
implementation 'com.example:observe-hive-log4j2' // Log4j2 support
```

### Storage Plugins

```yaml
logging:
  collector:
    storage:
      elasticsearch:
        hosts: http://localhost:9200
      kafka:
        bootstrap-servers: localhost:9092
```

## Quick Start

1. Add dependencies:

```gradle
dependencies {
    implementation 'com.example:observe-hive-starter'
    implementation 'com.example:observe-hive-slf4j'
    implementation 'com.example:observe-hive-storage-elasticsearch'
}
``` 

2. Configure (application.yml):

```yaml
logging:
  collector:
    enabled: true
    buffer-size: 1000
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

```text

This is pure Markdown that can be directly copied into a README.md file. It includes:
- Proper headers and sections
- Code blocks with syntax highlighting
- Tables for module documentation
- Configuration examples
- Extension guidelines
- License information

All formatting will render correctly in GitHub/GitLab markdown viewers.
```