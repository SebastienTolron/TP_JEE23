package fr.univ.savoie.jee.tp;


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


@Stateless @Remote
public class ChatManagerBean implements ChatManager {
	
	@PersistenceContext
	private EntityManager em;
	private SessionContext myCtx;

	@Resource
	public void setSessionContext(SessionContext arg0) {
	}


	public void creerChat(int id,String nom) {
		try {
			// on creer le chat
			Chat c1 =  new Chat(1,"Chat de test");			
			em.persist(c1);
			
		} catch (Exception e) {
			throw new EJBException();
		}
	}

}
