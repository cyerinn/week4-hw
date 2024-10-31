package doit.week4hw.controller.dto;

import doit.week4hw.repository.Product;

import java.util.List;

public record ProductResponse (
        Long id,
        String name,
        int price
){
    public static List<ProductResponse> from(List<Product> products){
        return products.stream()
                .map(product -> new ProductResponse(
                        product.getId(),
                        product.getName(),
                        product.getPrice()
                )).toList();
    }
}
