package example.config;

//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.PropertyAccessor;
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
//import jakarta.ws.rs.Produces;
//import jakarta.ws.rs.core.MediaType;
//import jakarta.ws.rs.ext.Provider;
//
//@Provider
//@Produces(MediaType.APPLICATION_JSON)
//public class CustomJsonProvider extends JacksonJaxbJsonProvider {
//
//    public static ObjectMapper mapper = new ObjectMapper();
//
//    static {
//        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        mapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
//        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        mapper.enable(SerializationFeature.INDENT_OUTPUT);
//    }
//
//    public CustomJsonProvider() {
//        super();
//        setMapper(mapper);
//    }
//}