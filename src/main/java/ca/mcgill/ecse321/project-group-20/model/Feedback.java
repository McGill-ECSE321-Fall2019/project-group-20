import javax.persistence.ManyToOne;
import javax.persistence.Entity;

@Entity
public class Feedback{
   private Session session;
   
   @ManyToOne(optional=false)
   public Session getSession() {
      return this.session;
   }
   
   public void setSession(Session session) {
      this.session = session;
   }
   
   }
