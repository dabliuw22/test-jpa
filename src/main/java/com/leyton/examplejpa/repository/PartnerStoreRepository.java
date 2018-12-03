
package com.leyton.examplejpa.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.leyton.examplejpa.entity.Partner;
import com.leyton.examplejpa.entity.PartnerStore;
import com.leyton.examplejpa.entity.Store;

public interface PartnerStoreRepository extends CrudRepository<PartnerStore, String> {

    public Set<PartnerStore> findByPartnerAndStoreIn(Partner partner, Set<Store> stores);
}
