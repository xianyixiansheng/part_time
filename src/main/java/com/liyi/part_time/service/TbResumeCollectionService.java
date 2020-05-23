package com.liyi.part_time.service;

import com.liyi.part_time.entity.TbResumeCollection;
import com.liyi.part_time.util.BaseService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TbResumeCollection)表服务接口
 *
 * @author makejava
 * @since 2020-03-24 00:28:08
 */
public interface TbResumeCollectionService extends BaseService<TbResumeCollection> {
    TbResumeCollection queryByResumeId(Integer resumeId,Integer businessid);
}