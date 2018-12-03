
package com.leyton.examplejpa.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(
        name = "partner_store_groupings")
@IdClass(
        value = PartnerStoreGroupingId.class)
public class PartnerStoreGrouping implements Serializable {

    private static final long serialVersionUID = 4467974598597887445L;

    @Id
    @JsonIgnore
    @ManyToOne(
            fetch = FetchType.LAZY)
    @JoinColumn(
            name = "grouping_id",
            foreignKey = @ForeignKey(
                    name = "partner_stores_groupings_pkey"))
    private Grouping grouping;

    @Id
    @ManyToOne(
            fetch = FetchType.LAZY)
    @JoinColumns(
            value = {
                @JoinColumn(
                        name = "partner_store_store_id",
                        referencedColumnName = "store_store_id"),
                @JoinColumn(
                        name = "partner_store_partner_email",
                        referencedColumnName = "partner_email")
            },
            foreignKey = @ForeignKey(
                    name = "partner_store_groupings_partner_stores_fkey"))
    private PartnerStore partnerStore;

    public PartnerStoreGrouping() {
    }

    public PartnerStoreGrouping(Grouping grouping, PartnerStore partnerStore) {
        this.grouping = grouping;
        this.partnerStore = partnerStore;
    }

    public Grouping getGrouping() {
        return grouping;
    }

    public void setGrouping(Grouping grouping) {
        this.grouping = grouping;
    }

    public PartnerStore getPartnerStore() {
        return partnerStore;
    }

    public void setPartnerStore(PartnerStore partnerStore) {
        this.partnerStore = partnerStore;
    }

    @Override
    public String toString() {
        return "PartnerStoreGrouping [partnerStore=" + partnerStore + "]";
    }
}
