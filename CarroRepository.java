package br.com.garagem.repository;

import org.springframework.data.repository.CrudRepository;
import br.com.garagem.model.Carro;

/**
 *
 * @author Pablo Rangel <pablo.rangel@gmail.com>
 */
public interface CarroRepository extends CrudRepository<Carro,Long>{
    
}
