package com.example.advanced.trace.callback;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeLogTemplate {

  public void execute(Callback callback) {
    long startTime = System.currentTimeMillis();
    // logic start
    callback.call();
    // logic end
    long endTime = System.currentTimeMillis();
    long resultTime = endTime - startTime;
    log.info("resultTime = {}", resultTime);
  }

}
