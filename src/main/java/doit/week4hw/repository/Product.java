package doit.week4hw.repository;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_name")
    private String name;

    private int price;

    @Builder
    public Product(String name, int price){
        this.name = name;
        this.price = price;
    }

    public void changeName(String name){
        this.name = name;
    }

    public void changePrice(int price){
        this.price = price;
    }

}
