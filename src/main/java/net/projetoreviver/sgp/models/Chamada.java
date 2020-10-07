package net.projetoreviver.sgp.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.projetoreviver.sgp.annotations.ValidChamadaDate;

@Entity
@ValidChamadaDate
@Table(name = "tbl_chamada")
@Getter @Setter  @NoArgsConstructor @AllArgsConstructor
@ToString(exclude = "id")
public class Chamada implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column(name = "titulo", nullable = false)
	@NotBlank(message = "Título Obrigatório.")
	private String titulo;

	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	private StatusChamada status;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Chamada other = (Chamada) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
