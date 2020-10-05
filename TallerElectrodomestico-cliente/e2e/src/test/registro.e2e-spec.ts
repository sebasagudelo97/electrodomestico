import { browser } from 'protractor';
import { AppPage } from "../app.po"
import { RegistroPage } from '../page/registro/registro.po';


describe('workspace-project Registro', () => {
    let page: AppPage;
    let registro: RegistroPage;
    let tipoElectrodomestico: {
        id: 1,
        descripcion: 'Licuadora',
        marca: 'ccc'
    }

    beforeEach(() => {
        page = new AppPage();
        registro = new RegistroPage();
    });

    it('deberia crear un registro', () => {
        const NOMBRE_CLIENTE= 'Sebastian';
        const CEDULA_CLIENTE= '1036960221';
        const FECHA_INGRESO= '2020-09-25';
        const TELEFONO= '3144568565';

        page.navigateTo();
        registro.clickBotonCrearRegistro();
        browser.sleep(1000);
        registro.ingresarNombreCliente(NOMBRE_CLIENTE);
        browser.sleep(1000);
        registro.ingresarCedulaCliente(CEDULA_CLIENTE);
        browser.sleep(1000);
        registro.ingresarFechaIngreso(FECHA_INGRESO);
        browser.sleep(1000);
        registro.ingresarTelefono(TELEFONO);
        browser.sleep(1000);
        registro.seleccionarTipoElectrodomestico();
        browser.sleep(1000);

        registro.botonCrear();
    })

    it('deberia listar todos los registros', () => {
        page.navigateTo();
        registro.botonListarTodo();
        browser.sleep(3000);
    })

    it('deberia mandar a entrega el registro', () => {
        const FECHA_SALIDA='2020-09-30';
        const VALOR_A_PAGAR = 5000;

        page.navigateTo();
        registro.botonListarTodo();
        registro.botonMandarAEntrega();
        registro.ingresarFechaSalda(FECHA_SALIDA);
        registro.ingresarValorPagar(VALOR_A_PAGAR);
        registro.botonActualizar();
        browser.sleep(3000);
    })

    it('Deberia listar los electrodomesticos para entrega', () => {
        page.navigateTo();
        registro.botonListarEntrega();
        browser.sleep(3000);
    })

    it('Deberia mandar a generar la factura', () => {
        page.navigateTo();
        registro.botonListarEntrega();
        registro.botonMandarAGenerarFactura();
        registro.botonCrearFactura();
        browser.sleep(3000);
    })
})