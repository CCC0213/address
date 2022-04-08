package mysql;

import java.util.HashMap;
import java.util.Map;

public class Update {

    private Map<String, Object> sets = new HashMap<>();
    private Map<String, Object> incs = new HashMap<>();

    public Map<String, Object> getSets() {
        return sets;
    }

    public void setSets(Map<String, Object> sets) {
        this.sets = sets;
    }

    public Map<String, Object> getIncs() {
        return incs;
    }

    public void setIncs(Map<String, Object> incs) {
        this.incs = incs;
    }
}

