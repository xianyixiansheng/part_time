package com.liyi.part_time.service.impl;

import com.liyi.part_time.entity.TbResumeCollection;
import com.liyi.part_time.dao.TbResumeCollectionDao;
import com.liyi.part_time.service.TbResumeCollectionService;
import com.liyi.part_time.util.LayuiPage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TbResumeCollection)表服务实现类
 *
 * @author makejava
 * @since 2020-03-24 00:28:08
 */
@Service("tbResumeCollectionService")
public class TbResumeCollectionServiceImpl implements TbResumeCollectionService {
    @Resource
    private TbResumeCollectionDao tbResumeCollectionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param collectionId 主键
     * @return 实例对象
     */
    @Override
    public TbResumeCollection queryById(Integer collectionId) {
        return this.tbResumeCollectionDao.queryById(collectionId);
    }

    @Override
    public TbResumeCollection queryByResumeId(Integer resumeId,Integer businessid) {
        return this.tbResumeCollectionDao.queryByResumeId(resumeId,businessid);
    }


    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TbResumeCollection> queryAllByLimit(int offset, int limit) {
        return this.tbResumeCollectionDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tbResumeCollection 实例对象
     * @return 实例对象
     */
    @Override
    public TbResumeCollection insert(TbResumeCollection tbResumeCollection) {
        this.tbResumeCollectionDao.insert(tbResumeCollection);
        return tbResumeCollection;
    }

    /**
     * 修改数据
     *
     * @param tbResumeCollection 实例对象
     * @return 实例对象
     */
    @Override
    public TbResumeCollection update(TbResumeCollection tbResumeCollection) {
        this.tbResumeCollectionDao.update(tbResumeCollection);
        return this.queryById(tbResumeCollection.getCollectionId());
    }

    /**
     * 通过主键删除数据
     *
     * @param collectionId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer collectionId) {
        return this.tbResumeCollectionDao.deleteById(collectionId) > 0;
    }

    @Override
    public boolean deleteByList(List<Integer> List) {
        int flag = tbResumeCollectionDao.batchDelete(List);
        return flag > 0;
    }
    @Override
    public LayuiPage<TbResumeCollection> getPage(int page, int limit, TbResumeCollection tbResumeCollection){

        int count = tbResumeCollectionDao.getCount(tbResumeCollection);
        List<TbResumeCollection> data= tbResumeCollectionDao.pageByCondition((page - 1) * limit, limit, tbResumeCollection);
        LayuiPage<TbResumeCollection> layPage = new LayuiPage<>(count, data);
        return layPage;
    }

}