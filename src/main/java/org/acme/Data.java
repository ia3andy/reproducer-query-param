package org.acme;

import javax.ws.rs.QueryParam;

public class Data {
    @QueryParam("f")
    public String foo;

    @QueryParam("b")
    public int bar;
}
