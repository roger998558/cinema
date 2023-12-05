package br.com.tech4me.bilheteria.model;




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;


@Entity
@Table(schema = "cinema", name ="sala")
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "numero_da_sala")
    private Integer numeroDasala;
    @JoinColumn(name = "status_do_filme")
    private Status status;
    @JoinColumn(name = "imagem_do_filme")
    private Imagem imagemDoFilme;
  


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
    
    

    
}

