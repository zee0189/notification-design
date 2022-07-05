package LLD.Cache.Storage;

import LLD.Cache.Exception.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage<Key, Value> implements Storage<Key, Value> {

    private final int capacity;
    private Map<Key, Value> storage;

    public HashMapBasedStorage(int capacity){
        this.capacity = capacity;
        this.storage = new HashMap<>();
    }

    @Override
    public void put(Key key, Value value) {
       if(isStorageFull()){
           throw new StorageFullException("Storage is full");
       }
       storage.put(key, value);
    }

    @Override
    public Value get(Key key) {
        Value value = storage.get(key);
        if (value == null){
            throw new IllegalArgumentException("The given key doesn't exists");
        }
        return value;
    }

    @Override
    public void remove(Key key) {
      if (!storage.containsKey(key)){
          throw new IllegalArgumentException();
      }
      storage.remove(key);
    }

    public boolean isStorageFull(){
        return capacity == this.storage.size();
    }
}
