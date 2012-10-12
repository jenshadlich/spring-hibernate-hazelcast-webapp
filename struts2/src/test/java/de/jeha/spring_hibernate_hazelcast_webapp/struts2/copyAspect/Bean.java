package de.jeha.spring_hibernate_hazelcast_webapp.struts2.copyAspect;


public class Bean {
    private String string = "foobar";
    
    @Override
    public String toString() {
        return string;
    }
}
