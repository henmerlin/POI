package com.henmerlin.poi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootApplication(scanBasePackages = {"com.henmerlin"})
@ComponentScan(basePackages = {"com.henmerlin", "io.swagger.configuration"})
@EnableJpaRepositories(basePackages = "com.henmerlin")
@EntityScan(basePackages = "com.henmerlin.poi")
@TestPropertySource(locations = "classpath:application.properties")
public class PoiApiApplicationTests {

    @Test
    public void contextLoads() {
    }

}
