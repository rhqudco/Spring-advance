package com.example.advanced.trace.callback;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallbackTest {

  @Test
  void callbackV1() {
    TimeLogTemplate template = new TimeLogTemplate();

    template.execute(new Callback() {
      @Override
      public void call() {
        log.info("logic 1");
      }
    });

    template.execute(new Callback() {
      @Override
      public void call() {
        log.info("logic 2");
      }
    });
  }

  @Test
  void callbackV2() {
    TimeLogTemplate template = new TimeLogTemplate();

    template.execute(() -> log.info("logic 1"));
    template.execute(() -> log.info("logic 2"));
  }
}
