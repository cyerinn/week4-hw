package doit.week4hw.service;

import doit.week4hw.controller.dto.OrderCreateRequest;
import doit.week4hw.controller.dto.OrderResponse;
import doit.week4hw.repository.OrderRepository;
import doit.week4hw.repository.Ordering;
import doit.week4hw.repository.Product;
import doit.week4hw.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public List<OrderResponse> findAllOrders(){
        List<Ordering> orders = orderRepository.findAll();
        return OrderResponse.from(orders);
    }

    public OrderResponse createOrder(OrderCreateRequest request){
        Product product = productRepository.findById(request.item())
                .orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));

        Ordering order = Ordering.builder()
                .item(product.getId())
                .count(request.count())
                .build();

        orderRepository.save(order);

       return new OrderResponse(
               order.getId(),
               order.getItem(),
               order.getCount()
       );
    }
}
