package com.example.modularity.service;

import com.example.modularity.api.controller.PageController;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by kmarkovych on 27-Jul-16.
 */
public class PageControllerPostProcessor implements BeanPostProcessor {
    final List<PageController> pageControllers = new LinkedList<>();
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        if (o instanceof PageController) {
            pageControllers.add((PageController) o);
        }
        return o;
    }

    public List<PageController> getPageControllers() {
        return pageControllers;
    }
}
