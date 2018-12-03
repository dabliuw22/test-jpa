
package com.leyton.examplejpa.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leyton.examplejpa.dto.StoreDto;
import com.leyton.examplejpa.service.inter.StoreService;

@RestController
@RequestMapping(
        value = "/stores")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping
    public ResponseEntity<Set<StoreDto>> getGrouping(@RequestParam(
            value = "email",
            required = true) String email) {
        return ResponseEntity.ok(storeService.findByPartnerEmail(email));
    }
}
