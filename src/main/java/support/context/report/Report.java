package support.context.report;

import com.google.common.collect.ImmutableMap;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.ScreenshotType;
import io.qameta.allure.Allure;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;
import static support.context.Context.config;
import static support.context.Context.web;

@Log4j2
public class Report {

    public void setEnv(){
        new File(System.getProperty("allure.results.directory")).mkdirs();
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Environment", config().getEnv())
                        .put("URL", config().getPropsEnv().url())
                        .put("Browser", config().getBrowser())
                        .put("System Operation", System.getProperty("os.name"))
                        .put("Allure Server Enabled", config().getPropsEnv().allureEnable().toString())
                        .build(), System.getProperty("allure.results.directory")+"/");
    }

    @SneakyThrows
    public void takeScreenShot() {
        log.info("Print screen da tela");
        byte[] screenshotByte = web().getPage().screenshot(new Page.ScreenshotOptions()
                .setType(ScreenshotType.PNG));
        InputStream image = new ByteArrayInputStream(screenshotByte);
        Allure.addAttachment("Screenshot", image);
    }

    @SneakyThrows
    public void takeScreenShot(String name) {
        log.info("Print screen da tela: " + name);
        byte[] screenshotByte = web().getPage().screenshot(new Page.ScreenshotOptions()
                .setType(ScreenshotType.PNG));
        InputStream image = new ByteArrayInputStream(screenshotByte);
        Allure.addAttachment(name, image);
    }

    public void setText(String value) {
        log.info("Evidencia em texto : " + value);
        Allure.addAttachment("Evidencia em texto","", value);
    }

}
