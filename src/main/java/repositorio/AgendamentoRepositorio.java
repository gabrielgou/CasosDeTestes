package main.java.repositorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import main.java.entidades.Agendamento;
import main.java.entidades.Cidadao;

public class AgendamentoRepositorio {
	List<Agendamento> agendamentos;
	
	public AgendamentoRepositorio() {
		this.agendamentos = new ArrayList<>();
	}

	public boolean cadastrar(Agendamento ag) {
		return agendamentos.add(ag);
	}
	
	public Agendamento get(String nome, Date d) {
		Agendamento a = null;
		for (Agendamento agendamento : agendamentos) {
			if(agendamento.getCidadao().getNome().equals(nome) && agendamento.getDataAgendamento().equals(d)) {
				a = agendamento;
			}
		}
		
		return a;
	}
	
}
