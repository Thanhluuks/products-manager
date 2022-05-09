//Class MyStack for Stack database
public class MyStack extends OperationToProduct {
    Node head;
    public MyStack(){
        head = null;
    }
    public boolean isEmpty(){
        return head==null;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }
}
