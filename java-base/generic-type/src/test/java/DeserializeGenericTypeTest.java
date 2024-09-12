import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;

import org.junit.jupiter.api.Test;

/**
 * @author lh
 */
public class DeserializeGenericTypeTest {
    @Test
    public void test() throws JsonProcessingException {
        String json = "{\"result\":{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Lewis\"}}";
        ObjectMapper objectMapper = new ObjectMapper();

        TypeReference<JsonResponse<User>> typeRef = new TypeReference<>() {};
        JsonResponse<User> jsonResponse = objectMapper.readValue(json, typeRef);
        User user = jsonResponse.getResult();

        assertThat(user.getId(), equalTo(1L));
        assertThat(user.getFirstName(), equalTo("John"));
        assertThat(user.getLastName(), equalTo("Lewis"));
    }

    @Data
    static class User {
        private Long id;
        private String firstName;
        private String lastName;

    }

    @Data
    static class JsonResponse<T> {
        private T result;
    }
}
