import com.google.common.collect.ImmutableSet;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class OneToOneTestCase extends EntityLoadingTestCase {

    public OneToOneTestCase() {
        super(ImmutableSet.<Class>of(Account.class, Slot.class));
    }

    /*
        We expect an exception because I want slot on account to be mandatory!
     */
    @Test(expected = ConstraintViolationException.class)
    public void testMandatorySlotOnAccount(){
        Account account = new Account();
        session.save(account);
    }

    /*
        Make the account save cascade to the slot
    */
    @Test
    public void testSaveAccountSavesSlot(){
        Account account = new Account();
        Slot slot = new Slot();
        account.setSlot(slot);
        session.save(account);
        assertNotNull(slot.getId());
    }
}
