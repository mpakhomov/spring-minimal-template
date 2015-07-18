package com.mpakhomov.service;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.*;
import org.springframework.context.expression.*;
import org.springframework.core.env.Environment;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author: mpakhomov
 *
 * Load context & property file from test/resources
 */
@ContextConfiguration(locations = {"classpath:/test-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class QuoteServiceTestWithSpringJUnitRunner {

    @Autowired
    private ApplicationContext ctx;

    @Autowired
    QuoteService quoteService;

    @Value("${env}")
    private String strProperty;

    @Test
    public void testQuoteService() {
        String prop = quoteService.getStringProperty();
        assertThat(prop, equalTo("Test"));
    }

    @Test
    public void testThatConfigurationFileWasLoaded() {
        assertThat(strProperty, equalTo("test"));
        Environment env = ctx.getEnvironment();
    }
}
