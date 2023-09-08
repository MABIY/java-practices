package com.lh.spi.test;


import com.lh.spi.interfaces.Search;

import java.util.ServiceLoader;

/**
 * @author lh
 */
public class Main {
    public static void main(String[] args) {
        ServiceLoader<Search> searches = ServiceLoader.load(Search.class);
        for (Search search : searches) {
            search.searchDoc("hello world");
        }
    }
}