package com.lh.spi.interfaces;

import java.util.List;

/**
 * @author lh
 */
public interface Search {

    /**
     * @param keyword search param
     * @return list
     */
    List<String> searchDoc(String keyword);
}
