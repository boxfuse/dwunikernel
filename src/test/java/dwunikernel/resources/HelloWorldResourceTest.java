package dwunikernel.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.fluent.Request;
import org.junit.Test;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class HelloWorldResourceTest {
    @Test
    public void hello() throws Exception {
        String url = System.getProperty("instanceUrl", "http://localhost:8080/") + "?name=IntegrationTest";
        String json = Request.Get(url).execute().returnContent().asString();
        Map<String, Object> result = new ObjectMapper().readValue(json, new TypeReference<Map<String, Object>>() {});
        assertEquals("Hello, IntegrationTest!", result.get("hello"));
    }
}
