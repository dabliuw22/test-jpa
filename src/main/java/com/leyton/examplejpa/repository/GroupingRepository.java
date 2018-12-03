
package com.leyton.examplejpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.leyton.examplejpa.entity.Grouping;

public interface GroupingRepository extends CrudRepository<Grouping, Long> {

    @Query(
            value = "SELECT DISTINCT g FROM Grouping AS g JOIN FETCH g.partnerStores AS pss "
                    + "JOIN FETCH pss.partnerStore AS ps JOIN FETCH ps.partner AS p "
                    + "JOIN FETCH ps.store AS s JOIN FETCH s.brand AS b WHERE p.email = ?1")
    public List<Grouping> findByPartnerEmail(String email);
}
