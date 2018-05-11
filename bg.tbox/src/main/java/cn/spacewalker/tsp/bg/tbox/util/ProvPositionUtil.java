package cn.spacewalker.tsp.bg.tbox.util;

import cn.spacewalker.tsp.bg.tbox.simulator.model.ProvPosition;
import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by steven ma
 * 2017/8/23 16:34
 */

public class ProvPositionUtil {

    private static String fileName = ProvPositionUtil.class.
            getResource("/ProvPosition.txt").getFile();
           // + "/ProvPosition.txt";

    public static List<ProvPosition> readFile() {

        List<ProvPosition> provPositionList = new ArrayList<>();

        try {
            String encoding = "UTF-8";
            fileName = URLDecoder.decode(fileName,"UTF-8");

//            File file = new File(fileName);
//            String str = FileUtils.readFileToString(file, "UTF-8");
//            System.out.println(str);

            File file = new File(fileName);
            if (file.isFile() && file.exists()) { //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {

                    //System.out.println(lineTxt);

                    String[] lnglat= lineTxt.split(" ");
                    if(lnglat.length != 3) {
                        System.out.println("[readFile，Error]" + lineTxt +
                        "len:" + lnglat.length);
                        continue;
                    }

                    ProvPosition position = new ProvPosition();
                    position.setCity(lnglat[0]);
                    position.setLng(lnglatFormat(lnglat[1]));
                    position.setLat(lnglatFormat(lnglat[2]));

                    provPositionList.add(position);

                }
                read.close();
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }


        return provPositionList;
    }

    //要将经纬度格式化
    public static String lnglatFormat(String lnglat) {
        //转成double
        double dval = Double.valueOf(lnglat);
        dval = dval * 1000000;

        return String.format("%.0f", dval);


    }

    public static void main(String argv[]){

        System.out.println(lnglatFormat("22.34"));
        List<ProvPosition> positions = readFile();

        int cnt = 0;
        for(ProvPosition pos: positions) {
            cnt ++;
            System.out.print("[" + cnt + "]");
            System.out.println(pos);
        }

        //System.out.println(fileName);

    }


}
