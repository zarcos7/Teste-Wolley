/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.umc.service;

import br.umc.dao.ClienteDAO;
import br.umc.model.Cliente;
import java.util.Comparator;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author wolley
 */
public class ClienteService {
    @Inject
    private ClienteDAO clienteDAO;

  
    public ClienteService(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }
    
      
    public ClienteService() {
        this(null);
    }

    public void cadastrar(Cliente cliente){
        clienteDAO.cadastrar(cliente);
    }
    
    
    public List<Cliente> listar(){
        return clienteDAO.lista();
    }
    
    public List<Cliente> listarOrdemAlfabetica(){
        
        List<Cliente> clientes = clienteDAO.lista();
        Comparator<Cliente> comparator = new Comparator<Cliente>() {

            @Override
            public int compare(Cliente c1, Cliente c2) {
              return c1.getNome().compareTo(c2.getNome());
            }
        };
        
        clientes.sort(comparator);
        
        return clientes ;
        
    }
    
}
