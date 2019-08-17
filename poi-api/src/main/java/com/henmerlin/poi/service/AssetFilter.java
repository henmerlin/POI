package com.henmerlin.poi.service;

import java.util.Date;

/**
 *
 * @author henrique merlin
 */
public class AssetFilter {

    private String assetKey;

    private Date initialDate;

    private Date finalDate;

    public AssetFilter() {
    }

    public String getAssetKey() {
        return assetKey;
    }

    public void setAssetKey(String assetKey) {
        this.assetKey = assetKey;
    }

    public Date getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

}
