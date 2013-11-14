package fr.univ.savoie.isc.jee.example.comptes.ejb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @author St�phane Talbot
 *
 * Implantation d'un bean session pour manipuler les comptes, on peut :
 * <ul>
 *   <li>cr�er des comptes,</li>
 *   <li>d�biter ou cr�diter le compte,</li>
 *   <li>transferer de l'argent d'un compte vers un autre.</li>
 * </ul>
 *  
 */

@Stateless @Remote
public class OperationBean implements Operation {
	
	@PersistenceContext
	private EntityManager em;
	private SessionContext myCtx;

	@Resource
	public void setSessionContext(SessionContext arg0) {
	}

//	/**
//	 * Cr�ation d'une instance du bean session 
//	 * 
//	 * @throws CreateException
//	 */
//	public void ejbCreate() throws CreateException {
//		try {
//			// on recupere le contexte JNDI
//			Context jndiCtx = new InitialContext();
//			//dans le contexte JNDI, on recup�re la r�ference du Home local pour le bean entit�
//			compteHome = (CompteLocalHome)jndiCtx.lookup("java:comp/env/ejb/Compte");;
//		} catch (Exception e) {
//			throw new CreateException();
//		}
//	}

	/**
	 * Op�ration de cr�dit sur un compte : 
	 * 
	 * @param cpt		identifiant du compte � cr�diter
	 * @param montant	somme � cr�diter
	 * 
	 */
	public void crediter(String cpt, double montant) {
//		// on recupere le compte
//		Compte monCompte = em.find(Compte.class, cpt);
//		// on credite
//		double solde = monCompte.getSolde();
//		monCompte.setSolde(solde + montant);
		//puis on fait les verifications
		Query req = em.createQuery("Update Compte c set c.solde = c.solde + :montant where c.numero = :cpt");
		req.setParameter("montant", montant);
		req.setParameter("cpt", cpt);
		req.executeUpdate();
		if (montant <= 0) {
			throw new EJBException();
		}
	}
	/**
	 * Op�ration de d�bit sur un compte : 
	 * 
	 * @param cpt		identifiant du compte � d�biter
	 * @param montant	somme � d�biter
	 * 
	 */
	public void debiter(String cpt, double montant) {
		// on recupere le compte
		Compte monCompte = em.find(Compte.class, cpt);
		// on debite
		double solde = monCompte.getSolde();
		monCompte.setSolde(solde - montant);
		//puis on fait les verifications
		if ((montant < 0) || (monCompte.getSolde() < 0)) {
			throw new EJBException();
		}
	}
	/**
	 * Op�ration de transfert d'argent d'un compte vers un autre : 
	 * 
	 * @param de		identifiant du compte � d�biter
	 * @param vers		identifiant du compte � cr�diter
	 * @param montant	somme � transf�rer
	 * 
	 */
	public void transferer(String de, String vers, double montant) {
		// on recupere les comptes
		Compte cpt1 = em.find(Compte.class, de);
		Compte cpt2 = em.find(Compte.class, vers);
		// on effectue le transfert
		double solde2 = cpt2.getSolde();
		cpt2.setSolde(solde2 + montant);
		double solde1 = cpt1.getSolde();
		cpt1.setSolde(solde1 - montant);
		//puis on fait les verifications
		if ((montant < 0) || (cpt1.getSolde() < 0)) {
			System.err.println("erreur de solde");
			throw new EJBException();
		}
	}
	/**
	 * Cr�ation d'un nouveau compte : 
	 * 
	 * @param numero	l'identifiant du compte � cr�er 
	 * @param detenteur	le nom du propri�taire du compte
	 * @param solde		l'argent d�pos� � l'ouverture du compte
	 * 
	 */
	public void creerCompte(String numero, String detenteur, double solde) {
		try {
			// on creer le compte
			Compte cpt = new Compte(numero, solde);
			em.persist(cpt);
			Client client = em.find(Client.class, detenteur);
			cpt.setDetenteur(client);
			client.getComptes().add(cpt);
			// puis on fait les verifications...
			if ((solde < 0)) {
				throw new EJBException();
			}
		} catch (Exception e) {
			throw new EJBException();
		}
	}

	/**
	 * R�cuperation d'un compte existant : 
	 * 
	 * @param numero	l'identifiant du compte � r�cup�rer 
	 *
	 * @return
	 */
	public Compte findByPrimaryKey(String numero)  {
		return em.find(Compte.class, numero);
	}

	/**
	 * R�cuperation de la liste de comptes 
	 * dont le solde est inf�rieur � une valeur donn�e.
	 * 
	 * @param montant	valeur sup�rieure pour le solde 
	 *
	 * @return
	 */
	public Collection findBySolde(double montant) {
		Query req = em.createQuery("Select c from Compte c where c.solde < "+montant);
		return req.getResultList();
	}

	/**
	 * R�cuperation de la liste de comptes 
	 * associ�s � un m�me d�tenteur.
	 * 
	 * @param owner	le detenteur du compte 
	 *
	 * @return
	 */
	public Collection findByOwner(String owner) {
		Query req = em.createNamedQuery("findByOwner");
		req.setParameter("numClient", owner);
		return req.getResultList();
	}

	/**
	 * Cr�ation d'un nouveau client : 
	 * 
	 * @param client	le client � cr�er 
	 * 
	 */
	public void creerClient(Client client) {
		em.persist(client);
		
	}
}
