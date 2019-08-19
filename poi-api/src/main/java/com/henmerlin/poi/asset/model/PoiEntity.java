package com.henmerlin.poi.asset.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(schema = "domain", name = "poi")
@Inheritance(strategy = InheritanceType.JOINED)
public class PoiEntity extends AbstractPointEntity {

    private String name;

    @Column(name = "radius_meters")
    private BigDecimal radiusMeters;

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

}
