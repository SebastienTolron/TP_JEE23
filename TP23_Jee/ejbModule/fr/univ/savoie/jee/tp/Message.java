package fr.univ.savoie.jee.tp;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity(name ="chat")
public class Message implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Chat detenteur;
	
	
	public Message(){
		super();
	}

	@Id
	private int MessageId;

	@ManyToOne
	public Chat getDetenteur() {
		return detenteur;
	}
	public void setDetenteur(Chat detenteur) {
		this.detenteur = detenteur;
	}
}
