package com.ceiba.electrodomestico.infraestructura;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.hasSize;

import com.ceiba.electrodomestico.TallerElectrodomesticoApplication;
import com.ceiba.electrodomestico.aplicacion.comando.ComandoRegistro;
import com.ceiba.electrodomestico.dominio.databuilder.ComandoRegistroTestDataBuilder;
import com.ceiba.electrodomestico.infraestructura.repositoriojpa.RepositorioRegistroJPA;
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
public class ControladorRegistroTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RepositorioRegistroJPA repositorioRegistroJPA;

    @BeforeEach
    public void setUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void guardarRegistroTest() throws Exception {
        ComandoRegistro comandoRegistro = new ComandoRegistroTestDataBuilder().build();

        mockMvc.perform(post("/registro").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoRegistro)))
                .andExpect(status().isOk());
    }

    @Test
    public void listarTodoTest() throws Exception{
        mockMvc.perform(get("/registro")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombreCliente", is("sebastian")));
    }

    @Test
    public void listarParaEntregaTest() throws Exception{
        mockMvc.perform(get("/registro/entrega")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombreCliente", is("sebastian")));
    }
}
