package example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
//import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import example.config.*;
import example.controller.*;
import jakarta.ws.rs.ext.MessageBodyReader;
import jakarta.ws.rs.ext.MessageBodyWriter;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.message.GZipEncoder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.server.filter.EncodingFilter;
import org.glassfish.jersey.server.mvc.freemarker.FreemarkerMvcFeature;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;

import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainApp extends ResourceConfig {

    private static final Logger LOGGER = Logger.getLogger(MainApp.class.getName());

    // we start at port 8080
    public static final String BASE_URI = "http://localhost:8080/";

//    // create custom ObjectMapper
//    public final static ObjectMapper mapper = new ObjectMapper();
//    static {
//        mapper.enable(SerializationFeature.INDENT_OUTPUT);
//    }

    // Starts Grizzly HTTP server
    public static HttpServer startServer() {

        // scan packages
        final ResourceConfig config = new ResourceConfig();
        config.packages(true, "example"); // package
        config.property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
        // https://riptutorial.com/jersey/example/30679/jersey-mvc-hello-world
//        config.property(JspMvcFeature.TEMPLATE_BASE_PATH, "templates/jsp");
//        config.register(JspMvcFeature.class);
        //https://www.baeldung.com/jersey-mvc
        config.property(FreemarkerMvcFeature.TEMPLATE_BASE_PATH, "templates/jsp");
        config.register(FreemarkerMvcFeature.class);
        LOGGER.info(">>>JspMvcFeature<<<");
        config.register(WebController.class);
        config.register(StatesController.class);

//        // create JsonProvider to provide custom ObjectMapper
//        JacksonJaxbJsonProvider provider = new JacksonJaxbJsonProvider();
//        provider.setMapper(mapper);
//        config.register(provider);

//        config.register(CustomJsonProvider.class, MessageBodyReader.class, MessageBodyWriter.class);
        EncodingFilter.enableFor(config, GZipEncoder.class);



        // enable auto scan @Contract and @Service
        config.register(AutoScanFeature.class);


        LOGGER.info("Starting Server........");

        final HttpServer httpServer =
                GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), config);

        return httpServer;

    }

    public static void main(String[] args) {

        try {

            final HttpServer httpServer = startServer();

            // add jvm shutdown hook
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try {
                    System.out.println("Shutting down the application...");

                    httpServer.shutdownNow();

                    System.out.println("Done, exit.");
                } catch (Exception e) {
                    Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, e);
                }
            }));

            System.out.println(String.format("Application started.%nStop the application using CTRL+C"));

            // block and wait shut down signal, like CTRL+C
            Thread.currentThread().join();

        } catch (InterruptedException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}