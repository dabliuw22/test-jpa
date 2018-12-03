
package com.leyton.examplejpa.entity;

import java.io.Serializable;

public class PartnerStoreId implements Serializable {

    private static final long serialVersionUID = 3262153727191681924L;

    private Store store;

    private Partner partner;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((partner == null) ? 0 : partner.hashCode());
        result = prime * result + ((store == null) ? 0 : store.hashCode());
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
        PartnerStoreId other = (PartnerStoreId) obj;
        if (partner == null) {
            if (other.partner != null)
                return false;
        } else if (!partner.equals(other.partner))
            return false;
        if (store == null) {
            if (other.store != null)
                return false;
        } else if (!store.equals(other.store))
            return false;
        return true;
    }

}
