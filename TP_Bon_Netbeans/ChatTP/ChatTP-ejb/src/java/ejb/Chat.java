/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author hackman
 */
@Entity
public class Chat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;        
    @OneToMany(mappedBy="",fetch=FetchType.EAGER, orphanRemoval=true)
    private ArrayList<Message> listMessage;
    private String pname;
    private boolean etat;
    
    
    
    public Chat (){
        super();
        this.listMessage = new ArrayList<Message>();
    }
    
    public Chat( String pname){
        super();
        this.pname = pname;
        this.listMessage = new ArrayList<Message>();
    }
    
     public Chat( String pname,boolean etats){
        super();
        this.pname = pname;
        this.listMessage = new ArrayList<Message>();
        this.etat = etats;
    }
    
    

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    
    public ArrayList<Message> getListMessage() {
        return listMessage;
    }

    public void setListMessage(ArrayList<Message> listMessage) {
        this.listMessage = listMessage;
    }
    
    
    public String getname() {
        return pname;
    }
    public void setname(String pname) {
        this.pname = pname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chat)) {
            return false;
        }
        Chat other = (Chat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Chat[ id=" + id  + "name= " + pname + "]";
    }

    public void addMessage(Message m1) {

        this.listMessage.add(m1);
    }
    
}
