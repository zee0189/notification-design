package LLD.Cache.Eviction;

import LLD.Cache.DataStructure.DoublyLinkedList;
import LLD.Cache.DataStructure.DoublyLinkedListNode;

import java.util.HashMap;
import java.util.Map;

public class LRUBasedEviction<Key> implements EvictionPolicy<Key>{

    private final DoublyLinkedList<Key> doublyLinkedList;
    private final Map<Key, DoublyLinkedListNode<Key>> mapper;

    public LRUBasedEviction(){
        this.doublyLinkedList = new DoublyLinkedList<>();
        this.mapper = new HashMap<>();
    }

    @Override
    public void keyAccessed(Key key) {
       if (mapper.containsKey(key)){
           DoublyLinkedListNode<Key> node = mapper.get(key);
           doublyLinkedList.detachNode(node);
           doublyLinkedList.addNodeFirst(node);
       }else {
           DoublyLinkedListNode<Key> node = doublyLinkedList.addNode(key);
           mapper.put(key, node);
       }
    }

    @Override
    public Key evict() {
        DoublyLinkedListNode<Key> node = doublyLinkedList.removeLastNode();
        if (node == null){
            return null;
        }
        return node.value;
    }
}
