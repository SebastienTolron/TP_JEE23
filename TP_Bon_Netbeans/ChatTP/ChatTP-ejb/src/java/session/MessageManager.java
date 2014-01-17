/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import ejb.Chat;
import ejb.Message;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Thomas
 */
@Stateless
@LocalBean
public class MessageManager {

        @PersistenceContext
	private EntityManager entityManager;

	public MessageManager() {
	}

		public void saveMessage(Message message) {

		this.entityManager.persist(message);

	}

		public List retrieveAllMessage() {

		Query query = entityManager.createQuery("SELECT message FROM Message AS message");
		return (List<Message>)query.getResultList();
		
	}
}
