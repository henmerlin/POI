package com.henmerlin.poi.bean;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 *
 * @author henrique merlin
 */
@Component
@Primary
public class JacksonMapperBean {

    public ObjectMapper scmsObjectMapper() {
        ObjectMapper responseMapper = new ObjectMapper();
        return responseMapper;
    }
}
