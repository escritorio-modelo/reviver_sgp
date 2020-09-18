package net.projetoreviver.sgp.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import net.projetoreviver.sgp.annotations.ValidChamadaDate;

@Entity
@ValidChamadaDate
@Table(name = "tbl_chamada")
public class Chamada implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public Chamada() {
	}

	public Chamada(Long id, String descricao, LocalDate dataInicio, LocalDate dataTermino) {
		this.id = id;
		this.descricao = descricao;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column(length = 75, nullable = false)
	@NotBlank(message = "O campo descrição não pode estar em branco.")
	@Length(max = 75, message = "O campo descrição deve conter no máximo 75 caracteres.")
	private String descricao;
	
	@Column(name = "data_inicio", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "A chamada deve conter uma data de início.")
	@FutureOrPresent(message = "Data de Inicio Inválida.")
	private LocalDate dataInicio;
	
	@Column(name = "data_termino", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "A chamada deve conter uma data de término.")
	@FutureOrPresent(message = "Data de Término Inválida.")
	private LocalDate dataTermino;

	@OneToMany(mappedBy = "chamada")
	private List<RegistroChamadaPaciente> registrosPacientes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(LocalDate dataTermino) {
		this.dataTermino = dataTermino;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chamada other = (Chamada) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
