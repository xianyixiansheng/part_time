package com.liyi.part_time.service;

import com.liyi.part_time.entity.TbDelivery;
import com.liyi.part_time.entity.TbJobCollection;
import com.liyi.part_time.util.BaseService;

import java.util.List;

/**
 * (TbJobCollection)表服务接口
 *
 * @author makejava
 * @since 2020-03-24 00:28:05
 */
public interface TbJobCollectionService extends BaseService<TbJobCollection> {

    TbJobCollection queryByJobIdandResumeId(Integer jobId,Integer resumeId);

}