package de.urr4.drinkmanagerbackend.services;

import de.urr4.drinkmanagerbackend.repositories.SellerRepository;
import de.urr4.wine.entities.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SellerService {

    private final SellerRepository sellerRepository;

    @Autowired
    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public List<Seller> getAllSellers() {
        List<Seller> allSellers = new ArrayList<>();
        sellerRepository.findAll()
                .forEach(allSellers::add);

        return allSellers;
    }

    public Seller saveSeller(Seller seller) {
        sellerRepository.save(seller);
        return seller;
    }
}
