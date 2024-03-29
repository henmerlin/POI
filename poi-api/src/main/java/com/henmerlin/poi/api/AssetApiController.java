package com.henmerlin.poi.api;

import java.math.BigDecimal;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.henmerlin.poi.asset.adapter.AssetAdapter;
import com.henmerlin.poi.asset.service.AssetFilter;
import com.henmerlin.poi.asset.service.AssetService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-08-17T22:13:14.425-03:00")

@Controller
public class AssetApiController implements AssetApi {

    private static final Logger log = LoggerFactory.getLogger(AssetApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @PersistenceContext
    protected EntityManager entityManager;

    @Autowired
    @Qualifier("asset")
    private AssetService service;

    @Autowired
    public AssetApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public ResponseEntity<Void> addAsset(@ApiParam(value = "Asset object that needs to be added to the API", required = true) @Valid @RequestBody Asset body) {
        try {
            service.create(AssetAdapter.toEntity(body));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<Asset>> getAssetByFilter(@ApiParam(value = "Key of Asset") @Valid @RequestParam(value = "assetKey", required = false) String assetKey, @ApiParam(value = "Initial POI Event Date") @Valid @RequestParam(value = "initialDate", required = false) BigDecimal initialDate, @ApiParam(value = "Final POI Event Date") @Valid @RequestParam(value = "finalDate", required = false) BigDecimal finalDate) {
        try {
            final AssetFilter filter = new AssetFilter();
            filter.setAssetKey(assetKey);
            filter.setInitialDate(new Date(initialDate.longValue()));
            filter.setFinalDate(new Date(finalDate.longValue()));
            return new ResponseEntity(service.getAssetByFilter(filter), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Asset> getAssetById(@ApiParam(value = "ID of Asset to return", required = true) @PathVariable("assetId") Long assetId) {
        try {
            return new ResponseEntity<>(AssetAdapter.adaptEntity(service.findById(assetId.intValue())), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Void> updateAsset(@ApiParam(value = "Asset object that needs to be added", required = true) @Valid @RequestBody Asset body) {
        try {
            service.update(AssetAdapter.toEntity(body));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Void> deleteAsset(@ApiParam(value = "Asset id to delete", required = true) @PathVariable("assetId") Long assetId) {
        try {
            service.deleteById(assetId.intValue());
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public ResponseEntity<List<Asset>> findAllAssets() {
        try {
            return new ResponseEntity(AssetAdapter.adaptEntities(service.findAll()), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
