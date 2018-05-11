package cn.spacewalker.tsp.bg.tbox.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by steven ma
 * 2017/8/24 23:04
 */

@Component
@ConfigurationProperties(prefix = "tspserver" )
public class TboxConfig {

    private String ip;
    private String port;


    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
