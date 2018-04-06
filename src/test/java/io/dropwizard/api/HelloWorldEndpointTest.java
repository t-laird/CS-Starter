package io.dropwizard.api;

import com.campspot.api.Saying;
import com.campspot.resources.HelloWorldResource;
import com.fasterxml.jackson.databind.ObjectReader;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloWorldEndpointTest {

    @Rule
    public final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new HelloWorldResource("Hello, %s!", "Stranger"))
            .build();

    @Test
    public void testTest() {
        assertThat(1).isEqualTo(1);
    }

    @Test
    public void helloWorldDropwizard() throws IOException {
        String resp = resources.client().target("/hello-world")
                .queryParam("name", "dropwizard")
                .request().get(String.class);

        String json = "{\"id\": 1, \"content\": \"Hello, dropwizard!\" }";

        ObjectReader reader = resources.getObjectMapper().reader(Saying.class);

        Saying actual = reader.readValue(resp);
        Saying expected = reader.readValue(json);

        assertThat(actual.getId())
                .isEqualTo(expected.getId())
                .isEqualTo(1);
    }

    @Test
    public void helloWorldAbsentName() {
        Saying actual = resources.client().target("/hello-world")
                .request().get(Saying.class);
        Saying expected = new Saying(1, "Hello, Stranger!");
        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getContent()).isEqualTo(expected.getContent());
    }
}
