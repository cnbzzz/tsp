package cn.spacewalker.tsp.bg.tbox.simulator.service.impl;

import cn.spacewalker.tsp.bg.pojo.dto.Gbt32960Msg;
import cn.spacewalker.tsp.bg.tbox.constant.ActionConstant;
import cn.spacewalker.tsp.bg.tbox.simulator.model.Vehicle;
import cn.spacewalker.tsp.bg.tbox.simulator.service.ScriptService;
import com.alibaba.fastjson.JSON;
import io.netty.channel.ChannelHandlerContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static cn.spacewalker.tsp.bg.tbox.client.TBoxClientHandler.getGbt32960Msg;
import static cn.spacewalker.tsp.bg.tbox.client.TBoxClientHandler.readFile;

/**
 * Created by steven ma
 * 2017/8/24 9:39
 */

@Component
public class SendByFileServiceImpl implements ScriptService {

    private Logger log = LogManager.getLogger(this.getClass().getName());

    private String path = "/tboxpack/upLoadRealTime.json";

    public  Gbt32960Msg getUploadRealTimeData()  {

        String json = null;
        try {
            json = readFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gbt32960Msg msg = JSON.parseObject(json, Gbt32960Msg.class);

        return msg;
    }

    @Override
    public void action(ChannelHandlerContext ctx) {
        log.info("SendByFileServiceImpl action()");
        ctx.writeAndFlush(getUploadRealTimeData());
    }
}
