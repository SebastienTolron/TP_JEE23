package fr.univ.savoie.isc.jee.example.comptes.ejb;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client implements Serializable {

	private static final long serialVersionUID = 4978999415657219306L;
	
	@Id
	private String numeroClient;
	private String titre;
	private String nom;
	private String prenom;
	private String adresse;
	
	@OneToMany(mappedBy="detenteur")
	private Set<Compte> comptes = new HashSet<Compte>();
	
	public Client() {
	}
	
	/**
	 * @param numeroClient
	 * @param titre
	 * @param nom
	 * @param prenom
	 * @param adresse
	 */
	public Client(String numeroClient, String titre, String nom, String prenom,
			String adresse) {
		this.numeroClient = numeroClient;
		this.titre = titre;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}

	public String getNumeroClient() {
		return numeroClient;
	}
	public void setNumeroClient(String numeroClient) {
		this.numeroClient = numeroClient;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Set<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}

}
