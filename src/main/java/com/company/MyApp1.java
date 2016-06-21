package com.company;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp1 {

    // Utilisation du service "logger"
    void use(ILog logger) {
        logger.log("result = $1", "hello");
    }

    // Utilisation du service "business"
    void use(IBusiness business) {
        System.out.println("use addition: " + business.doAddition(4, 5));
        System.out.println("use login: " + business.doLogin("Olivier", "Olivier"));
    }

    // integration
    void run() {

        // *** logger only

        // 1st implantation
        //StderrLogger logger = new StderrLogger();

        // 2nd implantation
        //FileLogger logger = new FileLogger("/temp/myapp.log");

        // 3rd implantation
        //BeanFileLogger logger = new BeanFileLogger();
        //logger.setFileName("/temp/myapp.log");

        // cmn part
        //logger.init();
        //use(logger);
        //logger.close();

        // *** logger + business

        // creation de la couche logger
        // 1st implantation
        //StderrLogger logger = new StderrLogger();
        // 2nd implantation
        //BeanFileLogger logger = new BeanFileLogger();
        //logger.setFileName("/temp/myapp.log");

        // cmn part
        //logger.init();
        // creation de la couche metier
        //SimpleBusiness business = new SimpleBusiness();
        //business.setLogger(logger);
        //business.init();
        // utiliser la couche metier
        //use(business);
        // fermer la couche metier
        //business.close();
        // fermer la couche logger
        //logger.close();

        String conf = "spring.xml";
        AbstractApplicationContext context = new ClassPathXmlApplicationContext(conf);
        context.registerShutdownHook();

        // recuperer les beans
        //ILog logger = context.getBean("logger", ILog.class);

        IBusiness business = context.getBean(IBusiness.class);

        use(business);
    }

    public static void main(String[] args) {
        MyApp1 app = new MyApp1();
        app.run();
    }

}