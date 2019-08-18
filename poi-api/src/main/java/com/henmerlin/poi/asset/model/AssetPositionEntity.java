package com.henmerlin.poi.asset.model;

import com.henmerlin.poi.generic.model.AbstractEntity;
import com.henmerlin.poi.generic.PointProvider;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(schema = "domain", name = "asset_position")
@Inheritance(strategy = InheritanceType.JOINED)
public class AssetPositionEntity extends AbstractEntity implements PointProvider {

    @NotEmpty
    @Column(name = "asset_key")
    private String assetKey;

    @Column(name = "ignition")
    private Boolean ignition;

    @Column(name = "speed")
    private BigDecimal speed;

    @Column(name = "position_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date positionDate;

    @Column(name = "latitude")
    private BigDecimal latitude;

    @Column(name = "longitude")
    private BigDecimal longitude;

    public String getAssetKey() {
        return assetKey;
    }

    public void setAssetKey(String assetKey) {
        this.assetKey = assetKey;
    }

    public Boolean getIgnition() {
        return ignition;
    }

    public void setIgnition(Boolean ignition) {
        this.ignition = ignition;
    }

    public BigDecimal getSpeed() {
        return speed;
    }

    public void setSpeed(BigDecimal speed) {
        this.speed = speed;
    }

    public Date getPositionDate() {
        return positionDate;
    }

    public void setPositionDate(Date positionDate) {
        this.positionDate = positionDate;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

}
