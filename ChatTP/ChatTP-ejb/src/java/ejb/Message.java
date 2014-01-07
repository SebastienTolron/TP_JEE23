/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author hackman
 */
@Entity
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    private long date; //  s
   
    private String pseudo;
    
    private String contenu;

    
    
    public Message (){
        super();
        
    }
    
    public Message( String pseudo, String contenu){
        super();
   
        this.pseudo = pseudo;
        this.contenu = contenu;
    }
    

        /**
     * @return the date
     */
    public long getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(long date) {
        this.date = date;
    }

   
  
    
 
    @Override
    public String toString() {
        return "entity.Chat[ date=" + date  + "contenu= " + getContenu() + "]";
    }

    /**
     * @return the pseudo
     */
    public String getPseudo() {
        return pseudo;
    }

    /**
     * @param pseudo the pseudo to set
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    /**
     * @return the contenu
     */
    public String getContenu() {
        return contenu;
    }

    /**
     * @param contenu the contenu to set
     */
    public void setContenu(String contenu) {
        this.contenu = contenu;
    }


    
}
