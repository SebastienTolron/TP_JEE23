/**
 * 
 */
package fr.univ.savoie.jee.tp;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Seb
 *
 */
@Entity(name ="chat")
public class Chat implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public Chat(){
		super();
	}
	
	public Chat(int id , String nom )
	{
		super();
		this.chatId = id;
		this.chatNom = nom;
	}

	@Id
	private int chatId;
	

	@Column(name = "chatNom")
	private String chatNom;

	@OneToMany(mappedBy="detenteur")
	private Set<Message> messages = new HashSet<Message>();
	
	
	private synchronized int getCharId() {
		return chatId;
	}

	private synchronized void setCharId(int charId) {
		this.chatId = charId;
	}

	private synchronized String getChatNom() {
		return chatNom;
	}

	private synchronized void setChatNom(String chatNom) {
		this.chatNom = chatNom;
	}

	private synchronized Set<Message> getMessages() {
		return messages;
	}

	private synchronized void setMessages(Set<Message> messages) {
		this.messages = messages;
	}
	
}
