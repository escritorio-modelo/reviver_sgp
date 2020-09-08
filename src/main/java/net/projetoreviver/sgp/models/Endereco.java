package net.projetoreviver.sgp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="tbl_endereco")
public class Endereco {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "end_id")
    private Long id;
    
    @Column(name = "end_numero")
    private String numero;

    @Column(name = "end_cep")
    private String cep;

    @ManyToOne
    @JoinColumn(name = "rua_fk")
    private Rua rua;
    
    @Column(name = "end_complemento")
    private String complemento;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Rua getRua() {
        return rua;
    }

    public void setRua(Rua rua) {
        this.rua = rua;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

}