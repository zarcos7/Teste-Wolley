/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.umc.resource;

import br.umc.model.Cliente;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author alunocmc
 */
public class ClienteResourceTest {
    
    private static final String API ="http://localhost:8080/gestaoclienteCDI_v2/api/clientes";
    
    @Test
    public void deveListarClientes(){
        String body = RestAssured.get(API)
                                 .body()
                                 .asString();
        
        Gson gson = new Gson();
        Cliente[] clientes = gson.fromJson(body, Cliente[].class);
        Assert.assertNotNull(clientes);
        Assert.assertEquals(4, clientes.length);
    }
    
}
