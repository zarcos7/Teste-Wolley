/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.umc.resource;

import br.umc.model.Cliente;
import br.umc.model.Medico;
import br.umc.service.ClienteService;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Leandro
 */
@Path("/medicos")
public class MedicoResource {
      @Inject
    private MedicoResource medicoService;

    public MedicoResource(MedicoResource medicoResource) {
        this.medicoService = medicoService;
    }

    public MedicoResource() {
        this(null);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar() {
        GenericEntity<List<Medico>> clientes = new GenericEntity<List<Medico>>((List<Medico>) medicoService.listar()) {};

        return Response.ok(clientes).build();
    }
}
