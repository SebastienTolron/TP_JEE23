package fr.univ.savoie.isc.jee.example.comptes.ejb;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Compte
 *
 */
@NamedQuery(name="findByOwner", query="Select c from Compte c where c.detenteur.numeroClient = 	:numClient")

@Entity
public class Compte implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String numero;
	private double solde;
	private Client detenteur;

	public Compte() {
		super();
	}   
	
	/**
	 * @param numero
	 * @param solde
	 */
	public Compte(String numero, double solde) {
		super();
		this.numero = numero;
		this.solde = solde;
	}

	@Id    
	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}   
	public double getSolde() {
		return this.solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}
	@ManyToOne
	public Client getDetenteur() {
		return detenteur;
	}
	public void setDetenteur(Client detenteur) {
		this.detenteur = detenteur;
	}
   
}
