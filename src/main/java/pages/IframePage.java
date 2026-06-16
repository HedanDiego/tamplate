package pages;


import com.microsoft.playwright.Frame;
import lombok.extern.log4j.Log4j2;
import static support.context.Context.*;


@Log4j2
public class IframePage {

    private Frame iframeBox;
    private String iframeEl = "xpath=//iframe[@id='firstFr']";
    private String inputFrameFirstName = "input[name='fname']";
    private String inputFrameSecondName = "input[name='lname']";

    private String nome;
    private String sobrenome;

    public void navigateToUrl(String url) {
        web().tentarIrPara(url);
    }

    public boolean checkFramePage() {
        return  web().getPage().isVisible(iframeEl);
    }

    public void getFramePage(){
        iframeBox =  web().getPage().frame("firstFr");

        if (iframeBox == null) {
            throw new IllegalStateException("Error: Frame not found.");
        }
    }

    public void preencherNome(String value) {
        iframeBox =  web().getPage().frame("firstFr");
        nome = value;
        iframeBox.fill(inputFrameFirstName, value);
    }


    public void preencherSobrenome(String value) {
        sobrenome = value;
        iframeBox.fill(inputFrameSecondName, value);
    }

    public boolean checkExibicaoNomeCompleto() {
        return iframeBox.isVisible("xpath=//p[@class='title has-text-info' and text()='You have entered " + nome + " " + sobrenome + "']");
    }

    public boolean checkExibicaoNomeCompleto(String[] nomeCompleto) {
        return iframeBox.isVisible("xpath=//p[@class='title has-text-info' and text()='You have entered " + nomeCompleto[0] + " " + nomeCompleto[1] + "']");
    }
}
