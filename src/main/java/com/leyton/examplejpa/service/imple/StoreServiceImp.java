
package com.leyton.examplejpa.service.imple;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leyton.examplejpa.dto.StoreDto;
import com.leyton.examplejpa.entity.Store;
import com.leyton.examplejpa.repository.StoreRepository;
import com.leyton.examplejpa.service.inter.StoreService;

@Service
public class StoreServiceImp implements StoreService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GroupingServiceImp.class);

    @Autowired
    private StoreRepository storeRepository;

    @Override
    public Set<StoreDto> findByPartnerEmail(String email) {
        return entitiesToDtos(storeRepository.findByPartnerEmail(email));
    }

    private StoreDto entityToDto(Store entity) {
        return new StoreDto(entity.getStoreId());
    }

    private Set<StoreDto> entitiesToDtos(List<Store> entities) {
        Set<StoreDto> dtos = new HashSet<>();
        entities.forEach(entity -> {
            try {
                StoreDto dto = entityToDto(entity);
                dtos.add(dto);
            } catch (Exception e) {
                LOGGER.error("Error converting store entity to dto... ", e);
            }
        });
        return dtos;
    }
}
