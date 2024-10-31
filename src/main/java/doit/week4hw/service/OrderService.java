package doit.week4hw.service;

import doit.week4hw.controller.dto.OrderCreateRequest;
import doit.week4hw.controller.dto.OrderResponse;
import doit.week4hw.repository.Order;
import doit.week4hw.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public List<OrderResponse> findAllOrders(){
        List<Order> orders = orderRepository.findAll();
        return OrderResponse.from(orders);
    }

    public OrderResponse createOrder(OrderCreateRequest request){
        Order newOrder = new Order(request.item(), request.count());

        Order savedOrder = orderRepository.save(newOrder);

        return new OrderResponse(
                savedOrder.getId(),
                savedOrder.getItem(),
                savedOrder.getCount()
        );
    }
}
