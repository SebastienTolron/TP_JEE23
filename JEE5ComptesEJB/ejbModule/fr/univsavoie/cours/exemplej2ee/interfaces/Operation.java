package fr.univsavoie.cours.exemplej2ee.interfaces;

import java.rmi.RemoteException;
import java.util.Collection;

import javax.ejb.EJBObject;
import javax.ejb.FinderException;

import fr.univ.savoie.isc.jee.example.comptes.ejb.Compte;

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
public interface Operation extends EJBObject {
	/**
	 * Op�ration de cr�dit sur un compte : 
	 * 
	 * @param compte	identifiant du compte � cr�diter
	 * @param somme		somme � cr�diter
	 * @throws RemoteException
	 */
	public void crediter(String compte, double somme) throws RemoteException;
	/**
	 * Op�ration de d�biit sur un compte : 
	 * 
	 * @param compte	identifiant du compte � d�biter
	 * @param somme 	somme � d�biter
	 * @throws RemoteException
	 */
	public void debiter(String compte, double somme) throws RemoteException;
	/**
	 * Op�ration de transfert d'argent d'un compte vers un autre : 
	 * 
	 * @param de 	identifiant du compte � d�biter
	 * @param ver 	identifiant du compte � cr�diter
	 * @param somme	somme � transf�rer
	 * 
	 * @throws RemoteException
	 */
	public void transferer(String de, String vers, double somme)
		throws RemoteException;
	/**
	 * Cr�ation d'un nouveau compte : 
	 * 
	 * @param numero	l'identifiant du compte � cr�er 
	 * @param detenteur	le nom du propri�taire du compte
	 * @param solde		l'argent d�pos� � l'ouverture du compte
	 * 
	 * @throws RemoteException
	 */
	public void creerCompte(String numero, String detenteur, double solde)
		throws RemoteException;
	/**
	 * R�cuperation d'un compte existant : 
	 * 
	 * @param numero	l'identifiant du compte � r�cup�rer 
	 *
	 * @return
	 * @throws RemoteException
	 * @throws FinderException
	 */
	public Compte findByPrimaryKey(String numero)
		throws RemoteException, FinderException;
	/**
	 * R�cuperation de la liste de comptes 
	 * dont le solde est inf�rieur � une valeur donn�e
	 * 
	 * @param montant	valeur sup�rieure pour le solde 
	 *
	 * @return
	 * @throws RemoteException
	 * @throws FinderException
	 */
	public Collection findBySolde(double montant)
		throws RemoteException, FinderException;
	/**
	 * R�cuperation de la liste de comptes 
	 * associ�s � un m�me d�tenteur.
	 * 
	 * @param owner	le detenteur du compte 
	 *
	 * @return
	 * @throws FinderException
	 */
	public Collection findByOwner(String owner)
		throws RemoteException, FinderException;
}
