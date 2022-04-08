package mysql;

import java.util.HashMap;
import java.util.Map;

public class Query {
    private Map<String,Object> values = new HashMap<>();

    public Query equals(String name,Object value){
        values.put(name,value);
        return this;
    }

    public Map<String, Object> getValues() {
        return values;
    }

    public void setValues(Map<String, Object> values) {
        this.values = values;
    }
}