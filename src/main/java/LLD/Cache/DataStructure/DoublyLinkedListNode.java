package LLD.Cache.DataStructure;

public class DoublyLinkedListNode<E> {

    public DoublyLinkedListNode<E> prev;
    public DoublyLinkedListNode<E> next;
    public E value;


    public DoublyLinkedListNode(E value){
        prev = null;
        next = null;
        this.value = value;
    }
}
