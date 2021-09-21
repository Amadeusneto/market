package br.com.amadeus.marketplace.bdd;


import br.com.amadeus.marketplace.dto.request.MarketplaceRequest;
import com.google.gson.Gson;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest
@AutoConfigureMockMvc
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/cucumber-reports/cucumber.json"},
        features = {"classpath:bdd"},
        glue = {"br.com.amadeus.marketplace.bdd"})
public class RunCucumberTest {

    protected MarketplaceRequest getMarketplaceRequest() {
        return MarketplaceRequest.builder()
                .active(true)
                .area("51")
                .districtCode("04")
                .districtName("DF")
                .latitude(23245D)
                .longitude(23245D)
                .name("LOJA DE VAREJO")
                .neighborhood("Brasília")
                .number("11")
                .reference("PRÓXIMO AO HOSPITAL DO GUARÁ")
                .region05("SUL")
                .region08("NORTE")
                .register("5001")
                .sector("235432")
                .street("Brasília")
                .subCityHallCode(23L)
                .subCityHallName("BSB")
                .build();
    }

    protected String getMarketplaceRequestInJson() {
        Gson gson = new Gson();
        return gson.toJson(getMarketplaceRequest());
    }
}
