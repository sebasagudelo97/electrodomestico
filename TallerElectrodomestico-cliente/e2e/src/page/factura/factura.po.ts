import { by, element } from 'protractor';


export class FacturaPage{

    private linkListarFactura = element(by.id('linkListarFactura'));

    async clickBotonListarFacturas(){
        await this.linkListarFactura.click();
    }

}