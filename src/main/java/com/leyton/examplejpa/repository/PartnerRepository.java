
package com.leyton.examplejpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.leyton.examplejpa.entity.Partner;

public interface PartnerRepository extends CrudRepository<Partner, String> {

    public Partner findByEmail(String email);
}
