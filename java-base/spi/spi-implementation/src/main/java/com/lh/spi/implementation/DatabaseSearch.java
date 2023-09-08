package com.lh.spi.implementation;

import com.lh.spi.interfaces.Search;

import java.util.Collections;
import java.util.List;

/**
 * @author lh
 */
public class DatabaseSearch implements Search {
    @Override
    public List<String> searchDoc(String keyword) {
        System.out.println("database search:" + keyword);
        return Collections.singletonList("database");
    }
}
