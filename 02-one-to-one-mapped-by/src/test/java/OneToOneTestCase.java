import com.google.common.collect.ImmutableSet;
import org.junit.Test;

public class OneToOneTestCase extends EntityLoadingTestCase {

    public OneToOneTestCase() {
        super(ImmutableSet.<Class>of(Account.class, Slot.class));
    }

    /*
        As the sql whizzes by the final two lines (updates which occur on session.flush()) show that two updates are
        occurring, this is because a OneToOne can be mapped with a foreign key in both tables. If you want Account to be
        the only table with the foreign key you tell Slot that it's account is mapped by a property on the Account.

        Make this change so that only one update is executed.
     */
    @Test
    public void testMandatorySlotOnAccount(){
        Account account = new Account();
        Slot slot = new Slot();
        Slot slot2 = new Slot();
        account.setSlot(slot);
        slot.setAccount(account);
        session.save(account);
        session.save(slot);
        session.save(slot2);
        account.setSlot(slot2);
        session.save(account);
        session.flush();
    }
}
