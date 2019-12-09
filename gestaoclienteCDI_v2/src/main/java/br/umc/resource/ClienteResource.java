package br.umc.resource;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.umc.model.Cliente;
import br.umc.service.ClienteService;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author wolley
 */
@Path("/clientes")
public class ClienteResource {

    @Inject
    private ClienteService clienteService;

    public ClienteResource(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public ClienteResource() {
        this(null);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar() {
        GenericEntity<List<Cliente>> clientes = new GenericEntity<List<Cliente>>(clienteService.listar()) {};

        return Response.ok(clientes).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastro(Cliente cliente){
        
        System.out.println(cliente);
        clienteService.cadastrar(cliente);
        return Response.status(201).build();
    }

}
