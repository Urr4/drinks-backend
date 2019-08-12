package de.urr4.drinkmanagerbackend.services;

import de.urr4.drinkmanagerbackend.repositories.OrderRepository;
import de.urr4.wine.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        List<Order> allOrders = new ArrayList<>();

        orderRepository.findAll()
                .forEach(allOrders::add);

        return allOrders;
    }

    public Order saveOrder(Order order) {
        orderRepository.save(order);
        return order;
    }
}
