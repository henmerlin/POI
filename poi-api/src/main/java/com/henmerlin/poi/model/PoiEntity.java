package com.henmerlin.poi.model;

import com.henmerlin.poi.util.PointProvider;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class PoiEntity extends AbstractEntity implements PointProvider{

    private String name;

    @Column(name = "radius_meters")
    private BigDecimal radiusMeters;

    @Column(name = "latitude")
    private BigDecimal latitude;

    @Column(name = "longitude")
    private BigDecimal longitude;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getRadiusMeters() {
        return radiusMeters;
    }

    public void setRadiusMeters(BigDecimal radiusMeters) {
        this.radiusMeters = radiusMeters;
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
