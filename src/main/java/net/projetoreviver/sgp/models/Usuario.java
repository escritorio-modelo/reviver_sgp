package net.projetoreviver.sgp.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.JoinColumn;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import net.projetoreviver.sgp.annotations.ValidEmail;

@Entity
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usu_id")
    private Long id;

    @Column(name = "usu_cpf", columnDefinition = "char(11)", nullable = false, unique = true)
	@CPF(message = "CPF Inválido")
	@NotBlank(message = "O campo CPF é obrigatório")
	@Length(min = 11, max = 11, message = "O campo CPF deve conter 11 caracteres.")
	private String cpf;

    @Column(name = "usu_ativo")
    private int ativo;

    @Column(name = "usu_data_nasci", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "O campo data de nascimento é obrigatório.")
    @Past(message = "A data de nascimento tem que ser anterior a data atual.")
    private Date dataNascimento;

    @Column(name = "usu_data_registro", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataRegistro;

    @Column(name="usu_email")
    @ValidEmail
    private String email;
    
    @Column(name = "usu_genero", nullable = false, columnDefinition = "char(1)")
	@NotNull(message = "O campo gênero deve estar selecionado.")
	private Character genero;

    /*
    private Status status;

    @Column(name="usu_endereco")
    private Endereco endereco;

    */


    @ElementCollection
    @CollectionTable(name = "usu_tel", 
        joinColumns = @JoinColumn(name= "usu_id"))
    @Column(name = "usu_tel", length = 12, nullable = false)
    private List<String> telefone=  new ArrayList<>();


    @PrePersist
    protected void onCreate(){
        dataRegistro = new Date();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId(){
        return this.id;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Character getGenero() {
        return genero;
    }

    public void setGenero(Character genero) {
        this.genero = genero;
    }

   /* public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
*/
    public List<String> getTelefone() {
        return telefone;
    }

    public void setTelefone(List<String> telefone) {
        this.telefone = telefone;
    }

}