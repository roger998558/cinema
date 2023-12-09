package br.com.tech4me.bilheteria.model;

import java.util.Optional;

import br.com.tech4me.bilheteria.shared.BilheteCompletoDTO;
import br.com.tech4me.bilheteria.shared.BilheteDTO;
import br.com.tech4me.bilheteria.shared.StatusDaPoltronaDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "cinema", name = "bilhete ")
public class Bilhete {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Double Valor;
    private Integer quantidade;
    private OpcaoMeiaOuInteira opcao;
    private LugarDaPoltrona lugar;
    private Fila fila;
    private Status status;
    @JoinColumn(name = "id_sala")
    @OneToOne
    private Optional<Sala> sala;

    

    public Bilhete(BilheteCompletoDTO bilheteDTO ){
        setId(bilheteDTO.id());
        setValor(bilheteDTO.Valor());
        setQuantidade(bilheteDTO.quantidade());
        setOpcao(bilheteDTO.opcao());
       setLugar(bilheteDTO.lugar(),bilheteDTO.status());
        setFila(bilheteDTO.fila());
        setStatus(bilheteDTO.status());
        setSala(bilheteDTO.sala());
        

    }

    public Bilhete (BilheteDTO bilheteDTO){
        setId(bilheteDTO.id());
        setValor(bilheteDTO.Valor());
        setOpcao(bilheteDTO.opcao());
        setLugar(bilheteDTO.lugar());
        setFila(bilheteDTO.fila());
        setStatus(bilheteDTO.status());
       
    }

    public Bilhete (StatusDaPoltronaDTO bilheteDTO){
        setLugar(bilheteDTO.lugar(),bilheteDTO.status());
        setStatus(bilheteDTO.status());


    }
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Double getValor() {
        return Valor;
    }
    public void setValor(Double valor) {
        if (opcao == OpcaoMeiaOuInteira.MEIA) {
             this. Valor = valor * quantidade/2;
        }
       this.Valor = valor * quantidade;
      
    }
    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
    public OpcaoMeiaOuInteira getOpcao() {
        return opcao;
    }
    public void setOpcao(OpcaoMeiaOuInteira opcao) {
        this.opcao = opcao;
    }
    public LugarDaPoltrona getLugar() {
        return lugar;
    }
    public void setLugar(LugarDaPoltrona lugar , Status status) {
        this.lugar = lugar;
        this.status = status;
    }
    public Fila getFila() {
        return fila;
    }
    public void setFila(Fila fila) {
        this.fila = fila;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setLugar(LugarDaPoltrona lugar) {
        this.lugar = lugar;
    }

    public Optional<Sala> getSala() {
        return sala;
    }

    public void setSala(Optional<Sala> optional) {
        this.sala = optional;
    }
   
   
}


