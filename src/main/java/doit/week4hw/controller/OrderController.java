package doit.week4hw.controller;

import doit.week4hw.controller.dto.OrderCreateRequest;
import doit.week4hw.controller.dto.OrderResponse;
import doit.week4hw.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public List<OrderResponse> getAllOrders(){
        return orderService.findAllOrders();
    }

    @PostMapping("/orders")
    public OrderResponse createNewOrder(@RequestBody OrderCreateRequest request){
        return orderService.createOrder(request);
    }
}
