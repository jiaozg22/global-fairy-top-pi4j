package top.fairy.global.globalfairytoppi4j.action;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.fairy.global.globalfairytoppi4j.basic.Car;
import top.fairy.global.globalfairytoppi4j.basic.MoveTypeEnum;
import top.fairy.global.globalfairytoppi4j.beans.DataWorkBean;
import top.fairy.global.globalfairytoppi4j.service.IDataWorkService;

import javax.annotation.Resource;

/**
 * @author jiao_zg22
 * @version 1.0
 * @description 测试数据库
 *
 * @date 2022/17/59 23:11
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {
    private static final Logger logger = LogManager.getLogger();

    @Resource
    IDataWorkService iDataWorkService;

    @RequestMapping(value = "/user" , method = RequestMethod.GET)
    String getUser(@RequestParam(value = "speed") String speed) {
        logger.info("speed",speed);

        DataWorkBean dataWorkBean = new DataWorkBean();
        dataWorkBean.setSpeed(speed);
        dataWorkBean.setTs(1);
        iDataWorkService.writeDate(dataWorkBean );
        return "运动...";
    }
}
