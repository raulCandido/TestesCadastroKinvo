package br.com.kinvo.teste;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class GenericTest {
    
    private WebDriver browser;

    @Before
    public void carregarDependencias() {
	System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
//	ChromeOptions options = new ChromeOptions();
//	options.addArguments("--start-maximized");
	
	browser = new ChromeDriver();
	browser.manage().window().maximize();
	browser.navigate().to("https://www.kinvo.com.br");
    }


}
