package com.company;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Qualifier("test")
public class StdoutLogger implements ILog {
    // format des dates
    private final DateFormat format = new SimpleDateFormat(
            "yyyy/MM/dd hh:mm:ss | ");

    public void init() {
        System.out.println("Init " + this);
    }

    public void close() {
        System.out.println("Close " + this);
    }

    public void log(String message) {
        System.out.print(format.format(new Date()));
        System.out.println(message);
    }

    public void log(String message, String arg1) {
        log(message.replaceAll("\\$1", arg1));
    }

}