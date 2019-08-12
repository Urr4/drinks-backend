package de.urr4.drinkmanagerbackend.graphqlendpoints;

import de.urr4.drinkmanagerbackend.services.SellerService;
import de.urr4.wine.entities.Seller;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@GraphQLApi
public class SellerEndpoint {

    private final SellerService sellerService;

    @Autowired
    public SellerEndpoint(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @GraphQLQuery
    public List<Seller> getSellers() {
        return sellerService.getAllSellers();
    }

    @GraphQLMutation
    public Seller saveSeller(Seller seller) {
        return sellerService.saveSeller(seller);
    }
}
