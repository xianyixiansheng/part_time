package com.liyi.part_time.dao;

import com.liyi.part_time.entity.TbResumeCollection;
import com.liyi.part_time.util.BaseDao;
import org.apache.ibatis.annotations.Param;


/**
 * (TbResumeCollection)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-24 00:28:08
 */
public interface TbResumeCollectionDao extends BaseDao<TbResumeCollection> {
    public TbResumeCollection queryByResumeId(@Param("resumeId") Integer resumeId,@Param("businessid") Integer businessid);
}