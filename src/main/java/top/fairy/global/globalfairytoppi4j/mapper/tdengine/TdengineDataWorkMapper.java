package top.fairy.global.globalfairytoppi4j.mapper.tdengine;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import top.fairy.global.globalfairytoppi4j.beans.DataWorkBean;

import java.util.List;

/**
 * @author jiao_zg22
 * @version 1.0
 * @description 数据处理 如果是dengine数据库，并且与其他数据源的表是不同的
 * @date 2021/6/18 14:31
 */
@Mapper
public interface TdengineDataWorkMapper {
    /**
     *
     * @description:查询时序数据列表
     * @author: jiao_zg22
     * @time: 2021/6/18 14:43
     */
    List<DataWorkBean> findAllDataWork();

//    /**
//     *
//     * @description:插入时序数据
//     * @author: jiao_zg22
//     * @time: 2021/6/18 14:44
//     */
//    int insertDataWork(DataWorkBean dataWorkBean);

//    /**
//     *
//     * @description:更新时序数据
//     * @author: jiao_zg22
//     * @time: 2021/6/18 14:44
//     */
//    int updateDataWork(DataWorkBean usdataWorkBeaner);
//
//    /**
//     *
//     * @description:删除时序数据
//     * @author: jiao_zg22
//     * @time: 2021/6/18 14:44
//     */
//    int deleteDataWork(int id);
//
//    /**
//     *
//     * @description:查询时序数据详情
//     * @author: jiao_zg22
//     * @time: 2021/6/18 14:44
//     */
//    List<DataWorkBean> findById(int id);
}
