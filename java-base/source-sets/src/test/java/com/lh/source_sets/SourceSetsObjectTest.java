package com.lh.source_sets;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author lh
 */
class SourceSetsObjectTest {

    @Test
    public void wehnRun_ThenSuccesss() {
        SourceSetsObject underTest = new SourceSetsObject("loram","ipusm");
        assertThat(underTest.getUser(), is("loram"));
        assertThat(underTest.getPassword(), is("ipusm"));
    }
}