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
import java.util.Comparator;
import java.util.List;
import javax.inject.Inject;
/**
 *
 * @author Leandro
 */
public class MedicoService {
    @Inject
    private MedicoDAO medicoDAO;

  
    public MedicoService(MedicoDAO medicoDAO) {
        this.medicoDAO = medicoDAO;
    }
    
      
    public MedicoService() {
        this(null);
    }

    public void cadastrar(Medico medico){
        medicoDAO.cadastrar(medico);
    }
    
    
    public List<Medico> listar(){
        return medicoDAO.lista();
    }
    
    public List<Medico> listarOrdemAlfabetica(){
        
        List<Medico> medicos = medicoDAO.lista();
        Comparator<Medico> comparator = new Comparator<Medico>() {

            @Override
            public int compare(Medico c1, Medico c2) {
              return c1.getNome().compareTo(c2.getNome());
            }
        };
        
        medicos.sort(comparator);
        
        return medicos ;
        
    }
    
}
