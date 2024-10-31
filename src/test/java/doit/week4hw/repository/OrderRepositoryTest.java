package doit.week4hw.repository;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void findAllTest(){
        Ordering order = new Ordering(1L, 3);

        orderRepository.save(order);

        List<Ordering> orders = orderRepository.findAll();

        org.assertj.core.api.Assertions.assertThat(orders).hasSize(1);

    }
}