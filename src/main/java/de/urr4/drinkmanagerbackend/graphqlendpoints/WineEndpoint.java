package de.urr4.drinkmanagerbackend.graphqlendpoints;

import de.urr4.drinkmanagerbackend.services.WineService;
import de.urr4.wine.entities.Wine;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@GraphQLApi
public class WineEndpoint {

    private final WineService wineService;

    @Autowired
    public WineEndpoint(WineService wineService) {
        this.wineService = wineService;
    }

    @GraphQLQuery
    public List<Wine> getWines() {
        return wineService.getAllWines();
    }

    @GraphQLMutation
    public Wine saveWine(Wine wine) {
        return wineService.saveWine(wine);
    }
}
