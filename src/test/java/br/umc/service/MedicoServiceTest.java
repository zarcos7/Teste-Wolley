/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.umc.service;
import br.umc.dao.ClienteDAO;
import br.umc.dao.MedicoDAO;
import br.umc.model.Cliente;
import br.umc.model.Medico;
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
 * @author Leandro
 */
@RunWith(MockitoJUnitRunner.class)
public class MedicoServiceTest {
    @InjectMocks
    private MedicoService medicoService;
    
    @Mock
    private MedicoDAO medicoDAO;
    
    @Test
    public void deveListaTodosClientes(){
        
        when(medicoDAO.lista()).thenReturn(getMedicos());
        
        List<Medico> medicos = medicoService.listar();
        
        assertNotNull(medicos);
        assertEquals(3, medicos.size());

    }
    
    @Test
    public void deveListarMedicoOrdenado(){
        when(medicoDAO.lista()).thenReturn(getMedicos());
        
        List<Medico> medicos = medicoService.listarOrdemAlfabetica();
        
        assertNotNull(medicos);
        assertEquals(3, medicos.size());
        assertEquals(medicos.get(0).getNome(), "Gabriela");
        assertEquals(medicos.get(1).getNome(), "Leandro");
        assertEquals(medicos.get(2).getNome(), "Raphael");
    }

    private List<Medico> getMedicos() {
       return Arrays.asList(new Medico(1, "Gabriela", "111.111.111-11", "1111-1111", "Rua UMC, 78", "123"),
                            new Medico(2, "Leandro", "222.222.222-22", "2222-2222", "Rua UMC, 22", "456"),
                            new Medico(3, "Raphael", "333.333.333-33", "3333-3333", "Rua UMC, 33", "789"));
    }
}
