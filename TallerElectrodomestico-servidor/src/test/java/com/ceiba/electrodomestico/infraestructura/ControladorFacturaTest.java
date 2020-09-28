package com.ceiba.electrodomestico.infraestructura;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.ceiba.electrodomestico.TallerElectrodomesticoApplication;
import com.ceiba.electrodomestico.aplicacion.comando.ComandoFactura;
import com.ceiba.electrodomestico.dominio.databuilder.comando.ComandoFacturaTestDataBuilder;
import com.ceiba.electrodomestico.infraestructura.repositoriojpa.RepositorioFacturaJPA;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TallerElectrodomesticoApplication.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControladorFacturaTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RepositorioFacturaJPA repositorioFacturaJPA;


    @BeforeEach
    public void setUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void guardarFacturaTest() throws Exception{
        ComandoFactura comandoFactura = new ComandoFacturaTestDataBuilder().build();

        mockMvc.perform(post("/factura").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoFactura)))
                .andExpect(status().isOk());
    }
}
