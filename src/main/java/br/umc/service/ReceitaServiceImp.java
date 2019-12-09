package br.umc.service;

import br.umc.model.Receita;
import br.umc.resource.ReceitaResource;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author Leandro
 */
public class ReceitaServiceImp implements ReceitaService{
    
@Autowired
ReceitaResource rec;

    @Override
    public List<Receita> getAllReceita(){
        return(List<Receita>)rec.findAll();
    }

     @Override
    public Receita getByid(Long id){
        return rec.findById(id).get();
    }


     @Override
    public void saveOrUpdate(Receita receitas){
        rec.save(receitas);
    }

     @Override
    public void deleteReceita(Long id){
        rec.deleteById(id);
    }

    @Override
    public Receita getById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}