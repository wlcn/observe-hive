package org.now.wlcn.observe.hive.api.log;

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

    public static LogEvent create(Instant timestamp,
                                  String level,
                                  String loggerName,
                                  String threadName,
                                  String message,
                                  Map<String, String> mdc,
                                  Throwable throwable) {
        return new LogEvent(timestamp, level, loggerName, threadName, message, mdc, throwable);
    }
}
