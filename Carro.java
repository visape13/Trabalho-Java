package br.com.garagem.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

/**
 *
 * @author Pablo Rangel <pablo.rangel@gmail.com>
 * @date 22/04/2021
 * @brief  class Produto
 */
@Entity
public class Carro implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long idCarro;
    @Size(min=1,message = "O modelo do carro precisa ser válido.")
    private String nome;
    private float preco;

    public long getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(long idCarro) {
        this.idCarro = idCarro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public String toString(){
        return nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}
