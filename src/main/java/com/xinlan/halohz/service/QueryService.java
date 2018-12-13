package com.xinlan.halohz.service;

import com.xinlan.halohz.model.Sexy;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class QueryService {
    public static List<Sexy> dataList;


    public List<Sexy> querySexyList(String queryKey) {
        if (StringUtils.isEmpty(queryKey))
            return null;

        List<Sexy> result = new ArrayList<>();
        for (Sexy item : dataList) {
            if (item.getArea().contains(queryKey)
                    || item.getLocation().contains(queryKey)) {
                result.add(item);
            }
        }
        return result;
    }
}//end class
