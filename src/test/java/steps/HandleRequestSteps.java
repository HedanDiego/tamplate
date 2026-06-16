package steps;

import io.cucumber.java.pt.*;
import pages.HandleRequestPage;

import java.util.Map;

public class HandleRequestSteps {

    //Page Objects
    HandleRequestPage apiPage;

    //Implementations
    private Map map;

    public HandleRequestSteps(){
        apiPage = new HandleRequestPage();

    }

    @Dado("que eu tenha a URL do site {string}")
    public void que_eu_tenha_a_URL_do_site(String url) {
        // Write code here that turns the phrase above into concrete actions
        apiPage.setUrl(url);
    }

    @Quando("estiver na pagina do site")
    public void estiver_na_pagina_do_site() {
        apiPage.irParaPagina();
    }


    @E("definir o status code {string}")
    public void definirOStatusCode(String status) {
        apiPage.setStatusCode(Integer.parseInt(status));
    }

    @E("endpoint {string}")
    public void endpoint(String endpoint) {
        apiPage.setEndpoint(endpoint);
    }

    @Entao("devo visualizar o retorno")
    public void devo_visualizar_o_retorno() {

    }
}
