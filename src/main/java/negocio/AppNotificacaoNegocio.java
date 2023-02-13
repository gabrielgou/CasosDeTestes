package main.java.negocio;

import java.util.List;

import main.java.repositorio.NotificaoRepositorio;

public class AppNotificacaoNegocio {
	
	private NotificaoRepositorio ar;

	public AppNotificacaoNegocio(NotificaoRepositorio ar) {
		this.ar = ar;
	}

	public List<String> buscaNotificacoesApp() {
		return ar.getNotificacoesApp();
	}

	public List<String> buscaNotificacoesEmail() {
		return ar.getNotificacoesEmail();
	}
}
