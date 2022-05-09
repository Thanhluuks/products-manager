import java.io.*;
import java.util.Scanner;

public class OperationToProduct {
    /**
     * Create a new product form keyboard input by user.
     * @return product
     */
    public Product createProduct(){
        PrintOutLn("Input new product's ID: ");
        String id = ScannerString();
        PrintOutLn("Input new product's name: ");
        String name = ScannerString();
        PrintOutLn("Input new product's price: ");
        double price = ScannerDouble();
        PrintOutLn("Input new product's quantity: ");
        int qty = ScannerInt();
        return new Product(id,name,price,qty);
    }

    /**
     * Read a filename file and store information into myList
     * @param filename a String name of file
     * @param myList the linked list
     */
    public void getProductsFromFile(String filename, MyList myList) {
        myList.clear();
        try {
            if(fileIsEmpty(filename)) {
                myList.PrintOutLn("File is empty");
                return;
            }
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] s = line.split("\s{2,}");
                String id = s[1];
                if(id.equalsIgnoreCase("ID")) continue;
                String name = s[3];
                double price = Double.parseDouble(s[5]);
                int qty = Integer.parseInt(s[7]);
                Product newProduct = new Product(id,name,price,qty);
                addProduct(myList,newProduct);
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Read a filename file and store information into myStack
     * @param filename a String name of file
     * @param myStack the MyStack
     */
    public void getProductsFromFile(String filename, MyStack myStack) {
        try {
            if(fileIsEmpty(filename)) {
                PrintOutLn("File is empty");
                return;
            }
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] s = line.split("\s{2,}");
                String id = s[1];
                if(id.equalsIgnoreCase("ID")) continue;
                String name = s[3];
                double price = Double.parseDouble(s[5]);
                int qty = Integer.parseInt(s[7]);
                Product newProduct = new Product(id,name,price,qty);
                Node newNode = new Node(newProduct);
                push(myStack,newNode);
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read a filename file and store information into myQueue
     * @param filename a String name of file
     * @param myQueue a MyQueue
     */
    public void getProductsFromFile(String filename, MyQueue myQueue) {
        try {
            if(fileIsEmpty(filename)) {
                PrintOutLn("File is empty");
                return;
            }
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] s = line.split("\s{2,}");
                String id = s[1];
                if(id.equalsIgnoreCase("ID")) continue;
                String name = s[3];
                double price = Double.parseDouble(s[5]);
                int qty = Integer.parseInt(s[7]);
                Product newProduct = new Product(id,name,price,qty);
                Node newNode = new Node(newProduct);
                EnQueue(myQueue,newNode);
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Check file is empty or not
     * @param filename a String name of file
     * @return true if file empty
     */
    public boolean fileIsEmpty(String filename){
        File file = new File(filename);
        return file.length() == 0;
    }

    /**
     * Write all products from myList to filename file
     * @param filename the file
     * @param myList the linked list
     */
    public void writeListToFile(String filename, MyList myList) {
        try {
            FileWriter fw = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(fw);
            if(fileIsEmpty(filename)){
                String rowTile = String.format("|  %-20s |  %-20s  |  %-20s  |  %-20s  |","ID","Name","Price","Quantity");
                bw.write(rowTile);
                bw.newLine();
            }
            Node current = myList.getHead();
            while (current!=null) {
                String id = current.getData().getID();
                String name = current.getData().getName();
                double price = current.getData().getPrice();
                int qty = current.getData().getQty();
                String s = String.format("|  %-20s |  %-20s  |  %-20.1f  |  %-20d  |",id,name,price,qty);
                bw.write(s);
                bw.newLine();
                current =current.getNextNode();
            }
            myList.PrintOutLn("\nSuccessfully!");
            bw.close();
            fw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  Add a new product to myList from keyboard input by user.
     * @param myList The linked list
     */
    public void addProduct( MyList myList) {
        Product newProduct = createProduct();
        addProduct(myList, newProduct);
        myList.PrintOutLn("\nSuccessfully!");
    }

    /**
     * Add a new product from a new product input to myList
     * @param myList the linked list
     * @param newProduct a Product
     */
    public void addProduct(MyList myList, Product newProduct ){
        Node newNode = new Node(newProduct);
        addProduct(myList, newNode);
    }

    /**
     * Add a new product from a new Node to myList at last position
     * @param myList the linked list
     * @param newNode a Node
     */
    public void addProduct(MyList myList, Node newNode) {
        if(myList.isEmpty()) {
            myList.setHead(newNode);
            myList.setTail(newNode);
        }
        else {
            myList.getTail().setNextNode(newNode);
            myList.setTail(newNode);
        }
    }

    /**
     * Add a new product from a new Node to myList at head position
     * @param myList the linked list
     * @param newNode a Node
     */
    public void addHead(MyList myList, Node newNode) {
        if(myList.isEmpty()) {
            myList.setHead(newNode);
            myList.setTail(newNode);
        }
        else{
            newNode.setNextNode(myList.getHead());
            myList.setHead(newNode);
        }
    }

    /**
     * Push a new Node to MyStack
     * @param myStack a MyStack destination
     * @param newNode a Node
     */
    public void push(MyStack myStack, Node newNode){
        if(myStack.isEmpty()){
            myStack.setHead(newNode);
        }
        else {
            newNode.setNextNode(myStack.getHead());
            myStack.setHead(newNode);
        }
    }

    /**
     * Pop a Node from MyStack
     * @param myStack a MyStack from
     * @return a top Node
     */
    public Product pop(MyStack myStack){
        Product topProduct = myStack.getHead().getData();
        myStack.setHead(myStack.getHead().getNextNode());
        return topProduct;
    }

    /**
     * Add a new Node to MyQueue
     * @param myQueue a MyQueue destination
     * @param newNode a new Node
     */
    public void EnQueue(MyQueue myQueue, Node newNode){
        if(myQueue.isEmpty()){
           myQueue.setHead(newNode);
        }
        else {
            Node curr =myQueue.getHead();
            while (curr.getNextNode()!=null){
                curr=curr.getNextNode();
            }
            curr.setNextNode(newNode);
        }
    }

    /**
     * Get a front Node and remove it in MyQueue
     * @param myQueue a MyQueue from
     * @return a front Node
     */
    public Product DeQueue(MyQueue myQueue){
        Node nodeReturn = myQueue.getHead();
        myQueue.setHead(myQueue.getHead().getNextNode());
        return nodeReturn.getData();
    }
    /**
     * Display all products of myList
     * @param myList the linked list
     */
    public void display(MyList myList) {
        Node current = myList.getHead();
        while (current!=null) {
            PrintOutLn(current.getData().toString());
            current =current.getNextNode();
        }
        myList.PrintOutLn("\nSuccessfully!");
    }

    /**
     * Display all information of myStack
     * @param myStack a MyStack
     */
    public void display(MyStack myStack) {
        while (!myStack.isEmpty()){
            PrintOutLn(myStack.pop(myStack).toString());
        }
        PrintOutLn("\nSuccessfully!");

    }
    public void display(MyQueue myQueue) {
        while (!myQueue.isEmpty()){
            PrintOutLn(myQueue.DeQueue(myQueue).toString());
        }
        PrintOutLn("\nSuccessfully!");
    }

    /**
     * Search a product by ID from user input keyboard.
     * @param myList the linked list.
     * @return a Product
     */
    public Product searchProuct(MyList myList) {
        myList.PrintOutLn("What is ID? ");
        String id = ScannerString();
        Node current = myList.getHead();
        while (current!=null) {
            String currentId = current.getData().getID();
            if(id.equalsIgnoreCase(currentId)){
                return current.getData();
            }
            current =current.getNextNode();
        }
        return null;
    }

    /**
     * Display a product form search product by ID
     * @param myList the linked list
     */
    public void displaySearchProduct(MyList myList){
        Product searchProduct = searchProuct(myList);
        if(searchProduct !=null) PrintOutLn(searchProduct.toString());
        else myList.PrintOutLn("-1");
    }

    /**
     * Delete a product form myList by ID
     * @param myList the linked list
     */
    public void deleteProduct(MyList myList){
        Product searchProduct = searchProuct(myList);
        if(searchProduct !=null){
            Node current = myList.getHead();
            if(current.getData().equals(searchProduct)){
                myList.setHead(current.getNextNode());
                return;
            }
            while (current.getNextNode()!=null){
                if(current.getNextNode().getData().equals(searchProduct)){
                    if(current.getNextNode().getNextNode()==null){
                        current.setNextNode(null);
                        break;
                    }
                    else {
                        current.setNextNode(current.getNextNode().getNextNode());
                        break;
                    }
                }
                current=current.getNextNode();
            }
            myList.PrintOutLn("Deleted!");
        }
        else myList.PrintOutLn("Do not have any product with that id.");
    }

    /**
     * Quicksort a linked list by ID follow ABC order
     * @param myList the linked list
     */
    void QuickSort(MyList myList){
        if(myList.getHead() == myList.getTail()) return;
        MyList listPre = new MyList();
        MyList listAft = new MyList();
        //get pivot alone
        Node pivot = myList.getHead();
        myList.setHead(pivot.getNextNode());
        pivot.setNextNode(null);
        Node curr;

        while (myList.getHead() !=null){
            curr = myList.getHead();
            myList.setHead(myList.getHead().getNextNode());
            curr.setNextNode(null);

            if(curr.getData().getID().compareTo(pivot.getData().getID()) <=0) {
                addHead(listPre,curr);
            }
            else addHead(listAft,curr);
        }
        QuickSort(listPre);
        QuickSort(listAft);

        if(listPre.getHead() !=null){
            myList.setHead(listPre.getHead());
            listPre.getTail().setNextNode(pivot);
        }
        else myList.setHead(pivot);

        pivot.setNextNode(listAft.getHead());

        if(listAft.getHead() !=null){
            myList.setTail(listAft.getTail());
        }
        else myList.setTail(pivot);

    }

    /**
     * Convert qty from decimal to binary
     * @param qty an int number
     */
    public void convertToBinary(int qty) {
        if(qty==0) return;
        int out = qty%2;
        convertToBinary(qty/2);
        PrintOut(""+out);
    }

    /**
     * Write a String s to a filename file
     * @param filename a String name of file
     * @param s a String
     */
    public void writeStringToFile(String filename, String s) {
        try {

            FileWriter fw = new FileWriter(filename,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(s);
            bw.close();
            fw.close();

        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Write a String s to a filename file with newline
     * @param filename a String name of file
     * @param s a String
     */
    public void writeStringLnToFile(String filename, String s) {
        try {

            FileWriter fw = new FileWriter(filename,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(s);
            bw.newLine();
            bw.close();
            fw.close();

        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Print out String s to console
     * Write a String s to console_output.txt file
     * @param s a String
     */
    public void PrintOut(String s){
        System.out.print(s);
        writeStringToFile("console_output.txt",s);
    }
    /**
     * Print out String s to console with newline
     * Write a String s to console_output.txt
     * @param s a String
     */
    public void PrintOutLn(String s){
        System.out.println(s);
        writeStringLnToFile("console_output.txt",s);
    }

    /**
     * Show information menu on console
     */
    public void showMenu(){
        PrintOutLn("Product list:");

        PrintOutLn("1. Load data from file and display");

        PrintOutLn("2. Input & add to the end.");

        PrintOutLn("3. Display data");

        PrintOutLn("4. Save product list to file.");

        PrintOutLn("5. Search by ID");

        PrintOutLn("6. Delete by ID");

        PrintOutLn("7. Sort by ID.");

        PrintOutLn("8. Convert to Binary");

        PrintOutLn("9. Load to stack and display");

        PrintOutLn("10. Load to queue and display.");

        PrintOutLn("0. Exit\n");
    }

    /**
     * Get a String from keyboard input by user
     * Write that String to console_output.txt
     * @return a String
     */
    public String ScannerString(){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        writeStringLnToFile("console_output.txt",s);
        return s;
    }

    /**
     * Get an int from keyboard input by user
     * Write that int s to console_output.txt
     * @return an int
     */
    public int ScannerInt(){
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        writeStringLnToFile("console_output.txt",""+s);
        return s;
    }

    /**
     * Get a double from keyboard input by user
     * Write that double s to console_output.txt
     * @return a double
     */
    public double ScannerDouble(){
        Scanner sc = new Scanner(System.in);
        double s = sc.nextDouble();
        writeStringLnToFile("console_output.txt",""+s);
        return s;
    }


}
