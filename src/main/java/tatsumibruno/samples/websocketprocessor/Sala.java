package tatsumibruno.samples.websocketprocessor;

public class Sala {

	private Integer id;
	private Integer numPlayers;

	public Sala(Integer id, Integer numPlayers) {

		this.id = id;
		this.numPlayers = numPlayers;
	}

	public Sala() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumPlayers() {
		return numPlayers;
	}

	public void setNumPlayers(Integer numPlayers) {
		this.numPlayers = numPlayers;
	}
	
	

}
