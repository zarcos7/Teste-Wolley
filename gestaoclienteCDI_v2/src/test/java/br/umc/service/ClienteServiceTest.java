/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.umc.service;

import br.umc.dao.ClienteDAO;
import br.umc.model.Cliente;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

/**
 *
 * @author alunocmc
 */
@RunWith(MockitoJUnitRunner.class)
public class ClienteServiceTest {
    
    @InjectMocks
    private ClienteService clienteService;
    
    @Mock
    private ClienteDAO clienteDAO;
    
    @Test
    public void deveListaTodosClientes(){
        
        when(clienteDAO.lista()).thenReturn(getClientes());
        
        List<Cliente> clientes = clienteService.listar();
        
        assertNotNull(clientes);
        assertEquals(3, clientes.size());

    }
    
    @Test
    public void deveListarClienteOrdenado(){
        when(clienteDAO.lista()).thenReturn(getClientes());
        
        List<Cliente> clientes = clienteService.listarOrdemAlfabetica();
        
        assertNotNull(clientes);
        assertEquals(3, clientes.size());
        assertEquals(clientes.get(0).getNome(), "Aline da Silva");
        assertEquals(clientes.get(1).getNome(), "Bruno da Silva");
        assertEquals(clientes.get(2).getNome(), "Carlos da Silva");
    }

    private List<Cliente> getClientes() {
       return Arrays.asList(new Cliente(1, "Carlos da Silva", "111.111.111-11", "1111-1111", "Rua UMC, 78"),
                            new Cliente(2, "Bruno da Silva", "222.222.222-22", "2222-2222", "Rua UMC, 22"),
                            new Cliente(3, "Aline da Silva", "333.333.333-33", "3333-3333", "Rua UMC, 33"));
    }
    
    
}
