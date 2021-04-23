package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class informacoesUsuarioTest {
    private WebDriver browser;

    @Before
    public void setup(){
        //Configurar driver de navegador
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        //Abrir o navegador e configurar timeout
        browser = new ChromeDriver();
        browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Expande a janela do navegador
        browser.manage().window().maximize();
        //Acessar a pagina
        browser.get("http://www.juliodelima.com.br/taskit/");
    }

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(){
        //Clicar no link que possui o texto "Sign in"
        browser.findElement(By.linkText("Sign in")).click();
        //Declaração do formulario "signinbox"
        WebElement formularioSignInBox = browser.findElement(By.id("signinbox"));
        //Clicar no campo "name" que esta dentro do formulario de id "signinbox" e digitar o usuario "gus12345"
        formularioSignInBox.findElement(By.name("login")).sendKeys("gus12345");
        //Clicar no campo "password" que esta dentro do formulario de id "signinbox" e digitar a senha "ggg123"
        formularioSignInBox.findElement(By.name("password")).sendKeys("ggg123");
        //Clicar no link que possui o texto "Sign in"
        browser.findElement(By.linkText("SIGN IN")).click();
        //Clicar em um link que possui a class "me"
        browser.findElement(By.className("me")).click();
        //Clicar em um link que possui o texto "MORE DATA ABOUT YOU"
        browser.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
        //Clicar em um botão através do seu XPath "//button[@data-target="addmoredata"]"
        browser.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();
        //Identificar a popup onde está o formulário de id "addmoredata"
        WebElement popupAddMoreData = browser.findElement(By.id("addmoredata"));
        //Na combo de name "type" escolher a opção "Phone" dentro do popup
        WebElement campoType = popupAddMoreData.findElement(By.name("type"));
        new Select(campoType).selectByVisibleText("Phone");
        //No campo de name "contact" digitar o telefone "+5511999999999" dentro do popup
        popupAddMoreData.findElement(By.name("contact")).sendKeys("+5511999999999");
        //Clicar no link de texto "SAVE" dentro do popup
        popupAddMoreData.findElement(By.linkText("SAVE")).click();
        //Validar o elemento de id "toast-container" com o texto "Your contact has been added!"
        WebElement mensagemPop = browser.findElement(By.id("toast-container"));
        String mensagem = mensagemPop.getText();
        assertEquals("Your contact has been added!", mensagem);
    }

    @After
    public void tearDown(){
        //Fechar o navegador
        browser.quit();
    }
}
