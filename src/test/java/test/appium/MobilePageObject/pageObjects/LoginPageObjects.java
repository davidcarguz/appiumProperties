package test.appium.MobilePageObject.pageObjects;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.core.annotations.findby.By;

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
	
}
