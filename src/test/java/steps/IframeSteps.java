package steps;

import io.cucumber.java.pt.*;
import lombok.extern.log4j.Log4j2;
import pages.IframePage;
import support.data.DataYaml;

import java.util.Map;

import static org.junit.Assert.assertTrue;

@Log4j2
public class IframeSteps {

    //Page Objects
    private IframePage iframePage;

    //Implementations
    private Map map;

    public IframeSteps(){
        iframePage =  new IframePage();
    }

    @Dado("eu estou na pagina {string}")
    public void eu_estou_na_pagina(String url) {
        iframePage.navigateToUrl(url);
    }

    @Quando("acessar o iframe")
    public void acessar_o_iframe() {
        assertTrue(iframePage.checkFramePage());
        iframePage.getFramePage();
    }

    @Quando("preencher nome em {string}")
    public void preencher_nome(String dataType) {
        map = DataYaml.getMapYamlValues("IframeDados", dataType);
        iframePage.preencherNome((String) map.get("nome"));
    }

    @Quando("preencher o sobrenome em {string}")
    public void preencher_o_sobrenome(String dataType) {
        map = DataYaml.getMapYamlValues("IframeDados", dataType);
        iframePage.preencherSobrenome((String) map.get("sobrenome"));
    }

    @Então("devera ser exibido o nome completo")
    public void devera_ser_exibido_o_nome_completo() {
        assertTrue(iframePage.checkExibicaoNomeCompleto());
    }



}
