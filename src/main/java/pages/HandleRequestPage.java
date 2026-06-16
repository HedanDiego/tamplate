package pages;

import com.microsoft.playwright.Route;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import static support.context.Context.*;


public class HandleRequestPage{

    //Variables
    @Getter @Setter
    private String url;
    @Getter @Setter
    private int statusCode;
    @Getter @Setter
    private String body = null;
    @Getter @Setter
    private String endpoint;

    public void irParaPagina() { web().getPage().route("**" + getEndpoint(), route -> route.fulfill(new Route.FulfillOptions()
                .setStatus(getStatusCode())
               ));
        web().tentarIrPara(getUrl());
    }
}
