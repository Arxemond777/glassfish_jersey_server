package example.controller;

import example.service.MessageService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.glassfish.jersey.server.mvc.ErrorTemplate;
import org.glassfish.jersey.server.mvc.Template;
import org.glassfish.jersey.server.mvc.Viewable;

import java.util.HashMap;
import java.util.Map;

@Path("/index")
public class WebController {

    // DI via HK2
    @Inject
    private MessageService messageService;

//    @GET
//    @Produces(MediaType.TEXT_HTML)
//    public Viewable index() {
//        Map<String, String> model = new HashMap<>();
//        model.put("hello", "Hello");
//        model.put("world", "World");
//        return new Viewable("/index", model);
//    }

    // output text
    @GET
//    @Produces(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_HTML)
//    public String states() {
    public Viewable states() {
        System.out.println("ping");
//        return "Jersey hello world example.";
//        return new Viewable("states.jsp");
        return new Viewable("/index.ftl", "Fruit Index Page");
    }

//    @GET
//    @ErrorTemplate(name = "/error.ftl")
//    @Template(name = "/named.ftl")
//    @Path("{name}")
//    @Produces(MediaType.TEXT_HTML)
//    public String getFruitByName(@PathParam("name") String name) {
//        if (!"banana".equalsIgnoreCase(name)) {
//            throw new IllegalArgumentException("Fruit not found: " + name);
//        }
//        return name;
//    }

    // output text with argument
    @Path("/{name}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@PathParam("name") String name) {
        return "Jersey: hello " + name;
    }

    // for dependency injection
    @Path("/hk2")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String helloHK2() {
        return messageService.getHello();
    }

}
