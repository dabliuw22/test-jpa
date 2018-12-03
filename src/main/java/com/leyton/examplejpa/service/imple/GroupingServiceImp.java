
package com.leyton.examplejpa.service.imple;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leyton.examplejpa.dto.GroupingDto;
import com.leyton.examplejpa.dto.StoreDto;
import com.leyton.examplejpa.entity.Grouping;
import com.leyton.examplejpa.entity.Partner;
import com.leyton.examplejpa.entity.PartnerStore;
import com.leyton.examplejpa.entity.PartnerStoreGrouping;
import com.leyton.examplejpa.entity.Store;
import com.leyton.examplejpa.repository.GroupingRepository;
import com.leyton.examplejpa.repository.PartnerRepository;
import com.leyton.examplejpa.repository.PartnerStoreRepository;
import com.leyton.examplejpa.repository.StoreRepository;
import com.leyton.examplejpa.service.inter.GroupingService;

@Service
public class GroupingServiceImp implements GroupingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GroupingServiceImp.class);

    @Autowired
    private GroupingRepository groupingRepository;

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private PartnerRepository partnerRepository;

    @Autowired
    private PartnerStoreRepository partnerStoreRepository;

    @Override
    @Transactional
    public boolean save(GroupingDto grouping) {
        Grouping entity = dtoToEntity(grouping);
        LOGGER.info("dto: {}", grouping);
        entity = groupingRepository.save(entity);
        return entity.getId() != null;
    }

    @Override
    @Transactional(
            readOnly = true)
    public GroupingDto findById(Long id) {
        Grouping entity = groupingRepository.findById(id).orElse(null);
        return entity != null ? entityToDto(entity) : null;
    }

    @Override
    @Transactional(
            readOnly = true)
    public Set<GroupingDto> findByPartnerEmail(String email) {
        List<Grouping> groupings = groupingRepository.findByPartnerEmail(email);
        Set<GroupingDto> groupingDtos = new HashSet<>();
        groupings.forEach(grouping -> {
            if (grouping != null) {
                GroupingDto dto = entityToDto(grouping);
                groupingDtos.add(dto);
            }
        });
        return groupingDtos;
    }

    @Override
    @Transactional(
            readOnly = true)
    public Set<GroupingDto> findAll() {
        List<Grouping> groupings = (List<Grouping>) groupingRepository.findAll();
        Set<GroupingDto> groupingDtos = new HashSet<>();
        groupings.forEach(grouping -> {
            if (grouping != null) {
                GroupingDto dto = entityToDto(grouping);
                groupingDtos.add(dto);
            }
        });
        return groupingDtos;
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        boolean status = false;
        Grouping grouping = groupingRepository.findById(id).orElse(null);
        if (grouping != null) {
            groupingRepository.deleteById(id);
            status = true;
        }
        return status;
    }

    private GroupingDto entityToDto(Grouping entity) {
        Set<StoreDto> stores = new HashSet<>();
        String partner = "";
        try {
            partner = entity.getPartnerStores().stream().findFirst().orElse(null).getPartnerStore()
                    .getPartner().getEmail();
        } catch (NullPointerException e) {
        }
        entity.getPartnerStores().forEach(ps -> {
            Store s = ps.getPartnerStore().getStore();
            StoreDto store = new StoreDto(s.getStoreId());
            stores.add(store);
        });
        return new GroupingDto(entity.getId(), partner, entity.getName(), stores);
    }

    private Grouping dtoToEntity(GroupingDto dto) {
        Set<String> storesIds = dto.getStores().stream().filter(Objects::nonNull)
                .map(StoreDto::getId).collect(Collectors.toSet());
        Partner partner = partnerRepository.findByEmail(dto.getPartner());
        Set<Store> stores = storeRepository.findByStoreIdIn(storesIds);
        Set<PartnerStore> partnerStores =
                partnerStoreRepository.findByPartnerAndStoreIn(partner, stores);
        Grouping grouping = new Grouping(dto.getId(), dto.getName());
        List<PartnerStoreGrouping> partnerStoreGroupings = new ArrayList<>();
        partnerStores.forEach(ps -> {
            PartnerStoreGrouping psg = new PartnerStoreGrouping(grouping, ps);
            partnerStoreGroupings.add(psg);
        });
        grouping.setPartnerStores(partnerStoreGroupings);
        return grouping;
    }
}
