package com.mpakhomov.service.impl;

import com.mpakhomov.service.*;
import org.slf4j.*;

/**
 * @author: mpakhomov
 */
public class QuoteSerivceImpl implements QuoteService {

    private final static Logger LOG = LoggerFactory.getLogger(QuoteSerivceImpl.class);

    private String strProperty;

    @Override
    public void say(String message) {
        LOG.info(message);
        LOG.info("String property: {}", strProperty);
    }

    @Override
    public String getStringProperty() {
        return strProperty;
    }

    public String getStrProperty() {
        return strProperty;
    }

    public void setStrProperty(String strProperty) {
        this.strProperty = strProperty;
    }
}
