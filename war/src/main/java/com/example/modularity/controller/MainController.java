package com.example.modularity.controller;

import com.example.modularity.api.controller.PageController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

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

    /**
     * Creates JSON response with
     * "name" - name of available page
     * "url" - URL of available page
     *
     * @return
     */
    @RequestMapping(value = "services", produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    String services() {
        Map<String, PageController> beansOfType = ctx.getBeansOfType(PageController.class);
        List<PageController> controllers = new LinkedList<>(beansOfType.values());
        Comparator<PageController> comparator = new Comparator<PageController>() {
            @Override
            public int compare(PageController o1, PageController o2) {
                return o1.getOrder().compareTo(o2.getOrder());
            }
        };
        Collections.sort(controllers, comparator);
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < controllers.size(); i++) {
            PageController controller = controllers.get(i);
            result.append("{\"name\":\"").append(controller.getName()).append("\",")
                    .append("\"url\":\"").append(controller.getURL()).append("\"}");
            if (i < controllers.size() - 1) {
                result.append(",");
            } else {
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

    @Override
    public Integer getOrder() {
        return 0;
    }
}
