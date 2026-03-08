package com.example.map;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO (student):
 * Implement Flyweight factory that caches MarkerStyle by a stable key.
 *
 * Suggested key format:
 *   shape + "|" + color + "|" + size + "|" + (filled ? "F" : "O")
 *
 * After refactor:
 * - MapDataSource should call this factory to obtain shared MarkerStyle instances.
 */
public class MarkerStyleFactory {

    private static final Map<String, MarkerStyle> cache = new HashMap<>();

    public static MarkerStyle get(String shape, String color, int size, boolean filled) {
        String key = shape + "|" + color + "|" + size + "|" + (filled ? "F" : "O");
        // TODO: return cached instance if present; otherwise create, cache, and return.
        if(cache.containsKey(key)) return cache.get(key); 
        else cache.put(key, new MarkerStyle(shape, color, size, filled)); 
        return cache.get(key); 
    }

    public int cacheSize() {
        return cache.size();
    }
}
