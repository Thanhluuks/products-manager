/*
** Product manage program with menu
* 1. Load data from file and display
* 2. Input & add to the end.
* 3. Display data
* 4. Save product list to file.
* 5. Search by ID
* 6. Delete by ID
* 7. Sort by ID.
* 8. Convert to Binary
* 9. Load to stack and display
* 10. Load to queue and display.
 */

public class Main {
    public static void main(String[] args){
        int choice;
        MyList myList = new MyList();
        MyStack myStack = new MyStack();
        MyQueue myQueue = new MyQueue();
        String rowTile = String.format("|  %-20s |  %-20s  |  %-20s  |  %-20s  |","ID","Name","Price","Quantity");
        while (true) {
            myList.PrintOutLn("\nSelect your option, from 0 to 10: ");
            myList.showMenu();
            choice = myList.ScannerInt();
            if(choice == 0) {
                myList.PrintOutLn("Thanks");
                break;
            }
            switch (choice) {
                case 1:
                    myList.PrintOutLn("1. Load data from file and display");
                    myList.getProductsFromFile("data1.txt", myList);
                    myList.PrintOutLn(rowTile);
                    myList.display(myList);
                    break;
                case 2:
                    myList.PrintOutLn("2. Input & add to the end.");
                    myList.addProduct(myList);
                    break;
                case 3:
                    myList.PrintOutLn("3. Display data");
                    myList.PrintOutLn(rowTile);
                    myList.display(myList);
                    break;
                case 4:
                    myList.PrintOutLn("4. Save product list to file.");
                    myList.writeListToFile("data1.txt",myList);
                    break;
                case 5:
                    myList.PrintOutLn("5. Search by ID");
                    myList.displaySearchProduct(myList);
                    break;
                case 6:
                    myList.PrintOutLn("6. Delete by ID");
                    myList.deleteProduct(myList);
                    break;
                case 7:
                    myList.PrintOutLn("7. Sort by ID.");
                    myList.QuickSort(myList);
                    myList.PrintOutLn("Successfully!");
                    break;
                case 8:
                    myList.PrintOutLn("8. Convert to Binary");
                    int qty =myList.getHead().getData().getQty();
                    myList.PrintOutLn("Quantity of the first item is " +qty);
                    myList.convertToBinary(qty);
                    break;
                case 9:
                    myList.PrintOutLn("9. Load to stack and display.");
                    myList.PrintOutLn(rowTile);
                    myStack.getProductsFromFile("data1.txt", myStack);
                    myStack.display(myStack);
                    break;
                case 10:
                    myList.PrintOutLn("10. Load to queue and display.");
                    myList.PrintOutLn(rowTile);
                    myQueue.getProductsFromFile("data1.txt", myQueue);
                    myQueue.display(myQueue);
                    break;
                default:
                    myList.PrintOutLn("Please select again, from 0 to 10.");
                    break;
            }
        }
    }

}
