package com.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SimpleBusiness implements IBusiness {

    @Autowired
    @Qualifier("test")
    private ILog logger;

    public void init() {
        if (logger == null) {
            throw new IllegalStateException("null logger");
        }
        logger.log("Start " + this);
    }

    public void close() {
        logger.log("Stop " + this);
    }

    public int doAddition(int a, int b) {
        logger.log("doAddition(" + a + "," + b + ")");
        return (a + b);
    }

    public boolean doLogin(String name, String pass) {
        logger.log("doLogin(\"" + name + "\",\"" + pass + "\")");
        return (name.equals(pass));
    }

    public ILog getLogger() {
        return logger;
    }

    public void setLogger(ILog logger) {
        this.logger = logger;
    }

}