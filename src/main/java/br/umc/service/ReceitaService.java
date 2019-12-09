/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.umc.service;

import br.umc.model.Receita;
import java.util.List;
/**
 *
 * @author Leandro
 */

public interface ReceitaService {
    
    public List<Receita> getAllReceita();
 

    public Receita getByid(Long id);
        
    

    public void saveOrUpdate(Receita receitas);
    
    

    public void deleteReceita(Long id)
     ;

    public Receita getById(Long id);
    


}
