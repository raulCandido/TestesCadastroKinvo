package br.com.kinvo.teste;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.kinvo.po.PaginaHome;

public class CadastroNovoUsuarioTest {

    private PaginaHome paginaHome;

    private String nome = "teste-usuario";
    //private String email = "usuario@usuario230.com";
    private String senha = "Senha@01";

    @Before
    public void carregarDependencias() {
	paginaHome = new PaginaHome();
	paginaHome.carregarPagina();
    }

    @Test
    public void deveriaEfetuarCadastroDeNovoUsuario() {

	paginaHome.clicarNoBotaoInscrever();
	paginaHome.selecionarAbaCorreta();
	
	Assert.assertFalse(paginaHome.getDriver().getCurrentUrl().equals("https://www.kinvo.com.br"));
	
	paginaHome.preenchendoInputs(nome, paginaHome.emailRandom(), senha);
	//Clicar manualmenten no botao de criar conta
	paginaHome.clicarNobotaoEscolherPlano();
	
	paginaHome.clicarNoBotaoConfirmar();

	paginaHome.clicarNoBotaoComecar();

	Assert.assertTrue(paginaHome.getDriver().getCurrentUrl().equals("https://app.kinvo.com.br/resumo-da-carteira"));

    }

    @Test
    public void deveriaNaoPermitirCadastroDeNovoUsuario() {
       
	paginaHome.clicarNoBotaoInscrever();
	paginaHome.selecionarAbaCorreta();
	
	Assert.assertFalse(paginaHome.getDriver().getCurrentUrl().equals("https://www.kinvo.com.br"));
	
	paginaHome.preenchendoInputs("", "", "");
	paginaHome.clicarNoBotaoCriarConta();
	
	String pageSource = paginaHome.getPageResource();
	
	Assert.assertTrue(pageSource.contains("Por favor, digite seu nome"));
	Assert.assertTrue(pageSource.contains("Por favor, digite seu endereço de email"));
	Assert.assertTrue(pageSource.contains("Por favor, confirme seu endereço de email"));
	Assert.assertTrue(pageSource.contains("Por favor, digite sua senha."));
    }
    
    

}
