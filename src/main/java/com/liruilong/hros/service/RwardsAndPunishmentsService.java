package com.liruilong.hros.service;

import com.liruilong.hros.mapper.RwardsAndPunishmentsMapper;
import com.liruilong.hros.model.RwardsAndPunishments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description :

 * @Date: 2019/12/28 16:52
 */

@Service
public class RwardsAndPunishmentsService {

    @Autowired
    RwardsAndPunishmentsMapper rwardsAndPunishmentsMapper;

    public List<RwardsAndPunishments> getAllRwardsAndPunishments() {
        return  rwardsAndPunishmentsMapper.getAllRwardsAndPunishments();
    }
}
