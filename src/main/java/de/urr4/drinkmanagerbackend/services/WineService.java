package de.urr4.drinkmanagerbackend.services;

import de.urr4.drinkmanagerbackend.repositories.WineRepository;
import de.urr4.wine.entities.Wine;
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
public class WineService {

    @Autowired
    private WineRepository wineRepository;

    public List<Wine> getWines(){
        List<Wine> allWines = new ArrayList<>();
        wineRepository.findAll()
                .forEach(w -> allWines.add(w));
        return allWines;
    }

}
