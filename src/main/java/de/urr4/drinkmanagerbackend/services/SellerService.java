package de.urr4.drinkmanagerbackend.services;

import de.urr4.drinkmanagerbackend.repositories.SellerRepository;
import de.urr4.wine.entities.Seller;
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
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    public List<Seller> getSellers(){
        List<Seller> allSellers = new ArrayList<>();
        sellerRepository.findAll()
                .forEach(s -> allSellers.add(s));

        return allSellers;
    }
}
