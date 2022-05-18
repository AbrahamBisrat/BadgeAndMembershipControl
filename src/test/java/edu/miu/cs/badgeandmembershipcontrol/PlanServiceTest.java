package edu.miu.cs.badgeandmembershipcontrol;

import edu.miu.cs.badgeandmembershipcontrol.controller.PlanController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.client.RestOperations;

import static org.hamcrest.MatcherAssert.assertThat;

/*@SpringBootTest
        //(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PlanServiceTest {

    @Autowired
    private PlanController planController;

    @Test
    public void shouldPassIfStringMatches() throws Exception {
        RestOperations restTemplate = null;
        assertThat(restTemplate.getForObject("http://localhost:9080").contains("Hello World from Spring Boot"));
    }
}*/
