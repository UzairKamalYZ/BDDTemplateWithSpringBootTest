package be.techfix.bdd.acceptance.stepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class exampleDefinition {
    @Autowired
    private TestRestTemplate restTemplate;
    private ResponseEntity<String> exchange;

    @Then("user should receive message {string}")
    public void userShouldReceiveMessageHello(String message) throws IOException {

        assertThat(exchange.getBody()).isEqualTo(message);
    }

    @Given("A user uzair")
    public void aUserUzair() {
    }

    @When("user call hello")
    public void userCallHello() {
        exchange = restTemplate.exchange(RequestEntity.get("/hello")
                                                 .build(), String.class);

    }

    @When("user call bye")
    public void userCallBye() throws IOException {
        exchange = restTemplate.exchange(RequestEntity.get("/bye")
                                                 .build(), String.class);
    }
}