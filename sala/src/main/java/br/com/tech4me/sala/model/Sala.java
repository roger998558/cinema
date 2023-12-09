package br.com.tech4me.sala.model;


import br.com.tech4me.sala.shared.SalaCompletaDTO;
import br.com.tech4me.sala.shared.SalaDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(schema = "cinema", name ="sala")
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numeroDasala;
    private Status status;
    private Imagem imagemDoFilme;
    @JoinColumn(name = "id_filme")
    @OneToMany
    private Filme filme;

   public Sala(){

   }
   public Sala(SalaCompletaDTO dtc){
   setNumeroDasala(dtc.numeroDasala());
   setImagemDoFilme(dtc.imagemDoFilme());
   setStatus(dtc.status());
   setFilme(filme);
    
   }
     public Sala(SalaDTO dto){
   setNumeroDasala(dto.numeroDasala());
   setImagemDoFilme(dto.imagemDoFilme());
    
   }


    public Integer getNumeroDasala() {
        return numeroDasala;
    }
    public void setNumeroDasala(Integer numeroDasala) {
        this.numeroDasala = numeroDasala;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public Imagem getImagemDoFilme() {
        return imagemDoFilme;
    }
    public void setImagemDoFilme(Imagem imagemDoFilme) {
        this.imagemDoFilme = imagemDoFilme;
    }
    public Filme getFilme() {
        return filme;
    }
    public void setFilme(Filme filme) {
        this.filme = filme;
    }
    
    

    
}
