package com.lh.source_sets;

import org.junit.Test;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SourceSetsTest {

    @Test
    @Deprecated(since = "4.5",forRemoval = true)
    public void givenImmutableList_whenRun_ThenSuccess() {

        SourceSetsObject underTest = new SourceSetsObject("lorem", "ipsum");
        assertThat(underTest.getUser(), is("lorem"));
        assertThat(underTest.getPassword(), is("ipsum"));
    }
}