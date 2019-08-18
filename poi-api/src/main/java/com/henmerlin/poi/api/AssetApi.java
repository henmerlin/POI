/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.7).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.henmerlin.poi.api;

import com.henmerlin.poi.api.Asset;
import java.math.BigDecimal;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-08-17T22:13:14.425-03:00")

@Api(value = "asset", description = "the asset API")
public interface AssetApi {

    @ApiOperation(value = "Add a new Asset", nickname = "addAsset", notes = "", tags={ "asset", })
    @ApiResponses(value = { 
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/asset",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> addAsset(@ApiParam(value = "Asset object that needs to be added to the API" ,required=true )  @Valid @RequestBody Asset body);


    @ApiOperation(value = "Find Asset by Filter", nickname = "getAssetByFilter", notes = "Returns Asset and POI Events", response = Asset.class, responseContainer = "List", tags={ "asset", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Asset.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "poi not found") })
    @RequestMapping(value = "/asset/filter/",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Asset>> getAssetByFilter(@NotNull @ApiParam(value = "Key of Asset", required = true) @Valid @RequestParam(value = "assetKey", required = true) String assetKey,@NotNull @ApiParam(value = "Initial POI Event Date", required = true) @Valid @RequestParam(value = "initialDate", required = true) BigDecimal initialDate,@NotNull @ApiParam(value = "Initial POI Event Date", required = true) @Valid @RequestParam(value = "finalDate", required = true) BigDecimal finalDate);


    @ApiOperation(value = "Find Asset by ID", nickname = "getAssetById", notes = "Returns a single Asset", response = Asset.class, tags={ "asset", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Asset.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "poi not found") })
    @RequestMapping(value = "/asset/{assetId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Asset> getAssetById(@ApiParam(value = "ID of Asset to return",required=true) @PathVariable("assetId") Long assetId);


    @ApiOperation(value = "Update an existing Asset", nickname = "updateAsset", notes = "", tags={ "asset", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Asset not found"),
        @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/asset",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateAsset(@ApiParam(value = "Asset object that needs to be added" ,required=true )  @Valid @RequestBody Asset body);

}
