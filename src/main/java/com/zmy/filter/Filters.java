package com.zmy.filter;

import javax.servlet.annotation.WebFilter;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-17 9:35
 */
//@WebFilter(filterName = "filters",urlPatterns = "/student/*")
public class Filters implements Filter {
    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }

}
