import javax.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne()
    private Slot slot;

    public Long getId(){
       return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }
}
