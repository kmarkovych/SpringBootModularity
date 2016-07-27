package com.example.modularity.controller;

import com.example.modularity.api.controller.PageController;
import com.example.modularity.service.PageControllerPostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Kmarkovych on 07-Jul-16.
 */
@RequestMapping(MainController.BASE_URL)
public class MainController implements PageController {

    protected static final String BASE_URL = "/";

    @Autowired
    PageControllerPostProcessor pageControllerPostProcessor;

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
        List<PageController> controllers = new LinkedList<>(pageControllerPostProcessor.getPageControllers());
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
