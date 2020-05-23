package com.liyi.part_time.service;

import com.liyi.part_time.entity.TbAdmin;
import com.liyi.part_time.entity.TbJob;
import com.liyi.part_time.util.BaseService;
import com.liyi.part_time.util.LayuiPage;

import java.util.Date;
import java.util.List;

/**
 * (TbAdmin)表服务接口
 *
 * @author makejava
 * @since 2020-03-24 00:25:56
 */
public interface TbAdminService extends BaseService<TbAdmin> {

    TbAdmin queryByName(String name);

    public LayuiPage<TbAdmin> getPageWithTime(int page, int limit, String condition);

  }