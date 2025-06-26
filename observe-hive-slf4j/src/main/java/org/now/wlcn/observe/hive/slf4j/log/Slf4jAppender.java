package org.now.wlcn.observe.hive.slf4j.log;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.ThrowableProxy;
import ch.qos.logback.core.AppenderBase;
import org.now.wlcn.observe.hive.api.log.LogAppender;
import org.now.wlcn.observe.hive.api.log.LogEvent;
import org.now.wlcn.observe.hive.core.log.LogCollector;

import java.time.Instant;
import java.util.Objects;

public class Slf4jAppender extends AppenderBase<ILoggingEvent> implements LogAppender {
    private final LogCollector collector;

    private Slf4jAppender(final LogCollector logCollector) {
        this.collector = logCollector;
    }

    public static Slf4jAppender create(final LogCollector logCollector) {
        Objects.requireNonNull(logCollector, "logCollector must not be null");
        return new Slf4jAppender(logCollector);
    }

    @Override
    protected void append(ILoggingEvent event) {
        collector.collect(convert(event));
    }

    private LogEvent convert(ILoggingEvent event) {
        return new LogEvent(
                Instant.ofEpochMilli(event.getTimeStamp()),
                event.getLevel().toString(),
                event.getLoggerName(),
                event.getThreadName(),
                event.getFormattedMessage(),
                event.getMDCPropertyMap(),
                event.getThrowableProxy() != null ?
                        ((ThrowableProxy) event.getThrowableProxy()).getThrowable() : null
        );
    }
}
