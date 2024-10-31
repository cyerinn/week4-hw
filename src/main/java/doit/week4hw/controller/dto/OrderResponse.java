package doit.week4hw.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import doit.week4hw.repository.Ordering;

import java.util.List;

public record OrderResponse (
        Long id,
        Long item,
        int count
){
    public static List<OrderResponse> from(List<Ordering> orders){
        return orders.stream()
                .map(order -> new OrderResponse(
                        order.getId(),
                        order.getItem(),
                        order.getCount()
                )).toList();
    }

    public static OrderResponse from(Ordering orders){
        return new OrderResponse(
                orders.getId(),
                orders.getItem(),
                orders.getCount()
        );
    }
}
