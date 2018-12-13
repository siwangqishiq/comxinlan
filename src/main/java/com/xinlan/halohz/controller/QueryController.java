package com.xinlan.halohz.controller;

import com.xinlan.halohz.model.Result;
import com.xinlan.halohz.model.Sexy;
import com.xinlan.halohz.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class QueryController {
    @Autowired
    private QueryService queryService;

    @RequestMapping(value = "/search", method = {RequestMethod.POST, RequestMethod.GET})
    public Result<List<Sexy>> search(String query, HttpSession session) {
        System.out.println("seach = " + query);
        Result<List<Sexy>> result = new Result<List<Sexy>>();
        result.setSuccessData(queryService.querySexyList(query));
        return result;
    }
}//end class
