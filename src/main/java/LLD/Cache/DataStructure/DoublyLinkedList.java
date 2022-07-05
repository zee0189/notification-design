package LLD.Cache.DataStructure;

public class DoublyLinkedList<E> {

    public DoublyLinkedListNode<E> head;
    public DoublyLinkedListNode<E> tail;

    public DoublyLinkedList() {
        head = new DoublyLinkedListNode<>(null);
        tail = new DoublyLinkedListNode<>(null);
    }

    public void detachNode(DoublyLinkedListNode<E> node) {
        if (node != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public DoublyLinkedListNode<E> addNode(E value){
        DoublyLinkedListNode<E> node = new DoublyLinkedListNode<>(value);
        addNodeFirst(node);
        return node;
    }

    public void addNodeFirst(DoublyLinkedListNode<E> node){
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }


    public DoublyLinkedListNode<E> removeLastNode(){
        DoublyLinkedListNode<E> node = tail.prev;
        detachNode(node);
        return node;
    }
}
