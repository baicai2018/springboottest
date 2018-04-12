package com.nondo.maven.conf;

import java.util.HashMap;
import java.util.Map;

public class Cache {
    private Map<String,Object> map = new HashMap<>();

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
