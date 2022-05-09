//Class MyQueue for Queue database
public class MyQueue extends OperationToProduct {
    private Node head;
    public MyQueue(){
        head = null;
    }
    public boolean isEmpty(){
        return head ==null;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }
}
