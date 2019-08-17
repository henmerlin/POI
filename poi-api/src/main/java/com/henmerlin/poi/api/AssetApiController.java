package com.henmerlin.poi.api;

import com.henmerlin.poi.api.Asset;
import java.math.BigDecimal;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-08-17T01:30:19.128-03:00")

@Controller
public class AssetApiController implements AssetApi {

    private static final Logger log = LoggerFactory.getLogger(AssetApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public AssetApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addAsset(@ApiParam(value = "Asset object that needs to be added to the API" ,required=true )  @Valid @RequestBody Asset body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Asset>> getAssetByFilter(@ApiParam(value = "Key of Asset",required=true) @PathVariable("assetKey") String assetKey,@ApiParam(value = "Initial POI Event Date",required=true) @PathVariable("initialDate") BigDecimal initialDate,@ApiParam(value = "Initial POI Event Date",required=true) @PathVariable("finalDate") BigDecimal finalDate) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Asset>>(objectMapper.readValue("[ {  \"meeetings\" : [ {    \"assetId\" : 6,    \"meetingSeconds\" : 5,    \"poiId\" : 1  }, {    \"assetId\" : 6,    \"meetingSeconds\" : 5,    \"poiId\" : 1  } ],  \"id\" : 0,  \"key\" : \"key\"}, {  \"meeetings\" : [ {    \"assetId\" : 6,    \"meetingSeconds\" : 5,    \"poiId\" : 1  }, {    \"assetId\" : 6,    \"meetingSeconds\" : 5,    \"poiId\" : 1  } ],  \"id\" : 0,  \"key\" : \"key\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Asset>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Asset>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Asset> getAssetById(@ApiParam(value = "ID of Asset to return",required=true) @PathVariable("assetId") Long assetId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Asset>(objectMapper.readValue("{  \"meeetings\" : [ {    \"assetId\" : 6,    \"meetingSeconds\" : 5,    \"poiId\" : 1  }, {    \"assetId\" : 6,    \"meetingSeconds\" : 5,    \"poiId\" : 1  } ],  \"id\" : 0,  \"key\" : \"key\"}", Asset.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Asset>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Asset>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateAsset(@ApiParam(value = "Asset object that needs to be added" ,required=true )  @Valid @RequestBody Asset body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
