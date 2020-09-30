import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './feacture/components/home/home.component';
import { FacturaComponent } from './feacture/components/factura/factura.component';
import { MenuComponent } from './core/components/menu/menu.component';
import { FooterComponent } from './core/components/footer/footer.component';
import { HttpService } from './core/services/http.service';
import { HttpClientModule } from '@angular/common/http';
import { TipoElectrodomesticoService } from './shared/service/tipo-electrodomestico.service';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    FacturaComponent,
    MenuComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule
  ],
  providers: [HttpService, TipoElectrodomesticoService],
  bootstrap: [AppComponent]
})
export class AppModule { }
