package com.mpakhomov;

import com.mpakhomov.service.*;
import org.slf4j.*;
import org.springframework.context.support.*;

/**
 * Hello world!
 *
 */
public class XmlConfigStarter {

    private final static Logger LOG = LoggerFactory.getLogger(XmlConfigStarter.class);

    public static void main(String[] args) {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
        ctx.registerShutdownHook();
        QuoteService quoteService = ctx.getBean(QuoteService.class);
        quoteService.say("I'll be back!");
    }

}
