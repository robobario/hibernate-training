import com.google.common.collect.ImmutableSet;
import org.hibernate.Session;

import java.util.List;
import java.util.Set;

public class Service {

    public List<Account> getAccountsByNameDescendingAlphabeticalOrder(Session session){
        return session.createCriteria(Account.class).list();
    }

    public List<Account> getAccountsByNameDescendingAlphabeticalOrderWithMaxResult(Session session,int maxResults){
        return session.createCriteria(Account.class).list();
    }

    public List<Account> getAccountsByNameDescendingAlphabeticalOrderWithMaxResultAndSkipResults(Session session, int i, int i1) {
        return session.createCriteria(Account.class).list();
    }

    public Account getAccountByName(Session session, String name) {
        return ((List<Account>)session.createCriteria(Account.class).list()).get(0);
    }

    public List<Account> getAccountsForNamesOrderedByNameAlphabeticalDesc(Session session, ImmutableSet<String> names) {
        return session.createCriteria(Account.class).list();
    }

    public Set<Account> getAccountsWithoutName(Session session, String derek) {
        return ImmutableSet.of();
    }

    public Set<Account> getAccountsWithNameGreaterThan(Session session, String alien) {
        return ImmutableSet.of();
    }
}
