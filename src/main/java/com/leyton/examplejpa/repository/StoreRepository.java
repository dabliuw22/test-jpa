
package com.leyton.examplejpa.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.leyton.examplejpa.entity.Store;

public interface StoreRepository extends CrudRepository<Store, String> {

    @Query(
            value = "SELECT DISTINCT s FROM Store AS s JOIN FETCH s.brand WHERE s.storeId IN (?1)")
    public Set<Store> findByStoreIdIn(Set<String> storeIds);

    @Query(
            value = "SELECT DISTINCT s FROM Partner AS p JOIN p.stores AS ps JOIN ps.store AS s "
                    + "JOIN FETCH s.brand AS b WHERE p.email = ?1")
    public List<Store> findByPartnerEmail(String email);
}
