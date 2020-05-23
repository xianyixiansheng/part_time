package com.liyi.part_time.service;

import com.liyi.part_time.entity.TbJob;
import com.liyi.part_time.entity.TbResume;
import com.liyi.part_time.util.BaseService;

import java.util.List;

/**
 * (TbResume)表服务接口
 *
 * @author makejava
 * @since 2020-03-24 00:28:08
 */
public interface TbResumeService extends BaseService<TbResume> {
    public List<TbResume> getPage(String eduschool);

    public TbResume queryByResumeId(Integer id);

    public List<TbResume> queryByBusinessId(Integer id);

    List<TbResume> queryAll(TbResume tbResume);
}