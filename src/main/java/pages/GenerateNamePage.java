package pages;

import support.data.DataYaml;
import static support.context.Context.*;
import java.util.HashMap;
import java.util.Map;


public class GenerateNamePage{

    private String txtFirstName = "xpath=(//div[@class='name_heading'])[1]";

    public void abrirOutraAba(){
        web().createNewPage();
    }

    public void navigateToUrl(String url){
        web().tentarIrPara(url);
    }

    public String pegarNomeCompleto(){
       return web().getPage().textContent(txtFirstName);
    }

    public String[] salvarNomeCompleto() {
        Map dataMap = new HashMap();
        String[] nomeCompleto =  pegarNomeCompleto().split(" ");
        dataMap.put("nome", nomeCompleto[0]);
        dataMap.put("sobrenome", nomeCompleto[1]);
        DataYaml.setMapYamlValues("AbasDados", "dados", dataMap);
        return nomeCompleto;
    }

    public void mudarDeAba(int aba) {
        web().changeFocusPage(aba);
    }
}
