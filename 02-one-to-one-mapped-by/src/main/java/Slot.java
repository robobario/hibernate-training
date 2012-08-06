import javax.persistence.*;

@Entity
public class Slot {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne()
    private Account account;

    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
