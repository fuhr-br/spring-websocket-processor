package tatsumibruno.samples.websocketprocessor;

public class Mensagem {
    private String remetente;
    private String mensagem;
    private Long id;
    public Mensagem() {
    }

    public Mensagem(String remetente, String mensagem) {
        this.remetente = remetente;
        this.mensagem = mensagem;
    }

    
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
