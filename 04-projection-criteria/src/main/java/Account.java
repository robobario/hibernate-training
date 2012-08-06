import com.google.common.base.Objects;

import javax.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    public Account(String name) {
        this.name = name;
    }

    public Account() {
    }

    public Long getId(){
       return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("name",getName()).add("id",getId()).toString();
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(getName(),getId());
    }

    @Override
    public boolean equals(final Object obj){
        if(obj instanceof Account){
            final Account other = (Account) obj;
            return Objects.equal(getName(), other.getName())
                    && Objects.equal(getId(), other.getId());
        } else{
            return false;
        }
    }
}
