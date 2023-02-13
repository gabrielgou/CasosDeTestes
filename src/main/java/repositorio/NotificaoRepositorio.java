package main.java.repositorio;

import java.util.ArrayList;
import java.util.List;

public class NotificaoRepositorio {

	private List<String> notificacoesApp;
	
	private List<String> notificacoesEmail;
	
	public NotificaoRepositorio() {
		this.notificacoesApp = new ArrayList<>();
		this.notificacoesEmail = new ArrayList<>();
	}

	public List<String> getNotificacoesApp() {
		return notificacoesApp;
	}

	public List<String> getNotificacoesEmail() {
		return notificacoesEmail;
	}
}
