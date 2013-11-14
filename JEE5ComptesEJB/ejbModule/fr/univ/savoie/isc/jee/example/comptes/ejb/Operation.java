package fr.univ.savoie.isc.jee.example.comptes.ejb;

import java.util.Collection;

/**
 * @author St�phane Talbot
 *
 * Interface distante pour le bean session servant manipuler les comptes, on peut :
 * <ul>
 *   <li>cr�er des comptes,</li>
 *   <li>d�biter ou cr�diter le compte,</li>
 *   <li>transferer de l'argent d'un compte vers un autre.</li>
 * </ul>
 *  
 */
public interface Operation {
	/**
	 * Op�ration de cr�dit sur un compte : 
	 * 
	 * @param compte	identifiant du compte � cr�diter
	 * @param somme		somme � cr�diter
	 */
	public void crediter(String compte, double somme);
	/**
	 * Op�ration de d�biit sur un compte : 
	 * 
	 * @param compte	identifiant du compte � d�biter
	 * @param somme 	somme � d�biter
	 */
	public void debiter(String compte, double somme);
	/**
	 * Op�ration de transfert d'argent d'un compte vers un autre : 
	 * 
	 * @param de 	identifiant du compte � d�biter
	 * @param ver 	identifiant du compte � cr�diter
	 * @param somme	somme � transf�rer
	 * 
	 */
	public void transferer(String de, String vers, double somme);
	/**
	 * Cr�ation d'un nouveau compte : 
	 * 
	 * @param numero	l'identifiant du compte � cr�er 
	 * @param detenteur	le nom du propri�taire du compte
	 * @param solde		l'argent d�pos� � l'ouverture du compte
	 * 
	 */
	public void creerCompte(String numero, String detenteur, double solde);
	/**
	 * Cr�ation d'un nouveau client : 
	 * 
	 * @param client	le client � cr�er 
	 * 
	 */
	public void creerClient(Client client);
	/**
	 * R�cuperation d'un compte existant : 
	 * 
	 * @param numero	l'identifiant du compte � r�cup�rer 
	 *
	 * @return
	 */
	public Compte findByPrimaryKey(String numero);
	/**
	 * R�cuperation de la liste de comptes 
	 * dont le solde est inf�rieur � une valeur donn�e
	 * 
	 * @param montant	valeur sup�rieure pour le solde 
	 *
	 * @return
	 */
	public Collection findBySolde(double montant);
	/**
	 * R�cuperation de la liste de comptes 
	 * associ�s � un m�me d�tenteur.
	 * 
	 * @param owner	le detenteur du compte 
	 *
	 * @return
	 * @throws FinderException
	 */
	public Collection findByOwner(String owner);
}
