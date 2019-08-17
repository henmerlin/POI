package com.henmerlin.poi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(schema = "domain", name = "asset")
@Inheritance(strategy = InheritanceType.JOINED)
public class AssetEntity extends AbstractEntity {

    @NotEmpty
    @Column(name = "asset_key")
    private String assetKey;

    private String description;

    public String getAssetKey() {
        return assetKey;
    }

    public void setAssetKey(String assetKey) {
        this.assetKey = assetKey;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
