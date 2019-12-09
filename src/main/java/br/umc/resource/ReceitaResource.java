package br.umc.resource;

//import org.springframework.data.repository.CrudRepository;
import br.umc.model.Receita;
import br.umc.resource.config.CrudRepository;

public interface ReceitaResource extends CrudRepository<Receita, Long>{

    

}