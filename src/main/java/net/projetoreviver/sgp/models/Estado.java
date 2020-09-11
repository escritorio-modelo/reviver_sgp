package net.projetoreviver.sgp.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "tbl_estado")
public class Estado {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "est_id")
    private Long id;

    @Column(name = "est_nome", length = 20)
    @Length(max = 20, message = "Nome do estado deve conter no máximo 20 caracteres.")
    @NotBlank(message = "Insira um estado.")
    private String nome;

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return String return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

}
