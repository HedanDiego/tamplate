# language: pt
# charset: UTF-8
# Supported severity values: blocker, critical, normal, minor, trivial. ex.: @severity=critical
# Every Feature or Scenario can be annotated by following tags: @flaky, @muted, @known

@handlerequest
Funcionalidade: Teste com HandleRequest
  Eu como cliente gostaria de acessar o sistema alterando o comportamento com HandleRequest

  @HandleRequest
  Cenario:  CT001 - API
    Dado que eu tenha a URL do site "https://www.udesc.br/busca?q=PlayWright"
    E endpoint "/templates/portal_udesc/libs/camaleao/css/estilo.css?v=1"
    E definir o status code "500"
    Quando estiver na pagina do site
    Entao devo visualizar o retorno
