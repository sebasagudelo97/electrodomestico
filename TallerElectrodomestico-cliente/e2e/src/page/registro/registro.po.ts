import { browser, by, element } from 'protractor';
import { protractor } from 'protractor/built/ptor';

export class RegistroPage{

    private linkCrearRegistro = element(by.id('linkCrearRegistro'));
    private linkListarRegistrosNoEntrega = element(by.id('linkListarTodo'))
    private inputNombreCliente = element(by.id('nombre'));
    private inputCedulaCliente = element(by.id('cedula'));
    private inputFechaIngreso = element(by.id('fecha-ingreso'));
    private inputTelefono = element(by.id('telefono'));
    private tipoElectrodomestico = element(by.id('inputState'));
    private botonCrearRegistro = element(by.id('crearRegistro'));
    private linkMandarAEntrega = element(by.id('mandar-entrega'));
    private inputFechaSalida = element(by.id('fecha-salida'));
    private inputValorPagar = element(by.id('valorPagar'));
    private linkActualizarRegistro = element(by.id('actualizar'));
    private linkListarEntrega = element(by.id('linkListarEntrega'));
    private linkMandarAGenerarFactura = element(by.id('generar-factura'));
    private linkCrearFactura = element(by.id('crearFactura'));

    async clickBotonCrearRegistro(){
        await this.linkCrearRegistro.click();
    }

    async ingresarNombreCliente(nombreCliente){
        await this.inputNombreCliente.sendKeys(nombreCliente);
    }

    async ingresarCedulaCliente(cedulaCliente){
        await this.inputCedulaCliente.sendKeys(cedulaCliente);
    }

    async ingresarFechaIngreso(fechaIngreso){
       await this.inputFechaIngreso.sendKeys(fechaIngreso);
    }

    async ingresarTelefono(telefono){
        await this.inputTelefono.sendKeys(telefono);
    }

    async seleccionarTipoElectrodomestico(){
     await this.tipoElectrodomestico.click().then(() => {
         element(by.cssContainingText("option", "Licuadora")).click();
     })
    }

    async ingresarFechaSalda(fechaSalida){
        await this.inputFechaSalida.sendKeys(fechaSalida);
    }

    async ingresarValorPagar(valorPagar){
        await this.inputValorPagar.sendKeys(valorPagar);
    }

    async botonListarTodo(){
        await this.linkListarRegistrosNoEntrega.click();
    }

    async botonCrear(){
        await this.botonCrearRegistro.click();
    }

    async botonActualizar(){
        await this.linkActualizarRegistro.click();
    }

    async botonMandarAEntrega(){
        await this.linkMandarAEntrega.click();
    }

    async botonListarEntrega(){
        await this.linkListarEntrega.click();
    }

    async botonMandarAGenerarFactura(){
        await this.linkMandarAGenerarFactura.click();
    }

    async botonCrearFactura(){
        await this.linkCrearFactura.click();
    }

}