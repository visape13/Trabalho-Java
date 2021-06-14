package br.com.garagem.repository;

import br.com.garagem.model.Venda;
import org.springframework.data.repository.CrudRepository;


/**
 *
 * @author Pablo Rangel <pablo.rangel@gmail.com>
 */
public interface VendaRepository extends CrudRepository<Venda,Long>{
    
}
