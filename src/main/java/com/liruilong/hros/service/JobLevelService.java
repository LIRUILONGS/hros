package com.liruilong.hros.service;

import com.liruilong.hros.mapper.JobLevelMapper;
import com.liruilong.hros.model.JobLevel;
import com.liruilong.hros.model.OpLog;
import com.liruilong.hros.model.Position;
import com.liruilong.hros.service.utils.Hruitls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Description :
 * @Date: 2019/12/26 13:17
 */
@Transactional
@Service
public class JobLevelService implements Serializable {

    @Autowired
    JobLevelMapper jobLevelMapper;
    @Autowired
    OplogService oplogService;


    public List<JobLevel> getAllJobLevels() {
        List<JobLevel> allJobLevels = jobLevelMapper.getAllJobLevels();
        return allJobLevels.stream().filter(Objects::nonNull).filter(JobLevel::getEnabled).collect(Collectors.toList());
    }

    public Integer addJobLevel(JobLevel jobLevel) {
        jobLevel.setCreatedate(new Date());
        jobLevel.setEnabled(true);
        oplogService.addOpLog(new OpLog((byte) 1, new Date(), "添加职称" + jobLevel.getName(), Hruitls.getCurrent().getName()));

        return jobLevelMapper.insertSelective(jobLevel);
    }

    public Integer updateJobLevelById(JobLevel jobLevel) {
        oplogService.addOpLog(new OpLog((byte) 1, new Date(), "更新职称" + jobLevel.getName(), Hruitls.getCurrent().getName()));

        return jobLevelMapper.updateByPrimaryKeySelective(jobLevel);
    }

    public Integer deleteJobLevelById(Integer id) {
        oplogService.addOpLog(new OpLog((byte) 1, new Date(), "删除职称 : id=" + id, Hruitls.getCurrent().getName()));

        return jobLevelMapper.deleteByPrimaryKey(id);
    }

    public Integer deleteJobLevelByIds(Integer[] ids) {
        oplogService.addOpLog(new OpLog((byte) 1, new Date(), "批量删除职称: ids=" + ids.toString(), Hruitls.getCurrent().getName()));

        return jobLevelMapper.deleteJobLevelByIds(ids);
    }

    public List<Position> serchJobLevel(JobLevel jobLevel) {
        jobLevel.setName("%" + jobLevel.getName() + "%");
        return jobLevelMapper.serchJobLeve(jobLevel);
    }

    public List<JobLevel> getRealAllJobLevels() {
        return jobLevelMapper.getAllJobLevels();
    }
}
