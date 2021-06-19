package top.fairy.global.globalfairytoppi4j.action;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.fairy.global.globalfairytoppi4j.sound.RecordAndPlay;

/**
 * @author jiao_zg22
 * @version 1.0
 * @description 接口
 * 教程地址：https://blog.csdn.net/jiao_zg/category_10334151.html?spm=1001.2014.3001.5482
 * @date 2021/4/23 20:15
 */
@RestController
@RequestMapping(value = "/sound")
public class SoundController {
    private static final Logger logger = LogManager.getLogger();


    @RequestMapping(value = "/record/start", method = RequestMethod.POST)
    public String record() {
        logger.info("音频录制开始");

        new Thread() {
            @Override
            public void run() {

                try {
                    RecordAndPlay.play();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();


        return "音频录制结束";
    }

    @RequestMapping(value = "/record/stop", method = RequestMethod.POST)
    public String recordStop() {
        logger.info("音频录制停止");

        new Thread() {
            @Override
            public void run() {


                try {
                    RecordAndPlay.stop();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();


        return "音频录制停止";
    }
}
