package com.nttdata.stepsdefinitions;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.nttdata.steps.ClothesSteps;
import com.nttdata.steps.LoginSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;


public class LoginStepsDef {

    private WebDriver driver;



    private ClothesSteps inventorySteps(WebDriver driver){
        return new ClothesSteps(driver);
    }

    @Dado("que me encuentro en la página de login de Saucedemo")
    public void que_me_encuentro_en_la_página_de_login_de_sacedemo() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/en/login?back=https%3A%2F%2Fqalab.bensg.com%2Fstore%2Fen%2F");
        screenShot();
    }
    @Cuando("inicio sesión con las credenciales usuario: {string} y contraseña: {string}")
    public void inicio_sesión_con_las_credenciales_usuario_y_contraseña(String user, String password) {
        LoginSteps loginSteps = new LoginSteps(driver);
       // loginSteps.validarLogo();
        loginSteps.typeUser(user);
        loginSteps.typePassword(password);
        loginSteps.login();
        screenShot();
    }


    @Cuando("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String arg0, String arg1) {
     ClothesSteps clothesSteps = new ClothesSteps(driver);
     clothesSteps.ingresarCategoria(arg0);
     clothesSteps.ingresarSubcategoria(arg1);
        screenShot();
    }

    @Y("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int arg0) {
        ClothesSteps clothesSteps = new ClothesSteps(driver);
        clothesSteps.agregarProducto(arg0);
        screenShot();
    }

    @Entonces("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {
        ClothesSteps clothesSteps = new ClothesSteps(driver);
        clothesSteps.validarPopup();
        screenShot();
    }

    @Y("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        ClothesSteps clothesSteps = new ClothesSteps(driver);
        clothesSteps.validarMonto();
        screenShot();
    }

    @Cuando("finalizo la compra")
    public void finalizoLaCompra() {
        ClothesSteps clothesSteps = new ClothesSteps(driver);
        clothesSteps.finalizarCompra();
        screenShot();
    }

    @Entonces("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        ClothesSteps clothesSteps = new ClothesSteps(driver);
        clothesSteps.validarTitulo();
        screenShot();

    }

    @Y("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        ClothesSteps clothesSteps = new ClothesSteps(driver);
        clothesSteps.validarPrecio();
        screenShot();
    }
}
