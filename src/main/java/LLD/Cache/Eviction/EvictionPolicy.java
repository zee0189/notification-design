package LLD.Cache.Eviction;

public interface EvictionPolicy<Key> {

    void keyAccessed(Key key);

    Key evict();

}
