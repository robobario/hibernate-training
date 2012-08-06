import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SimpleCriteriaTestCase extends EntityLoadingTestCase {

    private Service service = new Service();

    public SimpleCriteriaTestCase() {
        super(ImmutableSet.<Class>of(Account.class));
    }

    @Test
    public void testNumberOfAccounts(){
        Account alien = new Account("alien");
        Account zombie = new Account("zombie");
        session.save(alien);
        session.save(zombie);
        long numberOfAccounts = service.getNumberOfAccounts(session);
        assertEquals(2,numberOfAccounts);
    }

    @Test
    public void testNumberOfAccountsByName(){
        Account alien = new Account("alien");
        Account alien2 = new Account("alien");
        Account zombie = new Account("zombie");
        session.save(alien);
        session.save(alien2);
        session.save(zombie);
        Map<String,Long> numberOfAccounts = service.getNumberOfAccountsByName(session);
        assertEquals(ImmutableMap.of("alien",2l,"zombie",1l),numberOfAccounts);
    }

    @Test
    public void testGetAccountsByNameDescendingAlphabeticalOrder(){
        Account alien = new Account("alien");
        Account zombie = new Account("zombie");
        session.save(alien);
        session.save(zombie);
        long numberOfAccounts = service.getNumberOfAccounts(session);
        assertEquals(2,numberOfAccounts);
    }
}
