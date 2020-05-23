package com.liyi.part_time.service.impl;

import com.liyi.part_time.entity.TbJobCollection;
import com.liyi.part_time.dao.TbJobCollectionDao;
import com.liyi.part_time.service.TbJobCollectionService;
import com.liyi.part_time.util.LayuiPage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TbJobCollection)表服务实现类
 *
 * @author makejava
 * @since 2020-03-24 00:28:05
 */
@Service("tbJobCollectionService")
public class TbJobCollectionServiceImpl implements TbJobCollectionService {
    @Resource
    private TbJobCollectionDao tbJobCollectionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param jobId 主键
     * @return 实例对象
     */
    @Override
    public TbJobCollection queryById(Integer jobId) {
        return this.tbJobCollectionDao.queryById(jobId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TbJobCollection> queryAllByLimit(int offset, int limit) {
        return this.tbJobCollectionDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tbJobCollection 实例对象
     * @return 实例对象
     */
    @Override
    public TbJobCollection insert(TbJobCollection tbJobCollection) {
        this.tbJobCollectionDao.insert(tbJobCollection);
        return tbJobCollection;
    }

    /**
     * 修改数据
     *
     * @param tbJobCollection 实例对象
     * @return 实例对象
     */
    @Override
    public TbJobCollection update(TbJobCollection tbJobCollection) {
        this.tbJobCollectionDao.update(tbJobCollection);
        return this.queryById(tbJobCollection.getJobCollectionId());
    }

    /**
     * 通过主键删除数据
     *
     * @param jobId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer jobId) {
        return this.tbJobCollectionDao.deleteById(jobId) > 0;
    }

    @Override
    public boolean deleteByList(List<Integer> List) {
        int flag = tbJobCollectionDao.batchDelete(List);
        return flag > 0;
    }

    @Override
    public LayuiPage<TbJobCollection> getPage(int page, int limit,TbJobCollection tbJobCollection){

        int count = tbJobCollectionDao.getCount(tbJobCollection);
        List<TbJobCollection> data= tbJobCollectionDao.pageByCondition((page - 1) * limit, limit, tbJobCollection);
        LayuiPage<TbJobCollection> layPage = new LayuiPage<>(count, data);
        return layPage;
    }

    @Override
    public TbJobCollection queryByJobIdandResumeId(Integer jobId,Integer resumeId) {
        return this.tbJobCollectionDao.queryByJobIdandResumeId(jobId,resumeId);
    }

}