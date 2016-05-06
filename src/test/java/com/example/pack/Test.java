package com.example.pack;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.ClassRule;

public class Test {

    @ClassRule
    public static WebServer server = new WebServer();

    @org.junit.Test
    public void test() {
        assertThat(true, is(true));
    }
}
