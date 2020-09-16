package net.projetoreviver.sgp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "tbl_bairro")
public class Bairro {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bairro_id")
    private Long id;
    
    @Column(name = "bairro_nome", length = 45)
    @Length(max = 45, message = "Nome do bairro deve conter no máximo 45 caracteres.")
    @NotBlank(message = "Insira um bairro.")
    private String nome;

    
    @ManyToOne
    @JoinColumn(name = "cidade_fk")
    private Cidade cidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

}