/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.henmerlin.poi.dao;

import com.henmerlin.poi.PoiApiApplicationTests;
import com.henmerlin.poi.service.aggregate.PoiAssetPositionAggregate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author henrique merlin
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = PoiApiApplicationTests.class)
public class AssetDAOIT {

    @Autowired
    private TestEntityManager tm;

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
            PoiAssetPositionAggregate expResult = null;
            dao = new AssetDAOImpl(tm.getEntityManager());
            PoiAssetPositionAggregate result = dao.getInsidePoiPositions();
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }

    }

}
