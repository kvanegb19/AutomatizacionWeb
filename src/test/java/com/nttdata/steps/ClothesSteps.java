package com.nttdata.steps;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class ClothesSteps {

    private WebDriver driver;

    //contrsuctor
    public ClothesSteps(WebDriver driver){
        this.driver = driver;
    }


    public void ingresarCategoria(String arg0) {
        // Esperar y hacer clic en la categoría

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement categoriaElement = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(arg0)));
        categoriaElement.click();

    }

    public void ingresarSubcategoria(String arg1) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Esperar y hacer clic en la subcategoría
        WebElement subcategoriaElement = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(arg1)));
        subcategoriaElement.click();
    }

    public void agregarProducto(int arg0) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement imagenProducto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[alt='Hummingbird printed t-shirt']")));
        imagenProducto.click();

        // Seleccionar la cantidad deseada
        WebElement cantidadInput = driver.findElement(By.id("quantity_wanted"));
        //cantidadInput.clear(); // Limpiar el input primero
        cantidadInput.sendKeys(Keys.CONTROL + "a"); // Selecciona todo el texto
        cantidadInput.sendKeys(Keys.DELETE); // Borra el texto seleccionado
        cantidadInput.sendKeys(String.valueOf(arg0)); // Ingresar la cantidad

        // Hacer clic en el botón de agregar al carrito
        WebElement botonAnadirCarrito = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.btn-primary.add-to-cart")));
        botonAnadirCarrito.click();
    }

    public void validarPopup() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        // Esperar y validar el popup de confirmación
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("blockcart-modal")));
        WebElement mensajeConfirmacion = popup.findElement(By.id("myModalLabel"));

        // Verificar que el mensaje de confirmación es el esperado
        String mensajeEsperado = "\uE876Product successfully added to your shopping cart";
        assertEquals(mensajeEsperado, mensajeConfirmacion.getText().trim());

    }

    public void validarMonto() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("blockcart-modal")));
        WebElement totalElement = popup.findElement(By.cssSelector(".product-total .value"));
        String totalText = totalElement.getText().trim();
        String montoEsperado = "PEN38.24";
        assertEquals(montoEsperado, totalText);
    }

    public void finalizarCompra() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("blockcart-modal")));
        // Esperar y hacer clic en el botón "Proceed to checkout"
        WebElement botonCheckout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Proceed to checkout')]")
        ));
        botonCheckout.click();
    }

    public void validarTitulo() {
        String title =  driver.getTitle();
        //prueba: validamos el título del producto
        Assertions.assertEquals("Cart", title);
    }

    public void validarPrecio() {

        WebElement totalElement = driver.findElement(By.cssSelector(".cart-summary-line.cart-total .value"));
        String totalText = totalElement.getText().trim();
        String montoEsperado = "PEN38.24";
        assertEquals(montoEsperado, totalText);
    }
}
