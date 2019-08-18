/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.henmerlin.poi.asset.dao;

import com.henmerlin.poi.asset.service.AssetFilter;
import com.henmerlin.poi.asset.service.aggregate.PoiMeetingAggregate;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author henrique merlin
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class AssetDAOIT {

    @Autowired
    private AssetDAO dao;

    public AssetDAOIT() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getInsidePoiPositions method, of class AssetDAO.
     */
    @Test
    public void testGetInsidePoiPositions() {
        try {
            System.out.println("getInsidePoiPositions");
            AssetFilter filter = new AssetFilter();
            filter.setAssetKey("");
            filter.setInitialDate(new Date(1l));
            filter.setFinalDate(new Date(10000000000l));
            
            
            List<PoiMeetingAggregate> results = dao.getInsidePoiPositions(filter);
            assertEquals(null, results);
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }

    }

}
