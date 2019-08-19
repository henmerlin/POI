package com.henmerlin.poi.asset.service;

import com.henmerlin.poi.asset.model.PoiEntity;
import com.henmerlin.poi.generic.GenericDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author henrique merlin
 */
@Service
@Qualifier("poi")
public class PoiServiceImpl extends GenericRestService<PoiEntity> {

    public PoiServiceImpl(@Autowired @Qualifier("poi") GenericDAO<PoiEntity> dao) {
        super(dao);
    }

}
