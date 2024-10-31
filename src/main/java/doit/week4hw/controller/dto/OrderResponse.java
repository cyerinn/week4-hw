package doit.week4hw.controller.dto;

import doit.week4hw.repository.Order;

import java.util.List;

public record OrderResponse (
        Long id,
        Long item,
        int count
){
    public static List<OrderResponse> from(List<Order> orders){
        return orders.stream()
                .map(order -> new OrderResponse(
                        order.getId(),
                        order.getItem(),
                        order.getCount()
                )).toList();
    }
}
