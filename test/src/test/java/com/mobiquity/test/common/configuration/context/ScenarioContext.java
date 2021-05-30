package com.mobiquity.test.common.configuration.context;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@SuppressWarnings("unchecked")
public class ScenarioContext {

    protected static final Map<ContextKey, Object> data = new HashMap<>();

    public void save(ContextKey key, Object value) {
        data.put(key, value);
    }

    public <T> T get(ContextKey key) {
        return (T) data.get(key);
    }

    public void clear() {
        data.clear();
    }

}
