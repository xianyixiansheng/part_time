package com.liyi.part_time.dao;

import com.liyi.part_time.entity.TbDelivery;
import com.liyi.part_time.entity.TbJobCollection;
import com.liyi.part_time.util.BaseDao;
import org.apache.ibatis.annotations.Param;


/**
 * (TbJobCollection)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-24 00:28:05
 */
public interface TbJobCollectionDao extends BaseDao<TbJobCollection> {
    public TbJobCollection queryByJobIdandResumeId(@Param("jobId") Integer jobId, @Param("resumeId")  Integer resumeId);
}