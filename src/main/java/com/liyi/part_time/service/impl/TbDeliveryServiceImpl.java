package com.liyi.part_time.service.impl;

import com.liyi.part_time.entity.TbAdmin;
import com.liyi.part_time.entity.TbDelivery;
import com.liyi.part_time.dao.TbDeliveryDao;
import com.liyi.part_time.entity.TbFeedback;
import com.liyi.part_time.service.TbDeliveryService;
import com.liyi.part_time.util.LayuiPage;
import com.liyi.part_time.vo.DeliveryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TbDelivery)表服务实现类
 *
 * @author makejava
 * @since 2020-03-24 00:28:07
 */
@Service("tbDeliveryService")
public class TbDeliveryServiceImpl implements TbDeliveryService {
    @Resource
    private TbDeliveryDao tbDeliveryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param delId 主键
     * @return 实例对象
     */
    @Override
    public TbDelivery queryById(Integer delId) {
        return this.tbDeliveryDao.queryById(delId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TbDelivery> queryAllByLimit(int offset, int limit) {
        return this.tbDeliveryDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tbDelivery 实例对象
     * @return 实例对象
     */
    @Override
    public TbDelivery insert(TbDelivery tbDelivery) {
        this.tbDeliveryDao.insert(tbDelivery);
        return tbDelivery;
    }

    /**
     * 修改数据
     *
     * @param tbDelivery 实例对象
     * @return 实例对象
     */
    @Override
    public TbDelivery update(TbDelivery tbDelivery) {
        this.tbDeliveryDao.update(tbDelivery);
        return this.queryById(tbDelivery.getDelId());
    }

    /**
     * 通过主键删除数据
     *
     * @param delId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer delId) {
        return this.tbDeliveryDao.deleteById(delId) > 0;
    }

    @Override
    public boolean deleteByList(List<Integer> List) {
        int flag = tbDeliveryDao.batchDelete(List);
        return flag > 0;
    }


    @Override
    public LayuiPage<TbDelivery> getPage(int page, int limit, TbDelivery tbDelivery){

        int count = tbDeliveryDao.getCount(tbDelivery);
        List<TbDelivery> data= tbDeliveryDao.pageByCondition((page - 1) * limit, limit, tbDelivery);
        LayuiPage<TbDelivery> layPage = new LayuiPage<>(count, data);
        return layPage;
    }

       @Override
    public TbDelivery queryByJobIdandResumeId(Integer jobId,Integer resumeId) {
        return this.tbDeliveryDao.queryByJobIdandResumeId(jobId,resumeId);
    }

    @Override
    public TbDelivery queryByJobIdwithResumeId(Integer jobId,Integer resumeId) {
        return this.tbDeliveryDao.queryByJobIdwithResumeId(jobId,resumeId);
    }
    @Override
    public List<TbDelivery> queryAllwithResumeId(Integer resumeId) {
        return this.tbDeliveryDao.queryAllwithResumeId(resumeId);
    }

    @Override
    public List<TbDelivery> queryAllwithResumeIdandOverTime(Integer resumeId) {
        return this.tbDeliveryDao.queryAllwithResumeIdandOverTime(resumeId);
    }
    @Override
    public TbDelivery updateStatewithDelivery(TbDelivery tbDelivery)
    {
        this.tbDeliveryDao.updateStatewithDelivery(tbDelivery);
        return this.queryById(tbDelivery.getDelId());
    }

    @Override
    public  DeliveryVO queryforEnd(Integer id)
    { ;
        return this.tbDeliveryDao.queryforEnd(id);
    }

}