// Name: Viet Trinh Nguyen
// Class: CS 145 f-f
// Date: 5/7/24
// Purpose: Linked list
import java.util.NoSuchElementException;

public class PhoneBookManager {
    private ListNode front; //reference to the first node in the phone book

    // constructor to initialize the phone book with no entries
    public PhoneBookManager(){
        this.front = null;
    }

    // Method to add a new entry to the phone book
    public void addEntry(String Name, String City, String Address, String PhoneNumber){

        ListNode newNode = new ListNode(Name, City,Address, PhoneNumber);

        if(front == null){
            front = newNode;// if the phone book is empty, the new entry becomes front    
            
            
        }else{
            ListNode current = front;
            // if alphabet new < current: add new before current
        
            if (alphabet(newNode.getName().charAt(0)) < alphabet(current.getName().charAt(0))){
                newNode.next = current;
                front = newNode;
            }
            else{
                while (current.next != null) {
                    if (alphabet(newNode.getName().charAt(0)) < alphabet(current.next.getName().charAt(0))){
                        newNode.next = current.next;
                        break;
                    }
                    else{
                        current = current.next;
                    }
                    
                }
                current.next = newNode;
            }
            
            
        }
        
    }

    // Method to delete an entry
    public void deleteEntry(String Name){
        if (front == null){
            throw new NoSuchElementException();
        }
        else{
            // if front = name, set front = null 
            if(front.getName().equals(Name)){
                front = front.next;
            }
            else{
                ListNode current = front;
                while(current.next != null){
                    // if next = name, set the next to the next one 
                    if(current.next.getName().equals(Name)){
                        current.next = current.next.next;// remove the entry by passing it 
                        break;
                    }
                    else{
                        current = current.next;
                    }
                }
            }
        }
    }

    // method modify an entry
    public void modify(String Name, String City, String Address, String PhoneNumber){
        if (front == null){
            System.out.println("Cannot modify");
        }
        else{
            // if front = name, set front = null 
            if(front.getName().equals(Name)){
                front.updateNode(City, Address, PhoneNumber);
            }
            else{
                ListNode current = front;
                while(current.next != null){
                    // if next = name, update next 
                    if(current.next.getName().equals(Name)){
                        current.next.updateNode(City, Address, PhoneNumber);
                        break;
                    }
                    else{
                        current = current.next;
                    }
                }
            }
        }
    }

    //method to print all entries
    public void printBook(){
        ListNode newNode = front;
        while(newNode != null){
            System.out.println(newNode.toString());// print each entry in the phone book
            newNode = newNode.next;
        }
    }
    
    //method to determine the position of a charater
    public int alphabet(char c){
        c = Character.toUpperCase(c);
        int result = -1;
        String alphabet ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i = 0; i < alphabet.length(); i++){
            
            if (alphabet.charAt(i) == c){
                
                result = i;
                break;
            }
        }
        return result;
    }
}
