import { browser } from 'protractor';
import { AppPage } from "../app.po"
import { FacturaPage } from '../page/factura/factura.po';


describe('workspace-project Factura', () => {
    let page: AppPage;
    let factura: FacturaPage;

    beforeEach(() => {
        page = new AppPage();
        factura = new FacturaPage();
    });

    it('deberia listar las facturas', () => {
        page.navigateTo();
        factura.clickBotonListarFacturas();
        browser.sleep(3000);
    })
});