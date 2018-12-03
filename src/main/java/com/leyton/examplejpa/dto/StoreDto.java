
package com.leyton.examplejpa.dto;

public class StoreDto {

    private String id;

    private String name;

    public StoreDto() {
    }

    public StoreDto(String id) {
        this.id = id;
        this.name = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StoreDto [id=" + id + ", name=" + name + "]";
    }
}
