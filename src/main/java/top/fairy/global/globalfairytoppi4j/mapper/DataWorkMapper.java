package top.fairy.global.globalfairytoppi4j.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import top.fairy.global.globalfairytoppi4j.beans.DataWorkBean;

import java.util.List;

/**
 * @author jiao_zg22
 * @version 1.0
 * @description 如果多源数据库是相同的表结构和表名，使用该配置。
 * @date 2021/6/18 14:31
 */
@Mapper
@DS("taos")
public interface DataWorkMapper {
    /**
     * 未加注解，继承自类上的数据源。如果类上数据源也未加，则使用默认数据源
     * @description:查询时序数据列表
     * @author: jiao_zg22
     * @time: 2021/6/18 14:43
     */
    List<DataWorkBean> findAllDataWork();

    /**
     *
     * @description:插入时序数据
     * @author: jiao_zg22
     * @time: 2021/6/18 14:44
     */
    @DS("taos") //方法上的数据源会覆盖类上的。
    int insertDataWork(DataWorkBean dataWorkBean);

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
