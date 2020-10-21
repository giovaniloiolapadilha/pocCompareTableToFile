$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/PesquisaGoogle.feature");
formatter.feature({
  "name": "Realizar busca no google",
  "description": "",
  "keyword": "Funcionalidade"
});
formatter.scenario({
  "name": "Testar home page",
  "description": "",
  "keyword": "Cenário"
});
formatter.step({
  "name": "setUp é feito",
  "keyword": "Dado "
});
formatter.match({
  "location": "GooglePesquisaSteps.setupÉFeito()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "faz processo de login",
  "keyword": "Então "
});
formatter.match({
  "location": "GooglePesquisaSteps.fazProcessoDeLogin()"
});
formatter.result({
  "error_message": "java.lang.NullPointerException\r\n\tat pages.Guru99Login.getLoginTitle(Guru99Login.java:36)\r\n\tat br.com.giovani.steps.pesquisa.GooglePesquisaSteps.fazProcessoDeLogin(GooglePesquisaSteps.java:34)\r\n\tat ✽.faz processo de login(file:src/test/resources/PesquisaGoogle.feature:6)\r\n",
  "status": "failed"
});
});