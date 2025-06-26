package org.now.wlcn.observe.hive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitCommandLineRunner implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(InitCommandLineRunner.class);

    @Override
    public void run(String... args) throws Exception {
        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
    }
}
