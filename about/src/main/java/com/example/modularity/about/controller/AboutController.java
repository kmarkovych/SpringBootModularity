package com.example.modularity.about.controller;

import com.example.modularity.api.controller.PageController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by Kmarkovych on 08-Jul-16.
 */
@RequestMapping(AboutController.BASE_URL)
public class AboutController implements PageController {

    protected static final String BASE_URL = "/about";

    @RequestMapping(path = {"", "/"}, method = RequestMethod.GET)
    public String getPage(HttpSession session){
        return "about";
    }

    @Override
    public String getName() {
        return "About";
    }

    @Override
    public String getURL() {
        return BASE_URL;
    }
}