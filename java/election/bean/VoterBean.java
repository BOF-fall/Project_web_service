package election.bean;

import java.io.Serializable;

public class VoterBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String numero;
	private String candidat;
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCandidat() {
		return candidat;
	}
	public void setCandidat(String candidat) {
		this.candidat = candidat;
	}
	

}
