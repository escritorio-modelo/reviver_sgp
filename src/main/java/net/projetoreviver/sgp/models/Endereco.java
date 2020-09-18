package net.projetoreviver.sgp.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;


@Entity
@Table(name="tbl_endereco")
public class Endereco {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "end_id")
    private Long id;
    
    @Column(name = "end_numero", length = 10)
    @NotBlank(message = "Número é obrigatório.")
    private String numero;

    @Column(name = "end_cep", length = 8)
    @Length(min = 8, max = 8, message = "CEP deve conter 8 caracteres.")
    @NotBlank(message = "Insira um CEP.")
    @Pattern(regexp = "\\d{8}", message = "CEP inválido.")
    private String cep;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "rua_fk")
    @Valid
    private Rua rua;
    
    @Column(name = "end_complemento", length = 75)
    @Length(max = 75, message = "Complemento deve conter no máximo 75 caracteres.")
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