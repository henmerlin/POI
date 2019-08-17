package com.henmerlin.poi.api;

import com.henmerlin.poi.api.Poi;
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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-08-17T10:24:59.622-03:00")

@Controller
public class PoiApiController implements PoiApi {

    private static final Logger log = LoggerFactory.getLogger(PoiApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public PoiApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addPoi(@ApiParam(value = "poi object that needs to be added to the API" ,required=true )  @Valid @RequestBody Poi body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deletePoi(@ApiParam(value = "poi id to delete",required=true) @PathVariable("poiId") Long poiId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Poi> getPoiById(@ApiParam(value = "ID of POI to return",required=true) @PathVariable("poiId") Long poiId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Poi>(objectMapper.readValue("{  \"name\" : \"name\",  \"radiusMeters\" : 6.02745618307040320615897144307382404804229736328125,  \"id\" : 0,  \"lat\" : 1.46581298050294517310021547018550336360931396484375,  \"long\" : 5.962133916683182377482808078639209270477294921875}", Poi.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Poi>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Poi>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updatePoi(@ApiParam(value = "POI object that needs to be added" ,required=true )  @Valid @RequestBody Poi body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
