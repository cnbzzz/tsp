package cn.spacewalker.tsp.bg.tbox.config;

import cn.spacewalker.tsp.bg.tbox.config.SimulatorConfig;
import cn.spacewalker.tsp.bg.tbox.config.TboxConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest //(classes = TboxConfig.class)
//@EnableConfigurationProperties(TboxConfig.class)
public class TspConfigTest {

    @Autowired
    private TboxConfig myconfig;

    @Autowired
    private SimulatorConfig simulatorConfig;

    @Test
    public void getConfTest() {
        System.out.println("config: " + myconfig);
        System.out.println("ip: " + myconfig.getIp());
        System.out.println("port: " + myconfig.getPort());
        System.out.println("sim:" + simulatorConfig);
    }

}