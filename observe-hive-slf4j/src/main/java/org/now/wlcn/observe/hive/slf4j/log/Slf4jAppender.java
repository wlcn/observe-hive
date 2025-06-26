package org.now.wlcn.observe.hive.slf4j.log;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.ThrowableProxy;
import ch.qos.logback.core.AppenderBase;
import org.now.wlcn.observe.hive.api.log.LogEvent;
import org.now.wlcn.observe.hive.core.log.LogCollector;

import java.time.Instant;

public class Slf4jAppender extends AppenderBase<ILoggingEvent> {
    private LogCollector collector;

    public void setLogCollector(LogCollector collector) {
        this.collector = collector;
    }

    @Override
    protected void append(ILoggingEvent event) {
        if (collector != null) {
            collector.collect(convert(event));
        }
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
