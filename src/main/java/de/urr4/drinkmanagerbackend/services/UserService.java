package de.urr4.drinkmanagerbackend.services;

import de.urr4.drinkmanagerbackend.repositories.UserRepository;
import de.urr4.wine.entities.User;
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
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers(){
        List<User> allUsers = new ArrayList<>();

        Iterable<User> users = userRepository.findAll();
        users.forEach(u -> allUsers.add(u));

        return allUsers;
    }
}
