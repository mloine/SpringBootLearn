package com.xyk.springboot.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;

import java.util.Iterator;

public class HelloSpringApplicationRunListener implements SpringApplicationRunListener{

    private final SpringApplication application;
    private final String[] args;
    private final SimpleApplicationEventMulticaster initialMulticaster;

    public HelloSpringApplicationRunListener(SpringApplication application, String[] args) {
        this.application = application;
        this.args = args;
        this.initialMulticaster = new SimpleApplicationEventMulticaster ();
        Iterator var3 = application.getListeners().iterator();

        while(var3.hasNext()) {
            ApplicationListener<?> listener = (ApplicationListener)var3.next();
            this.initialMulticaster.addApplicationListener(listener);
        }

    }
    @Override
    public void starting() {
        System.out.println ("SpringApplicationRunListener ..... starting ..");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment configurableEnvironment) {
         Object o = configurableEnvironment.getPropertySources ().get ("os.name");
        System.out.println ("SpringApplicationRunListener ..... environmentPrepared .."+o);

    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println ("SpringApplicationRunListener ..... contextPrepared ..");

    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println ("SpringApplicationRunListener ..... contextLoaded ..");
    }

    @Override
    public void finished(ConfigurableApplicationContext configurableApplicationContext, Throwable throwable) {
        System.out.println ("SpringApplicationRunListener ..... finished ..");

    }
}
