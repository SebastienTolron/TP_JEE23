package fr.univ.savoie.isc.jee.example.comptes.ejb;

import java.util.Collection;

/**
 * @author Stéphane Talbot
 *
 * Interface distante pour le bean session servant manipuler les comptes, on peut :
 * <ul>
 *   <li>créer des comptes,</li>
 *   <li>débiter ou créditer le compte,</li>
 *   <li>transferer de l'argent d'un compte vers un autre.</li>
 * </ul>
 *  
 */
public interface Operation {
	/**
	 * Opération de crédit sur un compte : 
	 * 
	 * @param compte	identifiant du compte à créditer
	 * @param somme		somme à créditer
	 */
	public void crediter(String compte, double somme);
	/**
	 * Opération de débiit sur un compte : 
	 * 
	 * @param compte	identifiant du compte à débiter
	 * @param somme 	somme à débiter
	 */
	public void debiter(String compte, double somme);
	/**
	 * Opération de transfert d'argent d'un compte vers un autre : 
	 * 
	 * @param de 	identifiant du compte à débiter
	 * @param ver 	identifiant du compte à créditer
	 * @param somme	somme à transférer
	 * 
	 */
	public void transferer(String de, String vers, double somme);
	/**
	 * Création d'un nouveau compte : 
	 * 
	 * @param numero	l'identifiant du compte à créer 
	 * @param detenteur	le nom du propriétaire du compte
	 * @param solde		l'argent déposé à l'ouverture du compte
	 * 
	 */
	public void creerCompte(String numero, String detenteur, double solde);
	/**
	 * Création d'un nouveau client : 
	 * 
	 * @param client	le client à créer 
	 * 
	 */
	public void creerClient(Client client);
	/**
	 * Récuperation d'un compte existant : 
	 * 
	 * @param numero	l'identifiant du compte à récupérer 
	 *
	 * @return
	 */
	public Compte findByPrimaryKey(String numero);
	/**
	 * Récuperation de la liste de comptes 
	 * dont le solde est inférieur à une valeur donnée
	 * 
	 * @param montant	valeur supérieure pour le solde 
	 *
	 * @return
	 */
	public Collection findBySolde(double montant);
	/**
	 * Récuperation de la liste de comptes 
	 * associés à un même détenteur.
	 * 
	 * @param owner	le detenteur du compte 
	 *
	 * @return
	 * @throws FinderException
	 */
	public Collection findByOwner(String owner);
}
