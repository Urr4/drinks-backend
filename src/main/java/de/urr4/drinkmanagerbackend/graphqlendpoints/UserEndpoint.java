package de.urr4.drinkmanagerbackend.graphqlendpoints;

import de.urr4.drinkmanagerbackend.services.UserService;
import de.urr4.wine.entities.User;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@GraphQLApi
public class UserEndpoint {

    private final UserService userService;

    @Autowired
    public UserEndpoint(UserService userService){
        this.userService = userService;
    }

    @GraphQLQuery
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GraphQLMutation
    public User saveUser(User user) {
        return userService.saveUser(user);
    }
}
