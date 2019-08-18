package com.henmerlin.poi;

import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootApplication
@ComponentScan(
        basePackages = {
            "com.henmerlin.poi",
            "io.swagger.configuration"
        })
@EnableJpaRepositories(basePackages = "com.henmerlin.poi.dao")
@EntityScan(basePackages = "com.henmerlin.poi.model")
@SpringBootTest(
  classes = Application.class)
@TestPropertySource(
  locations = "classpath:application.properties")
public class PoiApiApplicationTests {

    @Test
    public void contextLoads() {
    }

}
