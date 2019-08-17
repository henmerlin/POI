/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.henmerlin.poi.service;

import com.henmerlin.poi.service.aggregate.InterestMeetingAggregate;
import java.util.List;

/**
 *
 * @author henrique merlin
 */
public interface InterestMeetingService {

    List<InterestMeetingAggregate> getMeetings();

}
