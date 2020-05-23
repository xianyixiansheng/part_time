package com.liyi.part_time.dao;

import com.liyi.part_time.entity.TbJob;
import com.liyi.part_time.util.BaseDao;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TbJob)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-24 00:28:06
 */
public interface TbJobDao extends BaseDao<TbJob>{

    public int getNum();

    public int getCount(TbJob condition);

    public List<TbJob> pageByCondition(@Param("page") int page, @Param("limit") int limit,
                                         @Param("condition") TbJob condition);

    public int getCountWithTime(@Param("jobName") String jobName,@Param("contact") String contact, @Param("address") String address,
                        @Param("startDate") String startDate, @Param("endDate") String endDate);

    public List<TbJob> pageByConditionWithTime(@Param("page") int page, @Param("limit") int limit, @Param("jobName") String jobName,
                                               @Param("contact") String contact, @Param("address") String address,
                                       @Param("startDate") String startDate, @Param("endDate") String endDate);

    public List<TbJob> getJobByBusinessId(Integer id);

    public List<TbJob> getJobById(Integer id);

    public List<TbJob> getPageWithFK(String jobName);

    public List<TbJob> getListwithDelivery(@Param("id") Integer id,@Param("jobName") String jobName);

    public List<TbJob> queryJobWithInvite(@Param("id") Integer id,@Param("jobName") String jobName);

    public List<TbJob> getListwithCollection(Integer id);

    public List<TbJob> queryJobWithDeliveryandResume(@Param("jobId") Integer jobId,@Param("businessId") Integer businessId);

    public List<TbJob> queryJobWithDeliveryandnotnull(Integer businessId);

    public List<TbJob> queryJobWithDeliveryandjobnotnull(@Param("jobId") Integer jobId,@Param("businessId") Integer businessId);

    public List<TbJob> queryJobWithDelivery(@Param("id") Integer id,@Param("jobName") String jobName);
}