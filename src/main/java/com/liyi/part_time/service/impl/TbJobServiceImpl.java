package com.liyi.part_time.service.impl;

import com.liyi.part_time.entity.TbAdmin;
import com.liyi.part_time.entity.TbBusiness;
import com.liyi.part_time.entity.TbJob;
import com.liyi.part_time.dao.TbJobDao;
import com.liyi.part_time.service.TbJobService;
import com.liyi.part_time.util.BaseController;
import com.liyi.part_time.util.LayuiPage;
import com.liyi.part_time.util.ResultMessage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TbJob)表服务实现类
 *
 * @author makejava
 * @since 2020-03-24 00:28:06
 */
@Service("tbJobService")
public class TbJobServiceImpl implements  TbJobService {
    @Resource
    private TbJobDao tbJobDao;

    /**
     * 通过ID查询单条数据
     *
     * @param jobId 主键
     * @return 实例对象
     */
    @Override
    public TbJob queryById(Integer jobId) {
        return this.tbJobDao.queryById(jobId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TbJob> queryAllByLimit(int offset, int limit) {
        return this.tbJobDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tbJob 实例对象
     * @return 实例对象
     */
    @Override
    public TbJob insert(TbJob tbJob) {
        this.tbJobDao.insert(tbJob);
        return tbJob;
    }

    /**
     * 修改数据
     *
     * @param tbJob 实例对象
     * @return 实例对象
     */
    @Override
    public TbJob update(TbJob tbJob) {
        this.tbJobDao.update(tbJob);
        return this.queryById(tbJob.getJobId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tbJobDao.deleteById(id) > 0;
    }


    @Override
    public boolean deleteByList(List<Integer> List) {
        int flag = tbJobDao.batchDelete(List);
        return flag > 0;
    }

    @Override
    public LayuiPage<TbJob> getPage(int page, int limit, TbJob tbjob){

        int count = tbJobDao.getCount(tbjob);
        List<TbJob> data= tbJobDao.pageByCondition((page - 1) * limit, limit, tbjob);
        LayuiPage<TbJob> layPage = new LayuiPage<>(count, data);
        return layPage;
    }

    @Override
    public LayuiPage<TbJob> getPageWithTime(int page, int limit, String condition){
        String[] params = condition.split(",");
        String jobName = params[0].equals("null")? null: params[0];
        String contact = params[1].equals("null")? null: params[1];
        String address = params[2].equals("null")? null: params[2];
        String startDate = params[3].equals("null")? null: params[3];
        String endDate = params[4].equals("null")? null: params[4];
        int count = tbJobDao.getCountWithTime(jobName,contact,address,startDate,endDate);
        List<TbJob> data= tbJobDao.pageByConditionWithTime((page - 1) * limit, limit, jobName,contact,address,startDate,endDate);
        LayuiPage<TbJob> layPage = new LayuiPage<>(count, data);
        return layPage;
    }

    @Override
    public List<TbJob>  getJobByBusinessId(Integer id){
        List<TbJob> tb = tbJobDao.getJobByBusinessId(id);
        return tb;
    }

    @Override
    public List<TbJob>  getJobById(Integer id){
        List<TbJob> tb = tbJobDao.getJobById(id);
        return tb;
    }

    @Override
    public List<TbJob>  getPageWithFK(String jobName){
        List<TbJob> tb = tbJobDao.getPageWithFK(jobName);
        return tb;
    }

    @Override
    public List<TbJob>  getListwithDelivery(Integer id, String jobName){
        List<TbJob> tb = tbJobDao.getListwithDelivery(id,jobName);
        return tb;
    }

    @Override
    public List<TbJob>  getListwithCollection(Integer id){
        List<TbJob> tb = tbJobDao.getListwithCollection(id);
        return tb;
    }


    @Override
    public List<TbJob>  queryJobWithDelivery(Integer id, String jobName){
        List<TbJob> tb = tbJobDao.queryJobWithDelivery(id,jobName);
        return tb;
    }

    @Override
    public List<TbJob>  queryJobWithInvite(Integer id, String jobName){
        List<TbJob> tb = tbJobDao.queryJobWithInvite(id,jobName);
        return tb;
    }

    @Override
    public List<TbJob>  queryJobWithDeliveryandResume(Integer jobId, Integer businessId){
        List<TbJob> tb = tbJobDao.queryJobWithDeliveryandResume(jobId,businessId);
        return tb;
    }

    @Override
    public List<TbJob>  queryJobWithDeliveryandnotnull(Integer businessId){
        List<TbJob> tb = tbJobDao.queryJobWithDeliveryandnotnull(businessId);
        return tb;
    }

    @Override
    public List<TbJob>  queryJobWithDeliveryandjobnotnull(Integer jobId, Integer businessId){
        List<TbJob> tb = tbJobDao.queryJobWithDeliveryandjobnotnull(jobId,businessId);
        return tb;
    }

    @Override
    public Integer getNum()
    {
        return tbJobDao.getNum();
    }
}