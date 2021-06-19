package top.fairy.global.globalfairytoppi4j.service.impl;

import org.springframework.stereotype.Service;
import top.fairy.global.globalfairytoppi4j.beans.DataWorkBean;
import top.fairy.global.globalfairytoppi4j.mapper.tdengine.DataWorkMapper;
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
    DataWorkMapper dataWorkMapper;

    @Override
    public boolean writeDate(DataWorkBean bean) {
        int result = dataWorkMapper.insertDataWork(bean);
        return result > 0 ? true : false;
    }
}
