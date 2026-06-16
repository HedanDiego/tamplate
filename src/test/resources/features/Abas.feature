# language: pt
# charset: UTF-8
# Supported severity values: blocker, critical, normal, minor, trivial. ex.: @severity=critical
# Every Feature or Scenario can be annotated by following tags: @flaky, @muted, @known

@abas
Funcionalidade: Teste com Abas
  Eu como cliente gostaria de acessar o sistema e preenchedo-o com informações de outras abas

  @Multiplas_Abas
  Cenario:  CT001 - Login - Executar login com dados validos em multiplas abas
  Dado eu estou na pagina de login em todas as abas
  Quando eu efetuar o login com "credenciais validas" em todas as abas
  Entao sera apresentado a tela do menu principal em todas as abas

  @Multiplas_Abas
  Cenario:  CT002 - Testando IFrame - Executar login com dados de outra pagina
    Dado eu estou na pagina "https://letcode.in/frame"
    Quando acessar o iframe
    E acessar o site "https://www.name-generator.org.uk/quick/" em uma nova aba
    Quando pegar um nome de pessoa na segunda aba
    E preencher nome e sobrenome na primeira aba
    Entao sera exibido o nome completo no modal nome na primeira aba

