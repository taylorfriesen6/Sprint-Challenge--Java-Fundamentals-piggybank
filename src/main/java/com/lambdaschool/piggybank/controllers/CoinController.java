package com.lambdaschool.piggybank.controllers;

import com.lambdaschool.piggybank.models.Coin;
import com.lambdaschool.piggybank.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CoinController {
    @Autowired
    private CoinRepository coinRepository;

    @GetMapping(value = "/total")
    public ResponseEntity<Void> total() {
        double total = 0;
        for (Coin coin: coinRepository.findAll()) {
            total += coin.getQuantity() * coin.getValue();
            System.out.println(
                    coin.getQuantity() + " "
                    + (coin.getQuantity() > 1 ? coin.getNameplural() : coin.getName())
            );
        }
        System.out.println("The piggy bank holds " + total);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
