
package com.leyton.examplejpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
        name = "brands")
public class Brand implements Serializable {

    private static final long serialVersionUID = -8489836214213952708L;

    @Id
    @Column(
            name = "id")
    public String brandId;

    @Column(
            name = "brand_name")
    public String brandName;

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
