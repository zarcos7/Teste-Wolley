/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.umc.resource;

import br.umc.model.Cliente;
import br.umc.model.Medico;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Leandro
 */
public class MedicoResourceTest {
    private static final String API ="http://localhost:8080/gestaoclienteCDI_v2/api/medicos";
    
    @Test
    public void deveListarClientes(){
        String body = RestAssured.get(API)
                                 .body()
                                 .asString();
        
        Gson gson = new Gson();
        Medico[] medicos = gson.fromJson(body, Medico[].class);
        Assert.assertNotNull(medicos);
        Assert.assertEquals(4, medicos.length);
    }
}
