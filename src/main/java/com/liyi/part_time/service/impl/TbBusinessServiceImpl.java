package com.liyi.part_time.service.impl;

import com.liyi.part_time.entity.TbAdmin;
import com.liyi.part_time.entity.TbBusiness;
import com.liyi.part_time.dao.TbBusinessDao;
import com.liyi.part_time.entity.TbJobHunter;
import com.liyi.part_time.service.TbBusinessService;
import com.liyi.part_time.util.BaseController;
import com.liyi.part_time.util.LayuiPage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TbBusiness)表服务实现类
 *
 * @author makejava
 * @since 2020-03-24 00:28:06
 */
@Service("tbBusinessService")
public class TbBusinessServiceImpl implements TbBusinessService{
    @Resource
    private TbBusinessDao tbBusinessDao;

    /**
     * 通过ID查询单条数据
     *
     * @param businessId 主键
     * @return 实例对象
     */
    @Override
    public TbBusiness queryById(Integer businessId) {
        return this.tbBusinessDao.queryById(businessId);
    }


    @Override
    public TbBusiness queryByWxCode(String wxCode) {
        TbBusiness tbbusiness = tbBusinessDao.queryByWxCode(wxCode);
        return tbbusiness;
    }


    @Override
    public boolean setWxInfo(TbBusiness tbJobHunter) {
        int rows = tbBusinessDao.setWxInfo(tbJobHunter);
        return rows>0;
    }
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TbBusiness> queryAllByLimit(int offset, int limit) {
        return this.tbBusinessDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tbBusiness 实例对象
     * @return 实例对象
     */
    @Override
    public TbBusiness insert(TbBusiness tbBusiness) {
        this.tbBusinessDao.insert(tbBusiness);
        return tbBusiness;
    }

    /**
     * 修改数据
     *
     * @param tbBusiness 实例对象
     * @return 实例对象
     */
    @Override
    public TbBusiness update(TbBusiness tbBusiness) {
        this.tbBusinessDao.update(tbBusiness);
        return this.queryById(tbBusiness.getBusinessId());
    }

    /**
     * 通过主键删除数据
     *
     * @param businessId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer businessId) {
        return this.tbBusinessDao.deleteById(businessId) > 0;
    }

    @Override
    public boolean deleteByIdwithFK(Integer businessId) {
        return this.tbBusinessDao.deleteByIdwithFK(businessId) > 0;
    }


    @Override
    public boolean deleteByList(List<Integer> List) {
        int flag = tbBusinessDao.batchDelete(List);
        return flag > 0;
    }


    @Override
    public boolean deleteByListwithFK(List<Integer> List) {
        int flag = tbBusinessDao.batchDeletewithFK(List);
        return flag > 0;
    }


    @Override
    public LayuiPage<TbBusiness> getPage(int page, int limit, TbBusiness tbBusiness){

        int count = tbBusinessDao.getCount(tbBusiness);
        List<TbBusiness> data= tbBusinessDao.pageByCondition((page - 1) * limit, limit, tbBusiness);
        LayuiPage<TbBusiness> layPage = new LayuiPage<>(count, data);
        return layPage;
    }
    @Override
    public LayuiPage<TbBusiness> getPageWithAudit(int page, int limit, TbBusiness tbBusiness){

        int count = tbBusinessDao.getCountWithAudit(tbBusiness);
        List<TbBusiness> data= tbBusinessDao.pageByConditionWithAudit((page - 1) * limit, limit, tbBusiness);
        LayuiPage<TbBusiness> layPage = new LayuiPage<>(count, data);
        return layPage;
    }


    @Override
    public List<TbBusiness>  getDetail(Integer id){
        List<TbBusiness> tb = tbBusinessDao.getDetail(id);
        return tb;
    }

    @Override
    public boolean updateforbidden(Integer id)
    {
        int flag = this.tbBusinessDao.updateforbidden(id);
        return  flag>0;
    }

    @Override
    public boolean updatepass(Integer id)
    {
        int flag = this.tbBusinessDao.updatepass(id);
        return  flag>0;
    }


    @Override
    public Integer getNum()
    {
        return tbBusinessDao.getNum();
    }
}