import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

public class JacksonTest {
    @Test
    public void test() throws JsonProcessingException {
        String s = "{\"pid\":\"1\",\"pname\":\"广东\"}";
        ObjectMapper om = new ObjectMapper();
        Province province = om.readValue(s, Province.class);
        System.out.println(province);
        String s1 = om.writeValueAsString(province);
        System.out.println(s1);

    }
}
