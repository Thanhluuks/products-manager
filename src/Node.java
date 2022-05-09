//Class Node for Node in linked list
// with data made from Product
public class Node {
    private Product data;
    private Node nextNode;
    public Node(){
        this.data = null;
        this.nextNode = null;

    }
    public Node(Product data) {
        this.data = data;
        this.nextNode = null;
    }
    public Node(Product data, Node nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }

    public Product getData() {
        return data;
    }

    public void setData(Product data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
