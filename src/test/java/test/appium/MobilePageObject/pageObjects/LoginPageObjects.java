package test.appium.MobilePageObject.pageObjects;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.webdriver.WebDriverFacade;

public class LoginPageObjects  extends MobilePageObject{

	public LoginPageObjects(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
    String edtUsuario = "com.experitest.ExperiBank:id/usernameTextField";
    String edtContrasena = "com.experitest.ExperiBank:id/passwordTextField";
    String btnIngresar = "com.experitest.ExperiBank:id/loginButton";
    String btnPagos = "com.experitest.ExperiBank:id/makePaymentButton";
    String txtSaldo = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View\r\n";
    
    String btnRealizarPago = "com.experitest.ExperiBank:id/makePaymentButton";
    String edtTelefono = "com.experitest.ExperiBank:id/phoneTextField";
    String edtNombre = "com.experitest.ExperiBank:id/nameTextField";
    String edtValor = "com.experitest.ExperiBank:id/amountTextField";
    String btnBuscarPais = "com.experitest.ExperiBank:id/countryButton"; 
    String btnPais = "//android.widget.ListView/android.widget.TextView[@text = \"Colombia\"]";
    
    WebDriverWait wait = new WebDriverWait(getDriver(), 10);
    
	public void iniciarApp() throws MalformedURLException {
		//iniciar app
	}

	public void ingresarUsuario(String usuario) {
		element(By.id(this.edtUsuario)).sendKeys(usuario);		
	}

	public void ingresarContrasena(String contrasena) {
		element(By.id(this.edtContrasena)).sendKeys(contrasena);
		
	}

	public void darClicEnBotonIngresar() {
		element(By.id(this.btnIngresar)).click();
		
	}

	public void validarMensajeSaldo(String mensaje) {
		waitFor(4).seconds();
		String mensajeAValidar = element(By.xpath(this.txtSaldo)).getText().toString();
		System.out.println("mensaje: "+mensajeAValidar+" mensaje feature: "+mensaje);
		assertTrue(mensajeAValidar.contains(mensaje));
	}
	
	public void darClicEnMakePayment() {
		MobileElement btnRealizarPago =(MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.id(this.btnRealizarPago)));
		btnRealizarPago.click();
	}

	public void ingresarNumeroTelefonico(String numero) {
		MobileElement btnTelefono = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(this.edtTelefono)));
		btnTelefono.sendKeys(numero);
		
	}

	public void ingresarNombre(String nombre) {
		element(By.id(this.edtNombre)).sendKeys(nombre);
		
	}

	public void ingresarValorPago(String cantidad) {
		element(By.id(this.edtValor)).sendKeys(cantidad);
		
	}

	public void darClicEnBuscarPais() {
		element(By.id(this.btnBuscarPais)).click();
		
	}

	@SuppressWarnings("rawtypes")
	public void SeleccionarPais(String pais) {
		waitFor(4).seconds();
		Dimension size = getDriver().manage().window().getSize();
		WebDriver facade = getDriver();
		WebDriver driver = ((WebDriverFacade)facade).getProxiedDriver();
		int startY = (int) (size.height*0.8);
		int endY = (int) (size.height*0.2);
		int pointX = (int) (size.width*0.5);
		System.out.println("x: "+pointX+" y1: "+startY+" y2: "+endY);
		TouchAction ta = new TouchAction((PerformsTouchActions) driver);
		ta.press(new PointOption().withCoordinates(pointX, startY)).waitAction().moveTo(new PointOption().withCoordinates(pointX, endY)).release().perform();
		getDriver().quit();
	}
	
}
