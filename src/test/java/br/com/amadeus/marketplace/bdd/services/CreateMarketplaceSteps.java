package br.com.amadeus.marketplace.bdd.services;

import br.com.amadeus.marketplace.bdd.RunCucumberTest;
import br.com.amadeus.marketplace.dto.request.MarketplaceRequest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CreateMarketplaceSteps extends RunCucumberTest {
    @Autowired
    private MockMvc mvc;

    private MarketplaceRequest marketplaceRequest;
    ResultActions result;

    @Given("I have a valid marketplace")
    public void prepareMarketplace() throws Exception {
        marketplaceRequest = getMarketplaceRequest();
    }

    @When("I call service to save the new marketplace")
    public void sendInformationMarketplace() throws Exception {
        result = mvc.perform(post("/v1/marketplaces")
                .contentType(MediaType.APPLICATION_JSON)
                .content(getMarketplaceRequestInJson()));
    }

    @Then("I receive the code 201")
    public void receivedResponse() throws Exception {
        result.andDo(print())
                .andExpect(status().isCreated());
    }


}
