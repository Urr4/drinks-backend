package de.urr4.drinkmanagerbackend.services;

import de.urr4.drinkmanagerbackend.repositories.OrderRepository;
import de.urr4.wine.entities.Order;
import io.leangen.graphql.metadata.strategy.query.PublicResolverBuilder;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import io.leangen.graphql.spqr.spring.annotations.WithResolverBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@GraphQLApi
@WithResolverBuilder(PublicResolverBuilder.class)
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getOrders(){
        List<Order> allOrders = new ArrayList<>();

        orderRepository.findAll()
                .forEach(o -> allOrders.add(o));

        return allOrders;
    }
}
