package com.example.advanced.trace.template;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTemplate {
  public void execute() {
    long startTime = System.currentTimeMillis();
    // business logic start
    call();
    // business logic end
    long endTime = System.currentTimeMillis();
    long resultTime = endTime - startTime;
    log.info("resultTime = {}", resultTime);
  }

  protected abstract void call();
}
