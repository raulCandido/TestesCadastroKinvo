package br.com.kinvo.po;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaginaHome {

    private WebDriver driver;

    private static final String URL_INICIAL = "https://www.kinvo.com.br";

    private static final int POSICAO_TAB = 1;

    public PaginaHome() {
	System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    }

    public void carregarPagina() {
	System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--window-size=1400,1024");

	this.driver = new ChromeDriver(options);
	driver.get(URL_INICIAL);
    }

    public void clicarNoBotaoInscrever() {
	WebElement button = driver
		.findElement(By.xpath("//*[@id=\"root\"]/div/header/nav/div[2]/div/div[2]/div/div[2]/ul/li[1]/a"));
	button.click();
    }

    public void clicarNoBotaoConfirmar() {
	WebElement botaoConfirmar = driver
		.findElement(By.xpath("//button[@class='sc-ksYbfQ EFDEd sc-dRFtgE llNXWG button']"));
	botaoConfirmar.click();
    }

    public void selecionarAbaCorreta() {
	List<String> abas = new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(abas.get(POSICAO_TAB));

    }

    public void preenchendoInputs(String nome, String email, String senha) {
	WebElement inputNome = driver.findElement(By.xpath("//input[@name='name']"));
	inputNome.sendKeys(nome);

	WebElement inputEmail = driver.findElement(By.xpath("//input[@name='email']"));
	inputEmail.sendKeys(email);

	WebElement inputConfirmacaoEmail = driver.findElement(By.xpath("//input[@name='emailConfirmation']"));
	inputConfirmacaoEmail.sendKeys(email);

	WebElement inputSenha = driver.findElement(By.xpath("//input[@name='password']"));
	inputSenha.sendKeys(senha);

    }

    public void clicarNobotaoEscolherPlano() {
	WebElement botaoEscolherPlano = new WebDriverWait(driver, Duration.ofSeconds(100).getSeconds())
		.until(d -> d.findElement(By.xpath("//button[@class='sc-ksYbfQ jHQmMx sc-eNNmBn sc-eEieub bwMhyF plan__choose-button button']")));
	
	botaoEscolherPlano.click();
	
    }

    public void clicarNoBotaoComecar() {
	WebElement botaoComecar = driver
		.findElement(By.xpath("//button[@class='sc-ksYbfQ EFDEd sc-dRFtgE sc-hlILIN jIzSQ button']"));
	botaoComecar.click();

    }

    public String getPageResource() {
	return driver.getPageSource();
    }

    public WebDriver getDriver() {
	return driver;
    }

    public String emailRandom() {
	return "email@mail-" + new Random().nextInt(1000) + ".com";
    }

    public void clicarNoBotaoCriarConta() {
	WebElement botaoCriarConta = driver.findElement(By.xpath("//button[@class='sc-ksYbfQ cSEjJL sc-cqpYsc bSjFcR button']"));
	botaoCriarConta.click();
    }

}
