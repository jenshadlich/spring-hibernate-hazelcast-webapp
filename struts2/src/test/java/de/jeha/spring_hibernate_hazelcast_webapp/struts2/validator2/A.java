package de.jeha.spring_hibernate_hazelcast_webapp.struts2.validator2;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;

public class A {

    @Valid
    private B<?> bb = new B();

    // @Valid
    // @NotNull
    @Size(min = 1, max = 15)
    private List<B<?>> validList = new ArrayList<B<?>>();

    {
        validList.add(new B());
    }
}