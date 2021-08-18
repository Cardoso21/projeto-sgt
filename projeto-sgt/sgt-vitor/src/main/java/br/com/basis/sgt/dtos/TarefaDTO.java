package br.com.basis.sgt.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import enums.StatusTarefa;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class TarefaDTO {
	

	private Long id;
	
	@NotBlank(message = "Informe um titulo")
	private String titulo;

	@Future(message = "A data deve ser do futuro !")
//	@JsonFormat(pattern = "dd/MM/yyyy HH:SS")
	private LocalDateTime dataInicial;

	@Future(message = "A data deve ser do futuro !")
//	@JsonFormat(pattern = "dd/MM/yyyy HH:SS")
	private LocalDateTime dataPrevista;

//	@JsonFormat(pattern = "dd/MM/yyyy HH:SS")
	private LocalDateTime dataEfetiva;

	private String tipoTarefa;

	private StatusTarefa status;

	private List<ComentarioDTO> comentarios;

	private Long idResponsavel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDateTime getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(LocalDateTime dataInicial) {
		this.dataInicial = dataInicial;
	}

	public LocalDateTime getDataPrevista() {
		return dataPrevista;
	}

	public void setDataPrevista(LocalDateTime dataPrevista) {
		this.dataPrevista = dataPrevista;
	}

	public LocalDateTime getDataEfetiva() {
		return dataEfetiva;
	}

	public void setDataEfetiva(LocalDateTime dataEfetiva) {
		this.dataEfetiva = dataEfetiva;
	}

	public String getTipoTarefa() {
		return tipoTarefa;
	}

	public void setTipoTarefa(String tipoTarefa) {
		this.tipoTarefa = tipoTarefa;
	}

	public StatusTarefa getStatus() {
		return status;
	}

	public void setStatus(StatusTarefa status) {
		this.status = status;
	}

	public List<ComentarioDTO> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<ComentarioDTO> comentarios) {
		this.comentarios = comentarios;
	}

	public Long getIdResponsavel() {
		return idResponsavel;
	}

	public void setIdResponsavel(Long idResponsavel) {
		this.idResponsavel = idResponsavel;
	}
}
