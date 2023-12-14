package proyecto.pages;


import junit.framework.Assert;
import io.qameta.allure.Allure;

public class HiraokaPage extends BasePage{

    public HiraokaPage(){
    }
    private   String url="https://hiraoka.com.pe/";
    private String categoria="menu-dropdown-icon";
    private String subcategoria="(//div[@class='cat-m-int']//img)[1]";
    private String marca="(//div[@class='filter-options-title']//h2)[3]";
    private String marcaLG="//li[@data-label='LG']//a[1]";
    private String primerArticulo="(//img[@class='product-image-photo'])[1]";
    private String aniadirCarro="product-addtocart-button";
    private String busqueda="search";
    private String añadirPrimerArticulo="(//span[text()='Añadir al carro'])[1]";
    private String carrodeCompra="a.action.showcart";
    private String botoncomprar="//button[contains(@class,'action primary')]";
    private String botonCrearCuenta="//span[text()='Crea tu cuenta']";
    private String nombre="firstname";
    private String apellidoPaterno="lastname";
    private String fechaNacimiento="example-date";
    private String tipoDocumento="document_type";
    private String numeroDocumento="document_number";
    private String celular="cellphone";
    private String correoElectronico="email_address";
    private String password="password";
    private String aceptoFines="is_subscribed";
    private String aceptoTerm="custom-term-and-conditions";

    private String customerEmail="customer-email";
    private String customerPasword="pass";

    private String ingresar="a.hiraoka-login";

    private String registrase="//a[text()='Inicia sesión']/following-sibling::a";

    private String errorTelefono="(//div[@class='mage-error cellphone_error']//font)[2]";

    private String anioFecNac="ui-datepicker-year";

    private String mesFecNac="ui-datepicker-month";

    private String diaFecNac="div#ui-datepicker-div>table>tbody";

    public void navigateToUrl(){
        navigateTo(url);
    }
    public void selectCategoria(){


       selectElemListCssName(categoria,"ELECTROHOGAR");
    }
    public void selectSubCategoria(){
        clickElement(subcategoria);
    }

    public void selectMarca(){
        clickElement(marca);
        clickElement(marcaLG);
    }

    public void firstArticulo(){
        clickElement(primerArticulo);
    }
    public void addToCart(){
        clickElementId(aniadirCarro);
    }
    public void searchArticulo(String articulo){
        writeIdAndEnter(busqueda,articulo);
    }
    public void addToCartFirst(){
        clickElement(añadirPrimerArticulo);
    }
    public void goToCard(){
        clickElemtJavaScript(carrodeCompra);
    }
    public void selectComprar(){
        clickElement(botoncomprar);
    }
    public void createCuenta(){
       clickElement(botonCrearCuenta);
    }

    public void newAcount(String c_nombre,String c_apellidoPaterno , String c_fechaNacimiento,
                          String c_tipoDocumento, String c_numDocumento, String c_celular,
                          String c_correoElectronico, String c_password) throws InterruptedException {

        String dia = c_fechaNacimiento.substring(0,2);
        String mes = c_fechaNacimiento.substring(3,5);
        String anio = c_fechaNacimiento.substring(6);
        String mesAbrev="";
        switch (mes) {
            case "01":
                mesAbrev = "Ene";
                break;
            case "02":
                mesAbrev = "Feb";
                break;
            case "03" :
                mesAbrev = "Mar";
                break;
            case "04" :
                mesAbrev = "Abr";
                break;
            case "05" :
                mesAbrev = "May";
                break;
            case "06" :
                mesAbrev = "Jun";
                break;
            case "07" :
                mesAbrev = "Jul";
                break;
            case "08" :
                mesAbrev = "Ago";
                break;
            case "09" :
                mesAbrev = "Sep";
                break;
            case "10" :
                mesAbrev = "Oct";
                break;
            case "11" :
                mesAbrev = "Nov";
                break;
            case "12" :
                mesAbrev = "Dic";
                break;
            default:
                mesAbrev="";
        }

        writeId(nombre,c_nombre);
        writeId(apellidoPaterno, c_apellidoPaterno);
        selectFecNacimiento(anio,mesAbrev,dia);
        selectFromDropdownByValue(tipoDocumento,c_tipoDocumento);
        writeId(numeroDocumento,c_numDocumento);
        writeId(celular,c_celular);
        writeId(correoElectronico,c_correoElectronico);
        writeId(password,c_password);
        clickElementId(aceptoFines);
        clickElementId(aceptoTerm);

    }

    public void customerCredential(String email, String password){
        writeId(customerEmail,email);
        writeId(customerPasword, password);
    }

    public void chekIn(){
        clickElemtJavaScript(ingresar);
        clickElement(registrase);
    }

    public void validateTelefono(String mensajeError){
        String mensaje = textFromElement(errorTelefono);
        Assert.assertEquals(mensajeError, mensaje);
    }

    public void selectFecNacimiento(String year, String month, String day) {
        clickElementId(fechaNacimiento);
        selectYear(anioFecNac,year);
        selectMonth(mesFecNac, month);
        selectDay(diaFecNac, day);

    }



}
