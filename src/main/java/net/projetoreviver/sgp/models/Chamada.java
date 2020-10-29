package net.projetoreviver.sgp.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import net.projetoreviver.sgp.groups.ValidationGroups;
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
@ToString()
public class Chamada implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@NotNull(groups = ValidationGroups.ChamadaId.class)
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
	@ToString.Exclude
	@OneToMany(mappedBy = "chamada", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<RegistroChamadaPaciente> registrosPacientes = new ArrayList<>();


	@PrePersist
	public void prePersist(){
		this.setStatus(StatusChamada.ABERTA);
	}
}
