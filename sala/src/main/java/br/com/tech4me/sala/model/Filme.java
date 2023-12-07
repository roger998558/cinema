package br.com.tech4me.sala.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
@Entity
@Table(schema = "cinema", name = "filme ")
public class Filme {
   
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @JoinColumn( name ="nome_do_filme")
    private String nomeDofilme;

    @JoinColumn( name ="nome_do_autor")
    private String autorDoFilme; 

    @JoinColumn( name ="tempo_do_filme")
    private String tempoDoFilme; 
    
    @JoinColumn( name ="tipo_do_filme")
    private Tipo tipo;

    private String sinopse;

    public Filme (){

    }

   

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeDofilme() {
        return nomeDofilme;
    }

    public void setNomeDofilme(String nomeDofilme) {
        this.nomeDofilme = nomeDofilme;
    }

    public String getAutorDoFilme() {
        return autorDoFilme;
    }

    public void setAutorDoFilme(String autorDoFilme) {
        this.autorDoFilme = autorDoFilme;
    }

    public String getTempoDoFilme() {
        return tempoDoFilme;
    }

    public void setTempoDoFilme(String tempoDoFilme) {
        this.tempoDoFilme = tempoDoFilme;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    } 

    
}


