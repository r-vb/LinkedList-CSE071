import java.util.Scanner;

class Node 
{
    int info;
    Node nxt;

    Node(int info) 
    {
        this.info = info;
        this.nxt = null;
    }
}

class linkedList 
{
    Node head;

    linkedList() 
    {
        this.head = null;
    }

    public void insertNode(int info) 
    {
        Node newNode = new Node(info);
        if (head == null) 
        {
            head = newNode;
        } 
        else 
        {
            Node curr = head;
            while (curr.nxt != null) 
            {
                curr = curr.nxt;
            }
            curr.nxt = newNode;
        }
    }

    public void deleteNode(int key) 
    {
        if (head == null) 
        {
            return;
        }

        if (head.info == key) 
        {
            head = head.nxt;
            return;
        }

        Node curr = head;
        Node prev = null;
        while (curr != null && curr.info != key) 
        {
            prev = curr;
            curr = curr.nxt;
        }

        if (curr == null) 
        {
            return;
        }

        prev.nxt = curr.nxt;
    }

    public Node searching(int key) 
    {
        Node curr = head;
        int countNode = 0;
        while (curr != null) 
        {
        	countNode++;
            if (curr.info == key) 
            {
            	System.out.println("Position: " + countNode +".");
                return curr;
            }
            curr = curr.nxt;
        }
        return null;
    }

    public void swapping(int element1, int element2) 
    {
        if (element1 == element2) 
        {
            return;
        }

        Node prev1 = null, curr1 = head;
        while (curr1 != null && curr1.info != element1) 
        {
            prev1 = curr1;
            curr1 = curr1.nxt;
        }

        Node prev2 = null, curr2 = head;
        while (curr2 != null && curr2.info != element2) 
        {
            prev2 = curr2;
            curr2 = curr2.nxt;
        }

        if (curr1 == null || curr2 == null) 
        {
            return;
        }

        if (prev1 != null) 
        {
            prev1.nxt = curr2;
        } 
        else 
        {
            head = curr2;
        }

        if (prev2 != null) 
        {
            prev2.nxt = curr1;
        } 
        else 
        {
            head = curr1;
        }

        Node temp = curr1.nxt;
        curr1.nxt = curr2.nxt;
        curr2.nxt = temp;
    }

    public void display() 
    {
        Node curr = head;
        while (curr != null) 
        {
            System.out.print(curr.info + " ");
            curr = curr.nxt;
        }
        System.out.println();
    }
}

class CustomBuilt071 
{
    public static void main(String args[]) 
    {
        linkedList ll = new linkedList();
        Scanner scanner = new Scanner(System.in);

        boolean stop = false;
        while (stop != true) 
        {
            System.out.println("--Custom Options for now--");
            System.out.println("1. Insert an ele");
            System.out.println("2. Delete an ele");
            System.out.println("3. Search for an ele");
            System.out.println("4. Swapping two eles");
            System.out.println("5. Sorting in ascending");
            System.out.println("6. Display");
            System.out.println("7. Exit");
            
            System.out.print("Enter your choice [1-7]: ");
            int choice = scanner.nextInt();

            switch(choice) 
            {
                case 1: System.out.print("Enter the element to insert: ");
                    int insertInfo = scanner.nextInt();
                    ll.insertNode(insertInfo);
                    System.out.println("Element inserted successfully.");
                    break;
                case 2: System.out.print("Enter the element to delete: ");
                    int deleteInfo = scanner.nextInt();
                    ll.deleteNode(deleteInfo);
                    System.out.println("Element deleted successfully.");
                    break;
                case 3: System.out.print("Enter the element to search: ");
                    int searchInfo = scanner.nextInt();
                    Node result = ll.searching(searchInfo);
                    if (result != null) 
                    {
                        System.out.println("Ele found.");
                    } 
                    else 
                    {
                        System.out.println("Ele not found.");
                    }
                    break;
                case 4: System.out.print("Enter the first element: ");
                    int element1 = scanner.nextInt();
                    System.out.print("Enter the second element: ");
                    int element2 = scanner.nextInt();
                    ll.swapping(element1, element2);
                    System.out.println("Elements have been swapped.");
                    break;
				case 5: /* long startTime = System.currentTimeMillis(); */ //couldn't use it for smaller data set. 0ms
                	long startTime = System.nanoTime();
                    sorting(ll);
					/* long endTime = System.currentTimeMillis(); */
                    long endTime = System.nanoTime();
                    System.out.println("Sorted in ascending order.");
                    System.out.println("Sorting time taken: " + (endTime - startTime) + " ns.");
                    break;
                case 6: System.out.println("Linked List:");
                    ll.display();
                    break;
                case 7: stop = true;
                    break;
                default: System.out.println("Invalid choice.");
            }
            System.out.println();
        }
        scanner.close();
    }

    public static void sorting(linkedList ll) 
    {
        if (ll.head == null || ll.head.nxt == null) 
        {
            return;
        }

        int len = llcomputelen(ll);

        for (int i = 0; i < len - 1; i++) 
        {
            Node curr = ll.head;
            Node nxt = ll.head.nxt;

            for (int j = 0; j < len - 1 - i; j++) 
            {
                if (curr.info > nxt.info) 
                {
                    int temp = curr.info;
                    curr.info = nxt.info;
                    nxt.info = temp;
                }

                curr = curr.nxt;
                nxt = nxt.nxt;
            }
        }
    }

    public static int llcomputelen(linkedList ll) 
    {
        int len = 0;
        Node curr = ll.head;
        while (curr != null) 
        {
            len++;
            curr = curr.nxt;
        }
        return len;
    }
}