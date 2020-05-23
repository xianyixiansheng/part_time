package com.liyi.part_time.service.impl;

import com.liyi.part_time.entity.TbJob;
import com.liyi.part_time.entity.TbResume;
import com.liyi.part_time.dao.TbResumeDao;
import com.liyi.part_time.entity.TbResumeCollection;
import com.liyi.part_time.service.TbResumeService;
import com.liyi.part_time.util.LayuiPage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TbResume)表服务实现类
 *
 * @author makejava
 * @since 2020-03-24 00:28:08
 */
@Service("tbResumeService")
public class TbResumeServiceImpl implements TbResumeService {
    @Resource
    private TbResumeDao tbResumeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param resumeId 主键
     * @return 实例对象
     */
    @Override
    public TbResume queryById(Integer resumeId) {
        return this.tbResumeDao.queryById(resumeId);
    }

    @Override
    public TbResume queryByResumeId(Integer resumeId) {
        return this.tbResumeDao.queryByResumeId(resumeId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TbResume> queryAllByLimit(int offset, int limit) {
        return this.tbResumeDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<TbResume> queryAll(TbResume tbResume) {
        return this.tbResumeDao.queryAll(tbResume);
    }

    @Override
    public List<TbResume> queryByBusinessId(Integer id) {
        return this.tbResumeDao.queryByBusinessId(id);
    }
    /**
     * 新增数据
     *
     * @param tbResume 实例对象
     * @return 实例对象
     */
    @Override
    public TbResume insert(TbResume tbResume) {
        this.tbResumeDao.insert(tbResume);
        return tbResume;
    }

    /**
     * 修改数据
     *
     * @param tbResume 实例对象
     * @return 实例对象
     */
    @Override
    public TbResume update(TbResume tbResume) {
        this.tbResumeDao.update(tbResume);
        return this.queryById(tbResume.getResumeId());
    }

    /**
     * 通过主键删除数据
     *
     * @param resumeId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer resumeId) {
        return this.tbResumeDao.deleteById(resumeId) > 0;
    }


    @Override
    public boolean deleteByList(List<Integer> List) {
        int flag = tbResumeDao.batchDelete(List);
        return flag > 0;
    }

    @Override
    public LayuiPage<TbResume> getPage(int page, int limit, TbResume tbResume){

        int count = tbResumeDao.getCount(tbResume);
        List<TbResume> data= tbResumeDao.pageByCondition((page - 1) * limit, limit, tbResume);
        LayuiPage<TbResume> layPage = new LayuiPage<>(count, data);
        return layPage;
    }

    @Override
    public List<TbResume>  getPage(String eduschool){
        List<TbResume> tb = tbResumeDao.getPage(eduschool);
        return tb;
    }

}