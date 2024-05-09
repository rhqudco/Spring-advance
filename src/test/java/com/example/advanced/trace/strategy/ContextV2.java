package com.example.advanced.trace.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextV2 {

  public void execute(Strategy strategy) {
    long startTime = System.currentTimeMillis();
    // logic start
    strategy.call();
    // logic end
    long endTime = System.currentTimeMillis();
    long resultTime = endTime - startTime;
    log.info("resultTime = {}", resultTime);
  }

}
