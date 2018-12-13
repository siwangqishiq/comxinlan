package com.xinlan.halohz.service;

import com.alibaba.fastjson.JSONArray;
import com.xinlan.halohz.model.Sexy;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.Scanner;

@Component
public class LoadData implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("应用启动 。。。。。");
        System.out.println("导入数据 。。。。。");

        long t1 = System.currentTimeMillis();
        loadDatabase();
        long t2 = System.currentTimeMillis();
        System.out.println("导入数据耗时 = " + (t2 - t1));

        System.out.println("数据总量 = " + QueryService.dataList.size());
    }

    private void loadDatabase() {
        InputStreamReader reader = null;
        try {
            File jsonFile = ResourceUtils.getFile("classpath:data.json");
            String content = new Scanner(jsonFile).useDelimiter("\\Z").next();
            //System.out.println("content = " + content);
            QueryService.dataList = JSONArray.parseArray(content, Sexy.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}//end class
