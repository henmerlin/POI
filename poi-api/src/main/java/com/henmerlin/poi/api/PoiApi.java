/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.7).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.henmerlin.poi.api;

import com.henmerlin.poi.api.Poi;
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

@Api(value = "poi", description = "the poi API")
public interface PoiApi {

    @ApiOperation(value = "Add a new POI", nickname = "addPoi", notes = "", tags={ "poi", })
    @ApiResponses(value = { 
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/poi",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> addPoi(@ApiParam(value = "poi object that needs to be added to the API" ,required=true )  @Valid @RequestBody Poi body);


    @ApiOperation(value = "Deletes a POI", nickname = "deletePoi", notes = "", tags={ "poi", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "POI not found") })
    @RequestMapping(value = "/poi/{poiId}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deletePoi(@ApiParam(value = "poi id to delete",required=true) @PathVariable("poiId") Long poiId);


    @ApiOperation(value = "Find POI by ID", nickname = "getPoiById", notes = "Returns a single POI", response = Poi.class, tags={ "poi", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Poi.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "poi not found") })
    @RequestMapping(value = "/poi/{poiId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Poi> getPoiById(@ApiParam(value = "ID of POI to return",required=true) @PathVariable("poiId") Long poiId);


    @ApiOperation(value = "Update an existing POI", nickname = "updatePoi", notes = "", tags={ "poi", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "POI not found"),
        @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/poi",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updatePoi(@ApiParam(value = "POI object that needs to be added" ,required=true )  @Valid @RequestBody Poi body);

}
