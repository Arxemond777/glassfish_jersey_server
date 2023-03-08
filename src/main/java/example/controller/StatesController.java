package example.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import example.MainApp;
//import example.config.CustomJsonProvider;
import example.dto.RequestStatesJsonDTO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.glassfish.jersey.server.mvc.Viewable;

import java.io.File;
import java.io.IOException;

@Path("/states")
public class StatesController {
    private final static ObjectMapper om = new ObjectMapper();
    static {
        om.enable(SerializationFeature.INDENT_OUTPUT);
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        om.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public RequestStatesJsonDTO states() {
        try {
//            File file = new File("/Users/urijglusenkov/InteliJ/glassfish_jersey_server/src/main/resources/test.json");
            File file = new File("/Users/urijglusenkov/InteliJ/glassfish_jersey_server/src/main/resources/17.1mb_3.10sec_states.json");

            RequestStatesJsonDTO rs = om.readValue(file, RequestStatesJsonDTO.class);
//            System.out.println(rs);
            return rs;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
