  Feature: Probar la funcionalidad de Hiraoka
    @Hiraoka
    Scenario: Como usuario nuevo ingreso a Hiraoka a realizar una compra
      Given Ingreso a www.hiraoka.com.pe
      When Selecciono categoria Eletrohogar
      And Selecciono Electrodomesticos Refrigeradora
      And Selecciono Marca LG
      And Selecciono Primer articulo
      And Aniado al carrito
      And Busco Televisores smart
      And Aniado al carro el primer articulo encontrado
      And Ir al Carrito
      And Selecciono comprar
      And Selecciono Compra como Cliente Nuevo
      And Llenar Datos de Cliente Nuevo


    @Hiraoka
    Scenario: Como usuario registrado ingreso a Hiraoka a realizar una compra
      Given Ingreso a www.hiraoka.com.pe
      When Busco Televisores smart
      And Aniado al carro el primer articulo encontrado
      And Ir al Carrito
      And Selecciono comprar
      And Ingreso datos de usuario registrado



    @Hiraoka
    Scenario: Ingresar Telefono erroneo en el registro de usuario
      Given Ingreso a www.hiraoka.com.pe
      When Selecciono la opción Ingresar
      And Ingreso datos telefono erroneo
      Then Muestra mensaje telefono erroneo



