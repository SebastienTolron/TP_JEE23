package fr.univsavoie.cours.exemplej2ee.interfaces;

import java.rmi.RemoteException;
import java.util.Collection;

import javax.ejb.EJBObject;
import javax.ejb.FinderException;

import fr.univ.savoie.isc.jee.example.comptes.ejb.Compte;

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
public interface Operation extends EJBObject {
	/**
	 * Opération de crédit sur un compte : 
	 * 
	 * @param compte	identifiant du compte à créditer
	 * @param somme		somme à créditer
	 * @throws RemoteException
	 */
	public void crediter(String compte, double somme) throws RemoteException;
	/**
	 * Opération de débiit sur un compte : 
	 * 
	 * @param compte	identifiant du compte à débiter
	 * @param somme 	somme à débiter
	 * @throws RemoteException
	 */
	public void debiter(String compte, double somme) throws RemoteException;
	/**
	 * Opération de transfert d'argent d'un compte vers un autre : 
	 * 
	 * @param de 	identifiant du compte à débiter
	 * @param ver 	identifiant du compte à créditer
	 * @param somme	somme à transférer
	 * 
	 * @throws RemoteException
	 */
	public void transferer(String de, String vers, double somme)
		throws RemoteException;
	/**
	 * Création d'un nouveau compte : 
	 * 
	 * @param numero	l'identifiant du compte à créer 
	 * @param detenteur	le nom du propriétaire du compte
	 * @param solde		l'argent déposé à l'ouverture du compte
	 * 
	 * @throws RemoteException
	 */
	public void creerCompte(String numero, String detenteur, double solde)
		throws RemoteException;
	/**
	 * Récuperation d'un compte existant : 
	 * 
	 * @param numero	l'identifiant du compte à récupérer 
	 *
	 * @return
	 * @throws RemoteException
	 * @throws FinderException
	 */
	public Compte findByPrimaryKey(String numero)
		throws RemoteException, FinderException;
	/**
	 * Récuperation de la liste de comptes 
	 * dont le solde est inférieur à une valeur donnée
	 * 
	 * @param montant	valeur supérieure pour le solde 
	 *
	 * @return
	 * @throws RemoteException
	 * @throws FinderException
	 */
	public Collection findBySolde(double montant)
		throws RemoteException, FinderException;
	/**
	 * Récuperation de la liste de comptes 
	 * associés à un même détenteur.
	 * 
	 * @param owner	le detenteur du compte 
	 *
	 * @return
	 * @throws FinderException
	 */
	public Collection findByOwner(String owner)
		throws RemoteException, FinderException;
}
