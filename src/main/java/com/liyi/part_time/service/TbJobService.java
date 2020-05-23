package com.liyi.part_time.service;

import com.liyi.part_time.entity.TbJob;
import com.liyi.part_time.util.BaseService;
import com.liyi.part_time.util.LayuiPage;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * (TbJob)表服务接口
 *
 * @author makejava
 * @since 2020-03-24 00:28:06
 */
public interface TbJobService extends  BaseService<TbJob>{

    public Integer getNum();

    public List<TbJob> getJobByBusinessId(Integer id);

    public List<TbJob> getJobById(Integer id);

    public List<TbJob> getPageWithFK(String jobName);

    public LayuiPage<TbJob> getPageWithTime(int page, int limit, String condition);

    public List<TbJob> getListwithDelivery(Integer id,String jobName);
    public List<TbJob> getListwithCollection(Integer id);
    public List<TbJob> queryJobWithInvite(Integer id,String jobName);
    public List<TbJob> queryJobWithDelivery(Integer id,String jobName);

    public List<TbJob> queryJobWithDeliveryandResume(Integer jobId, Integer businessId);

    public List<TbJob> queryJobWithDeliveryandnotnull(Integer businessId);

    public List<TbJob> queryJobWithDeliveryandjobnotnull(Integer jobId, Integer businessId);
}