/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import ejb.Chat;
import ejb.Message;
import java.util.ArrayList;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.client.Client;

/**
 *
 * @author Thomas
 */
@Stateless
@LocalBean
public class ChatManager {

   
    @PersistenceContext
    private EntityManager entityManager;

    public ChatManager() {
    }

    public void saveChat(Chat chat) {

        this.entityManager.persist(chat);

    }

    public Chat findId(Chat colis) {
        Chat p = entityManager.find(Chat.class, colis.getId());
        return p;
    }

    public List retrieveAllChat() {

        Query query = entityManager.createQuery("SELECT chat FROM Chat AS chat");
        return (List<Chat>) query.getResultList();

    }

    public Chat findChat(Long parameter) {
        System.out.println("ID22 = "+parameter);
        Chat p = entityManager.find(Chat.class,parameter);
        System.err.println("CHAT = "+p);
        return p;

    }

    public void remove(Long parameter) {
        Chat c2 = entityManager.find(Chat.class,parameter);
        entityManager.remove(c2);
    }
    
    public void postMessage(Chat c1 , Message m1 )
    {
         Chat c2 = entityManager.find(Chat.class,c1.getId());
         c2.addMessage(m1);         
                 
         this.update(c2);
    }

    public void update(Chat c2) {
           this.entityManager.merge(c2);
    }
    
    public ArrayList<Message> retrieveAllMessage(Chat c1) {
        
       Chat c2 = entityManager.find(Chat.class,c1.getId());       
       return c2.getListMessage();            
        }

     
}
