package com.mpakhomov.service;

import org.junit.*;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

import org.springframework.beans.factory.config.*;
import org.springframework.context.*;
import org.springframework.context.support.*;

import java.util.*;

/**
 * @author: mpakhomov
 *
 * Load context & property file from main/resources
 */
public class QuoteServiceTest {

    private QuoteService quoteService;
    private ApplicationContext ctx;

    @Before
    public void setUp() {
        // Load context & property file from main/resources
        ctx = new ClassPathXmlApplicationContext("context.xml");
//        quoteService = (QuoteService) ctx.getBean("quoteService");
        quoteService = (QuoteService) ctx.getBean(QuoteService.class);
    }

    @Test
    public void testQuoteService() {
        quoteService.say("I'll be back");
        String prop = quoteService.getStringProperty();
        assertThat(prop, equalTo("Main"));
    }

    @Test
    public void testThatPropertyFileWasLoaded() {
        String prop = ((ConfigurableApplicationContext)ctx).getBeanFactory().resolveEmbeddedValue("${env}");
        assertThat(prop, equalTo("main"));
    }
}
