package doit.week4hw.repository;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Ordering {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "purchase_item")
    private Long item;

    private int count;

    @Builder
    public Ordering(Long item, int count){
        this.item = item;
        this.count = count;
    }
}
