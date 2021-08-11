package br.com.basis.sgt.entities;

import enums.StatusTarefa;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@Entity(name = "Tb_tarefa")
public class Tarefa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String titulo;

	private LocalDateTime dataInicial;

	private LocalDateTime dataPrevista;

	private LocalDateTime dataEfetiva;

	private StatusTarefa status;

	private String tipoTarefa;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_tarefa")
	private List<Comentario> comentarios;

	@ManyToOne
	@JoinColumn(name = "id_responsavel")
	private Responsavel responsavel;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

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

	public StatusTarefa getStatus() {
		return status;
	}

	public void setStatus(StatusTarefa status) {
		this.status = status;
	}

	public String getTipoTarefa() {
		return tipoTarefa;
	}

	public void setTipoTarefa(String tipoTarefa) {
		this.tipoTarefa = tipoTarefa;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}
}
