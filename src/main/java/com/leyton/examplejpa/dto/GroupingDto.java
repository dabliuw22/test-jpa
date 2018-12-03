
package com.leyton.examplejpa.dto;

import java.util.Set;

public class GroupingDto {

    private Long id;

    private String partner;

    private String name;

    private Set<StoreDto> stores;

    public GroupingDto() {
    }

    public GroupingDto(Long id, String partner, String name, Set<StoreDto> stores) {
        this.id = id;
        this.partner = partner;
        this.name = name;
        this.stores = stores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<StoreDto> getStores() {
        return stores;
    }

    public void setStores(Set<StoreDto> stores) {
        this.stores = stores;
    }

    @Override
    public String toString() {
        return "GroupingDto [id=" + id + ", partner=" + partner + ", name=" + name + ", stores="
                + stores + "]";
    }
}
