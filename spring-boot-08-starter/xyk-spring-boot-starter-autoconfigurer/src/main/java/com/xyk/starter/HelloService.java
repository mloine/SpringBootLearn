package com.xyk.starter;

import org.springframework.beans.factory.annotation.Autowired;

public class HelloService {

    HelloPropeties helloPropeties;

    public HelloPropeties getHelloPropeties() {
        return helloPropeties;
    }

    public void setHelloPropeties(HelloPropeties helloPropeties) {
        this.helloPropeties = helloPropeties;
    }

    public String sayHellXyk(String name){
        return helloPropeties.getPrefix ()+"-"+ name + helloPropeties.getSuffix ();
    }
}
