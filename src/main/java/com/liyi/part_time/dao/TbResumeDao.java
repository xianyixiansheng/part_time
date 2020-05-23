package com.liyi.part_time.dao;

import com.liyi.part_time.entity.TbJob;
import com.liyi.part_time.entity.TbResume;
import com.liyi.part_time.util.BaseDao;

import java.util.List;

/**
 * (TbResume)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-24 00:28:08
 */
public interface TbResumeDao extends BaseDao<TbResume> {

    public List<TbResume> getPage(String eduschool);

    public TbResume queryByResumeId(Integer id);

    public List<TbResume> queryByBusinessId(Integer id);
}