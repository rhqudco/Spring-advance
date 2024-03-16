package com.example.advanced.v1;

import com.example.advanced.trace.TraceStatus;
import com.example.advanced.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV1 {
    private final OrderServiceV1 orderService;
    private final HelloTraceV1 trace;

    @GetMapping("/v1/request")
    public String request(@RequestParam("itemId") String itemId) {
        TraceStatus status = trace.begin("OrderController.request()");
        try {
//            status = trace.begin("OrderController.request()"); >>> 예제는 try 밖에 status를 null로 선언하고 여기서 할당해줌
            orderService.orderItem(itemId);
            trace.end(status);
            return "ok";
        } catch (Exception e) {
            trace.exception(status, e);
            throw e; // 꼭 예외를 다시 던져야 함
        }
    }
}
