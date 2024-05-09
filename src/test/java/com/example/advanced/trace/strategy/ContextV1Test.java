package com.example.advanced.trace.strategy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {

  @Test
  void strategy() {
    logic1();
    logic2();
  }

  @Test
  void strategyV1() {
    Strategy strategyLogic1 = new StrategyLogic1();
    ContextV1 context1 = new ContextV1(strategyLogic1);
    context1.execute();

    Strategy strategyLogic2 = new StrategyLogic2();
    ContextV1 context2 = new ContextV1(strategyLogic2);
    context2.execute();
  }

  @Test
  void strategyV2() {
    Strategy strategy1 = new Strategy() {
      @Override
      public void call() {
        log.info("logic 1 execute");
      }
    };
    log.info("strategyLogic1={}", strategy1.getClass());
    ContextV1 context1 = new ContextV1(strategy1);
    context1.execute();

    Strategy strategy2 = new Strategy() {
      @Override
      public void call() {
        log.info("logic 2 execute");
      }
    };
    log.info("strategyLogic2={}", strategy1.getClass());
    ContextV1 context2 = new ContextV1(strategy2);
    context2.execute();
  }

  @Test
  void strategyV3() {
    ContextV1 contextV1 = new ContextV1(new Strategy() {
      @Override
      public void call() {
        log.info("logic 1 execute");
      }
    });
    contextV1.execute();

    ContextV1 contextV2 = new ContextV1(new Strategy() {
      @Override
      public void call() {
        log.info("logic 2 execute");
      }
    });
    contextV2.execute();
  }

  @Test
  void strategyV4() {
    ContextV1 context1 = new ContextV1(() -> log.info("logic 1 execute"));
    context1.execute();
    ContextV1 context2 = new ContextV1(() -> log.info("logic 2 execute"));
    context2.execute();
  }


  private void logic1() {
    long startTime = System.currentTimeMillis(); //비즈니스 로직 실행
    log.info("비즈니스 로직1 실행");
    //비즈니스 로직 종료
    long endTime = System.currentTimeMillis();
    long resultTime = endTime - startTime;
    log.info("resultTime={}", resultTime);
  }
  private void logic2() {
    long startTime = System.currentTimeMillis(); //비즈니스 로직 실행
    log.info("비즈니스 로직2 실행");
    //비즈니스 로직 종료
    long endTime = System.currentTimeMillis();
    long resultTime = endTime - startTime;
    log.info("resultTime={}", resultTime);
  }
}
