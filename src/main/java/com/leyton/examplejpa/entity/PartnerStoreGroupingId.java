
package com.leyton.examplejpa.entity;

import java.io.Serializable;

public class PartnerStoreGroupingId implements Serializable {

    private static final long serialVersionUID = -3712272948485832872L;

    private Grouping grouping;

    private PartnerStore partnerStore;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((grouping == null) ? 0 : grouping.hashCode());
        result = prime * result + ((partnerStore == null) ? 0 : partnerStore.hashCode());
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
        PartnerStoreGroupingId other = (PartnerStoreGroupingId) obj;
        if (grouping == null) {
            if (other.grouping != null)
                return false;
        } else if (!grouping.equals(other.grouping))
            return false;
        if (partnerStore == null) {
            if (other.partnerStore != null)
                return false;
        } else if (!partnerStore.equals(other.partnerStore))
            return false;
        return true;
    }
}
