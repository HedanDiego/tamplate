# language: pt
# charset: UTF-8
# Supported severity values: blocker, critical, normal, minor, trivial. ex.: @severity=critical
# Every Feature or Scenario can be annotated by following tags: @flaky, @muted, @known

@login
Funcionalidade: Teste de validação Web - Login
  Eu como cliente gostaria de acessar o sistema via login somente com credenciais validas

  @Positivo
  Cenario: CT001 - Login - Executar login com dados validos
    Dado eu estou na pagina de login
    Quando eu efetuar o login com "credenciais validas"
    Entao sera apresentado a tela do menu principal

  @Negativo
  Cenario:  CT002 - Login - Executar login com invalido
    Dado eu estou na pagina de login
    Quando eu efetuar o login com "credenciais invalidas"
    Entao sera apresentado uma mensagem de erro

