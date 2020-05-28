package com.liyi.part_time.service;

import com.liyi.part_time.entity.TbDelivery;
import com.liyi.part_time.util.BaseService;
import com.liyi.part_time.vo.DeliveryVO;

import java.util.List;

/**
 * (TbDelivery)表服务接口
 *
 * @author makejava
 * @since 2020-03-24 00:28:07
 */
public interface TbDeliveryService extends BaseService<TbDelivery> {
    TbDelivery queryByJobIdandResumeId(Integer jobId,Integer resumeId);

    TbDelivery queryByJobIdwithResumeId(Integer jobId,Integer resumeId);

    List<TbDelivery> queryAllwithResumeId(Integer resumeId);

    List<TbDelivery> queryAllwithResumeIdandOverTime(Integer resumeId);

    List<TbDelivery> queryAllwithResumeIdandCancel(Integer resumeId);

    TbDelivery updateStatewithDelivery(TbDelivery tbDelivery);

    DeliveryVO queryforEnd(Integer id);
}