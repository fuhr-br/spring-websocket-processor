package tatsumibruno.samples.websocketprocessor;

public class Sala {

	private Integer id;
	private String usuario; 
	private String mensagem;

	public Sala(Integer id, String usuario, String mensagem) {
		this.mensagem = mensagem;
		this.id = id;
		this.usuario = usuario;
	}

	public Sala() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	
	
	

}
