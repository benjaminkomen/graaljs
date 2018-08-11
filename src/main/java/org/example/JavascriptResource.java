package org.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class JavascriptResource {

    private GraalJs graalJs;

    static {
        // 2 temporary workarounds for running truffle on windows - unsupported yet
        System.getProperties().put("js.home", "x");
        System.getProperties().put("regex.home", "x");
    }

    public JavascriptResource() {
        graalJs = new GraalJs();
    }

    @GET
    @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getHome() {
        return Response.ok()
                .entity(graalJs.exchangeData())
                .build();
    }
}
