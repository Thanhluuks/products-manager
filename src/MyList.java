//Class MyList for Linked list database
public class MyList extends OperationToProduct{
    private Node head;
    private Node tail;
    public MyList() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int length(){
        int length =0;
        Node current = head;
        while (current!=null) {
            length++;
            current =current.getNextNode();
        }
        return length;
    }
    public void clear() {
        this.head = null;
        this.tail = null;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public void setHead(Node head) {
        this.head = head;
    }
}
