
package com.leyton.examplejpa.service.inter;

import java.util.Set;

import com.leyton.examplejpa.dto.GroupingDto;

public interface GroupingService {

    public boolean save(GroupingDto grouping);

    public GroupingDto findById(Long id);

    public Set<GroupingDto> findByPartnerEmail(String email);

    public Set<GroupingDto> findAll();

    public boolean delete(Long id);
}
