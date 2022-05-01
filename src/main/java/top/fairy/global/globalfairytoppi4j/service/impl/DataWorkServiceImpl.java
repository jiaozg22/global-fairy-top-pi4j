package top.fairy.global.globalfairytoppi4j.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.stereotype.Service;
import top.fairy.global.globalfairytoppi4j.beans.DataWorkBean;
import top.fairy.global.globalfairytoppi4j.mapper.DataWorkMapper;
import top.fairy.global.globalfairytoppi4j.mapper.mysql.MysqlDataWorkMapper;
import top.fairy.global.globalfairytoppi4j.service.IDataWorkService;

import javax.annotation.Resource;

/**
 * @author jiao_zg22
 * @version 1.0
 * @description 接口
 * @date 2021/6/18 13:46
 */
@Service
public class DataWorkServiceImpl implements IDataWorkService {

    @Resource
    MysqlDataWorkMapper mysqlDataWorkMapper;
    @Resource
    DataWorkMapper dataWorkMapper;
    @Override
    @DS("taos") //用来指定数据源
    public boolean writeDate(DataWorkBean bean) {
        int result = dataWorkMapper.insertDataWork(bean);
        return result > 0 ? true : false;
    }
}
