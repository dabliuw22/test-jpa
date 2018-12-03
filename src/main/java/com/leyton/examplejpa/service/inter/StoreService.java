
package com.leyton.examplejpa.service.inter;

import java.util.Set;

import com.leyton.examplejpa.dto.StoreDto;

public interface StoreService {

    public Set<StoreDto> findByPartnerEmail(String email);
}
