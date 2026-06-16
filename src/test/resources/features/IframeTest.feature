# language: pt
# charset: UTF-8
# Supported severity values: blocker, critical, normal, minor, trivial. ex.: @severity=critical
# Every Feature or Scenario can be annotated by following tags: @flaky, @muted, @known

@Iframe
Funcionalidade: Testando Iframe
   Eu como cliente gostaria de acessar o sistema e validar elementos alternando entre as abas do navegador


  Cenario:  CT001 - Iframe - Acessar IFrame
    Dado eu estou na pagina "https://letcode.in/frame"
    Quando acessar o iframe
    E preencher nome em "dados"
    E preencher o sobrenome em "dados"
    Então devera ser exibido o nome completo