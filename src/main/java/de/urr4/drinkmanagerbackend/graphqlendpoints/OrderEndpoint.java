package de.urr4.drinkmanagerbackend.graphqlendpoints;

import de.urr4.drinkmanagerbackend.services.OrderService;
import de.urr4.wine.entities.Order;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@GraphQLApi
public class OrderEndpoint {

    private final OrderService orderService;

    @Autowired
    public OrderEndpoint(OrderService orderService) {
        this.orderService = orderService;
    }

    @GraphQLQuery
    public List<Order> getOrders() {
        return orderService.getAllOrders();
    }

    @GraphQLMutation
    public Order saveOrder(Order order) {
        return orderService.saveOrder(order);
    }
}
