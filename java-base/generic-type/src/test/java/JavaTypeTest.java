import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;

/**
 * @author lh
 */
public class JavaTypeTest {
    @Test
    public void test() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "{\"result\":{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Lewis\"}}";
        JavaType javaType =
                objectMapper
                        .getTypeFactory()
                        .constructParametricType(
                                DeserializeGenericTypeTest.JsonResponse.class,
                                getRunTimeGenericClass());
        DeserializeGenericTypeTest.JsonResponse<DeserializeGenericTypeTest.User> jsonResponse =
                objectMapper.readValue(json, javaType);
        DeserializeGenericTypeTest.User user = jsonResponse.getResult();

        assertThat(user.getId(), equalTo(1L));
        assertThat(user.getFirstName(), equalTo("John"));
        assertThat(user.getLastName(), equalTo("Lewis"));
    }

    private Class<?> getRunTimeGenericClass() {
        return DeserializeGenericTypeTest.User.class;
    }
}
