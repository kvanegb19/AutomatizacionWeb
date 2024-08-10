
@testfeature
Feature: Product - Store

  @test
  Scenario Outline:  Validación del Precio de un Producto
    Given que me encuentro en la página de login de Saucedemo
    When inicio sesión con las credenciales usuario: "<usuario>" y contraseña: "<password>"
    When navego a la categoria "<categoria>" y subcategoria "MEN"
    And agrego 2 unidades del primer producto al carrito
    When valido en el popup la confirmación del producto agregado
    And valido en el popup que el monto total sea calculado correctamente
    When finalizo la compra
    When valido el titulo de la pagina del carrito
    And vuelvo a validar el calculo de precios en el carrito
    Examples:
      | usuario                       | password  |  categoria   |

      | guevara@hotmail.com   | 11111111  |  CLOTHES     |
      | guevara16_vanessa@hotmail.com | Saneva90* |  CLOTHES     |
      | guevara16_vanessa@hotmail.com | Saneva90* |  autos       |
