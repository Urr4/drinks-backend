package de.urr4.drinkmanagerbackend.services;

import de.urr4.drinkmanagerbackend.repositories.WineRepository;
import de.urr4.wine.entities.Wine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WineService {

    private final WineRepository wineRepository;

    @Autowired
    public WineService(WineRepository wineRepository) {
        this.wineRepository = wineRepository;
    }

    public List<Wine> getAllWines() {
        List<Wine> allWines = new ArrayList<>();
        wineRepository.findAll()
                .forEach(allWines::add);
        return allWines;
    }

    public Wine saveWine(Wine wine) {
        wineRepository.save(wine);
        return wine;
    }

}
