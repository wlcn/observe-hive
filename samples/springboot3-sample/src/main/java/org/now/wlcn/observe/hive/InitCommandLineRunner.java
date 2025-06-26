package org.now.wlcn.observe.hive;

import org.apache.logging.log4j.LogManager;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitCommandLineRunner implements CommandLineRunner {
    private static final org.apache.logging.log4j.Logger log4jLogger = LogManager.getLogger();

    @Override
    public void run(String... args) throws Exception {
//        log.trace("trace");
//        log.debug("debug");
//        log.info("info");
//        log.warn("warn");
//        log.error("error");

        System.out.println("---log4j2---");

        log4jLogger.trace("trace");
        log4jLogger.debug("debug");
        log4jLogger.info("info");
        log4jLogger.warn("warn");
        log4jLogger.error("error");
    }
}
