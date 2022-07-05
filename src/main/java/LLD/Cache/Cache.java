package LLD.Cache;

import LLD.Cache.Eviction.EvictionPolicy;
import LLD.Cache.Storage.Storage;

public class Cache<Key, Value> {

    private final EvictionPolicy<Key> evictionPolicy;
    private final Storage<Key, Value> storage;

    public Cache(EvictionPolicy<Key> evictionPolicy,Storage<Key,Value>  storage){
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void put(Key key, Value value){
        try {
            storage.put(key, value);
            evictionPolicy.keyAccessed(key);
        }catch (Exception e){
            Key keyToRemove = evictionPolicy.evict();
            if (keyToRemove != null){
                storage.remove(keyToRemove);
            }
            storage.put(key, value);
            evictionPolicy.keyAccessed(key);
        }
    }

    public Value get(Key key){
        Value value = storage.get(key);
        evictionPolicy.keyAccessed(key);
        return value;
    }

}
