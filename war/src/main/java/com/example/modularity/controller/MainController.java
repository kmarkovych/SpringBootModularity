package com.example.modularity.controller;

import com.example.modularity.api.controller.PageController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.Set;

/**
 * Created by Kmarkovych on 07-Jul-16.
 */
@RequestMapping(MainController.BASE_URL)
public class MainController implements PageController {

    protected static final String BASE_URL = "/";

    @Autowired
    ApplicationContext ctx;

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "services", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String services() {
        Map<String, PageController> beansOfType = ctx.getBeansOfType(PageController.class);
        StringBuilder result = new StringBuilder("[");
        Set<Map.Entry<String, PageController>> entries = beansOfType.entrySet();
        int size = entries.size();
        int counter = 0;
        for (Map.Entry<String, PageController> entry : entries) {
            PageController value = entry.getValue();
            result.append("{\"name\":\"").append(value.getName()).append("\",")
            .append("\"url\":\"").append(value.getURL()).append("\"}");
            if (++counter < size) {
                result.append(",");
            }else {
                result.append("]");
            }
        }
        return result.toString();
    }

    @Override
    public String getName() {
        return "Home";
    }

    @Override
    public String getURL() {
        return BASE_URL;
    }
}
