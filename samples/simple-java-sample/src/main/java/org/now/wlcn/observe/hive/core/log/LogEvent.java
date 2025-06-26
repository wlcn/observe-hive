package org.now.wlcn.observe.hive.strter.log;

import java.time.Instant;
import java.util.Map;

public record LogEvent(
        Instant timestamp,
        String level,
        String loggerName,
        String threadName,
        String message,
        Map<String, String> mdc,
        Throwable throwable
) {
}
