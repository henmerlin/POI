package com.henmerlin.poi.asset.model;

import com.henmerlin.poi.asset.adapter.PointProvider;
import com.henmerlin.poi.generic.model.AbstractEntity;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractPointEntity extends AbstractEntity implements PointProvider {

    @Column(name = "latitude")
    private BigDecimal latitude;

    @Column(name = "longitude")
    private BigDecimal longitude;

    @Override
    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    @Override
    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }
}
