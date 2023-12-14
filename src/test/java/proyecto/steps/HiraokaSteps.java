package proyecto.steps;

import com.qa.util.ExcelReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import proyecto.pages.HiraokaPage;

import java.io.IOException;

public class HiraokaSteps {

    HiraokaPage hiraoka = new HiraokaPage();
    ExcelReader excelReader = new ExcelReader();

    @Given("^Ingreso a www.hiraoka.com.pe$")
    public void ingresoHiraoka(){
        hiraoka.navigateToUrl();
    }

    @When("^Selecciono categoria Eletrohogar$")
    public void seleccionoCategoria() throws InterruptedException{
        hiraoka.selectCategoria();
    }

    @And("^Selecciono Electrodomesticos Refrigeradora$")
    public void seleccionoSubcategoria() throws InterruptedException{
        hiraoka.selectSubCategoria();
    }
    @And("^Selecciono Marca LG$")
    public void seleccionoMarca() throws InterruptedException{
        hiraoka.selectMarca();
    }

    @And("^Selecciono Primer articulo$")
    public void primerArticulo() throws InterruptedException{
        hiraoka.firstArticulo();
    }

    @And("^Aniado al carrito$")
    public void aniadoAlCarro() throws InterruptedException{
        hiraoka.addToCart();
    }


    @And("^Busco Televisores smart$")
    public void buscoArticulo() throws InterruptedException{
        hiraoka.searchArticulo("Televisor");
    }

    @And("^Aniado al carro el primer articulo encontrado$")
    public void aniadoPrimerArticulo()throws InterruptedException{
        hiraoka.addToCartFirst();
    }

    @And ("Ir al Carrito")
    public void irAlCarrito()throws InterruptedException{
        hiraoka.goToCard();
    }


    @And ("Selecciono comprar")
    public void seleccionoComprar() throws InterruptedException{
        hiraoka.selectComprar();
    }

    @And ("Selecciono Compra como Cliente Nuevo")
    public void comprarClienteNuevo() throws InterruptedException{
        hiraoka.createCuenta();

    }

    @And("Llenar Datos de Cliente Nuevo")
    public void llenarDatosClienteNuevo() throws InterruptedException, IOException {


        String filePath= "D:\\ProyectoHiraoka\\archivos\\DatosHiraoka.xlsx";
        String nombre = excelReader.lectExcel(filePath,"Hoja1","A2");
        String apellidoPaterno = excelReader.lectExcel(filePath,"Hoja1","B2");
        String fechaNacimiento = excelReader.lectExcel(filePath,"Hoja1","C2");
        String tipoDocumento = excelReader.lectExcel(filePath,"Hoja1","D2");
        String numeroDocumento = excelReader.lectExcel(filePath,"Hoja1","E2");
        String celular = excelReader.lectExcel(filePath,"Hoja1","F2");
        String correoElectronico = excelReader.lectExcel(filePath,"Hoja1","G2");
        String password = excelReader.lectExcel(filePath,"Hoja1","H2");

        hiraoka.newAcount(nombre,apellidoPaterno,fechaNacimiento,tipoDocumento,numeroDocumento,
                celular,correoElectronico,password);

    }

    @And("Ingreso datos de usuario registrado")
    public void llenarDatosUsuarioRegistrado() throws InterruptedException, IOException{
        String filePath= "D:\\ProyectoHiraoka\\archivos\\DatosHiraoka.xlsx";
        String email = excelReader.lectExcel(filePath,"Hoja2","A2");
        String password = excelReader.lectExcel(filePath,"Hoja2","B2");

        hiraoka.customerCredential(email,password);


    }

    @Then("Cerrar")
    public void CerrarPage(){
        System.out.println("Cerrar");

    }

    @And("Selecciono la opción Ingresar")
    public void ingresar() throws InterruptedException{
        hiraoka.chekIn();
    }

    @Before
    public void setup(){
        System.out.println("Ingreso al Before");
        hiraoka.setup();

    }

    @And("Ingreso datos telefono erroneo")
    public  void erroneo()throws InterruptedException , IOException{
        String filePath= "D:\\ProyectoHiraoka\\archivos\\DatosHiraoka.xlsx";
        String nombre = excelReader.lectExcel(filePath,"Hoja1","A3");

        String apellidoPaterno = excelReader.lectExcel(filePath,"Hoja1","B3");
        String fechaNacimiento = excelReader.lectExcel(filePath,"Hoja1","C3");
        String tipoDocumento = excelReader.lectExcel(filePath,"Hoja1","D3");
        String numeroDocumento = excelReader.lectExcel(filePath,"Hoja1","E3");
        String celular = excelReader.lectExcel(filePath,"Hoja1","F3");
        String correoElectronico = excelReader.lectExcel(filePath,"Hoja1","G3");
        String password = excelReader.lectExcel(filePath,"Hoja1","H3");

        hiraoka.newAcount(nombre,apellidoPaterno,fechaNacimiento,tipoDocumento,numeroDocumento,
                celular,correoElectronico,password);
    }

    @And("Muestra mensaje telefono erroneo")
    public void mensajeValidacion() throws InterruptedException , IOException{

        String filePath= "D:\\ProyectoHiraoka\\archivos\\DatosHiraoka.xlsx";
        String mensaje = excelReader.lectExcel(filePath,"Hoja3","B1");

        hiraoka.validateTelefono(mensaje);
    }

    @After
    public void tearDown(Scenario scenario){
        hiraoka.cerrar(scenario);
    }


}
