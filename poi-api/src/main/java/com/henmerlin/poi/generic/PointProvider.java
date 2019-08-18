/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.henmerlin.poi.generic;

import java.math.BigDecimal;

/**
 *
 * @author henrique merlin
 */
public interface PointProvider {

    BigDecimal getLatitude();

    BigDecimal getLongitude();
}
