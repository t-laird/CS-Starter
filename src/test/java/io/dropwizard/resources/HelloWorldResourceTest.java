package io.dropwizard.resources;

import com.campspot.api.Saying;
import com.campspot.resources.HelloWorldResource;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloWorldResourceTest {
    private HelloWorldResource resource;

    @Before
    public void setup() {
        resource = new HelloWorldResource("Hello, %s", "Stranger");
    }

    @Test
    public void idStartsAtOne() {
        Saying result = resource.sayHello(Optional.of("dropwizard"));
        assertThat(result.getId()).isEqualTo(1);
    }

    @Test
    public void idIncrementsByOne() {
        Saying result = resource.sayHello(Optional.of("dropwizard"));
        Saying result2 = resource.sayHello(Optional.of("dropwizard2"));

        assertThat(result2.getId()).isEqualTo(result.getId() + 1);
    }

    @Test
    public void absentNameReturnsDefaultName() {
        Saying result = resource.sayHello(Optional.empty());
        assertThat(result.getContent()).contains("Stranger");
    }

    @Test
    public void nameReturnsName() {
        Saying result = resource.sayHello(Optional.of("dropwizard"));
        assertThat(result.getContent()).contains("dropwizard");
    }
}
