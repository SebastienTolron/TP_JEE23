package ejb;

import ejb.Message;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-01-06T22:34:03")
@StaticMetamodel(Chat.class)
public class Chat_ { 

    public static volatile SingularAttribute<Chat, Long> id;
    public static volatile ListAttribute<Chat, Message> listMessage;
    public static volatile SingularAttribute<Chat, String> pname;

}