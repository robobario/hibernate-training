import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class SimpleCriteriaTestCase extends EntityLoadingTestCase {

    private Service service = new Service();

    public SimpleCriteriaTestCase() {
        super(ImmutableSet.<Class>of(Account.class));
    }

    /*
        Make dat service get you accounts ordered up the what.
     */
    @Test
    public void testGetAccountsByNameDescendingAlphabeticalOrder(){
        Account alien = new Account("alien");
        Account zombie = new Account("zombie");
        session.save(alien);
        session.save(zombie);
        List<Account> accounts = service.getAccountsByNameDescendingAlphabeticalOrder(session);
        assertEquals(ImmutableList.of(zombie,alien),accounts);
    }

    @Test
    public void testGetAccountsByNameDescendingAlphabeticalOrder_WithMaxResults(){
        Account alien = new Account("alien");
        Account zombie = new Account("zombie");
        session.save(alien);
        session.save(zombie);
        List<Account> accounts = service.getAccountsByNameDescendingAlphabeticalOrderWithMaxResult(session, 1);
        assertEquals(ImmutableList.of(zombie),accounts);
    }

    @Test
    public void testGetAccountsByNameDescendingAlphabeticalOrder_WithMaxResults_AndSkipResults(){
        Account alien = new Account("alien");
        Account zombie = new Account("zombie");
        session.save(alien);
        session.save(zombie);
        List<Account> accounts = service.getAccountsByNameDescendingAlphabeticalOrderWithMaxResultAndSkipResults(session, 1, 1);
        assertEquals(ImmutableList.of(alien),accounts);
    }

    @Test
    public void testGetAccountsByNameDescendingAlphabeticalOrder_FindByName(){
        Account alien = new Account("alien");
        Account derek = new Account("derek");
        Account zombie = new Account("zombie");
        session.save(alien);
        session.save(derek);
        session.save(zombie);
        Account account = service.getAccountByName(session, "derek");
        assertEquals(derek,account);
    }

    @Test
    public void testGetAccountsByNamesDescendingAlphabeticalOrder_FindByNames(){
        Account alien = new Account("alien");
        Account derek = new Account("derek");
        Account zombie = new Account("zombie");
        session.save(alien);
        session.save(derek);
        session.save(zombie);
        List<Account> accounts = service.getAccountsForNamesOrderedByNameAlphabeticalDesc(session, ImmutableSet.of("derek", "alien"));
        assertEquals(ImmutableList.of(derek,alien),accounts);
    }

    @Test
    public void testGetAccountsWithoutName(){
        Account alien = new Account("alien");
        Account derek = new Account("derek");
        Account zombie = new Account("zombie");
        session.save(alien);
        session.save(derek);
        session.save(zombie);
        Set<Account> accounts = service.getAccountsWithoutName(session,"derek");
        assertEquals(ImmutableSet.of(alien,zombie),accounts);
    }

    @Test
    public void testGetAccountsWithNameGreaterThan(){
        Account alien = new Account("alien");
        Account derek = new Account("derek");
        Account zombie = new Account("zombie");
        session.save(alien);
        session.save(derek);
        session.save(zombie);
        Set<Account> accounts = service.getAccountsWithNameGreaterThan(session,"alien");
        assertEquals(ImmutableSet.of(derek,zombie),accounts);
    }
}
