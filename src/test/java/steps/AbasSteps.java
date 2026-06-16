package steps;


import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pages.GenerateNamePage;
import pages.HomePage;
import pages.IframePage;
import pages.LoginPage;
import support.data.DataYaml;

import java.util.Map;

import static org.junit.Assert.assertTrue;

public class AbasSteps {

    GenerateNamePage generateName;
    IframePage iframePage;
    LoginPage loginPage;
    HomePage homePage;
    private Map map;
    private String[] nomeCompleto;

    public AbasSteps(){
        generateName =  new GenerateNamePage();
        iframePage = new IframePage();
        loginPage = new LoginPage();
        homePage = new HomePage();
    }


    @Dado("eu estou na pagina de login em todas as abas")
    public void eu_estou_na_pagina_de_login_em_todas_as_abas() {
        for(int i=0; i < 5; i++)
            loginPage.abrirNovaPagina();
        loginPage.navigateToUrlAllPages();
    }

    @Quando("eu efetuar o login com {string} em todas as abas")
    public void eu_efetuar_o_login_com_em_todas_as_abas(String string) {
        map = DataYaml.getMapYamlValues("Usuarios", "credenciais validas");
        loginPage.logarEmTodasAsAbas((String) map.get("usuario"), (String) map.get("senha"));
    }
    @Entao("sera apresentado a tela do menu principal em todas as abas")
    public void sera_apresentado_a_tela_do_menu_principal_em_todas_as_abas() {
        homePage.validarMenuPresenteEmTodasAsAbas();
    }

    @Dado("acessar o site {string} em uma nova aba")
    public void acessar_o_site_em_uma_nova_aba(String url) {
        generateName.abrirOutraAba();
        generateName.navigateToUrl(url);
    }

    @Quando("pegar um nome de pessoa na segunda aba")
    public void pegar_um_nome_de_pessoa_na_segunda_aba() {
        nomeCompleto = generateName.salvarNomeCompleto();

    }
    @Quando("preencher nome e sobrenome na primeira aba")
    public void preencher_nome_e_sobrenome_em() {
        generateName.mudarDeAba(0);
        iframePage.preencherNome(nomeCompleto[0]);
        iframePage.preencherSobrenome(nomeCompleto[1]);
    }

    @Entao("sera exibido o nome completo no modal nome na primeira aba")
    public void sera_exibido_o_nome_completo_no_modal_nome_na_primeira_aba() {
        assertTrue(iframePage.checkExibicaoNomeCompleto(nomeCompleto));
    }

}
