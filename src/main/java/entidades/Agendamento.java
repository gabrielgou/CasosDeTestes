package main.java.entidades;

import java.util.Date;

public class Agendamento {
	private Date dataAgendamento;
	private Cidadao cidadao;
	private String vacinaNome;
	public Date getDataAgendamento() {
		return dataAgendamento;
	}
	public void setDataAgendamento(Date dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}
	public Cidadao getCidadao() {
		return cidadao;
	}
	public void setCidadao(Cidadao cidadao) {
		this.cidadao = cidadao;
	}
	public String getVacinaNome() {
		return vacinaNome;
	}
	public void setVacinaNome(String vacinaNome) {
		this.vacinaNome = vacinaNome;
	}
	
	
}
