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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.projetoreviver.sgp.annotations.ValidChamadaDate;

@Entity
@ValidChamadaDate
@Table(name = "tbl_chamada")
@Getter @Setter  @NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode
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
	private LocalDate dataInicio;

	@Column(name = "data_termino", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "A chamada deve conter uma data de término.")
	private LocalDate dataTermino;

	@JsonIgnore
	@OneToMany(mappedBy = "chamada")
	private List<RegistroChamadaPaciente> registrosPacientes;

}
