
package com.leyton.examplejpa.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(
        name = "partners")
@EntityListeners(
        value = {
            AuditingEntityListener.class
        })
public class Partner extends Auditable {

    @Transient
    private static final long serialVersionUID = -13720520988521306L;

    @Id
    @Column(
            name = "email")
    private String email;

    @Column(
            name = "country_id")
    private String countryId;

    @Column(
            name = "password")
    private String password;

    @OneToMany(
            mappedBy = "partner",
            cascade = CascadeType.ALL)
    private Set<PartnerStore> stores;

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public Set<PartnerStore> getStores() {
        return stores;
    }

    public void setStores(Set<PartnerStore> stores) {
        this.stores = stores;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Partner other = (Partner) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        return true;
    }
}
