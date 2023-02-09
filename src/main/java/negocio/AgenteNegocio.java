package main.java.negocio;


import main.java.entidades.AgenteSaude;
import main.java.repositorio.AgenteRepositorio;

public class AgenteNegocio {
	private AgenteRepositorio agenteRepositorio;
	public AgenteNegocio(AgenteRepositorio ar) {
		this.agenteRepositorio=ar;
	}
	
	public String addUsuario(AgenteSaude as) throws Throwable
	{
		if(as.getMatricula().isEmpty() || as.getEndereco().getBairro().isEmpty()
				|| as.getEndereco().getCidade().isEmpty() || as.getEndereco().getEstado().isEmpty()
				|| as.getEndereco().getnCasa()==0 || as.getEndereco().getNome().isEmpty()
				) throw new Throwable("Matricula não efetuada. Dados incompletos.");
		if(!agenteRepositorio.addUsuario(as)) throw new Throwable("Erro ao cadastrar. Usuário com cpf já cadastrado.");
		return "Email de cadastro enviado.";
	}

}
