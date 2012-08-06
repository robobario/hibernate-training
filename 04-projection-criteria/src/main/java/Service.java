import com.google.common.collect.ImmutableMap;
import org.hibernate.Session;

import java.util.Map;

public class Service {

    public long getNumberOfAccounts(Session session) {
        //Do nawt use list.size() or equivalent. We want to count like we would in SQL.
        return 0;
    }

    public Map<String, Long> getNumberOfAccountsByName(Session session) {
        return ImmutableMap.of();
    }
}
