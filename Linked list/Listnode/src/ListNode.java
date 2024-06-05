// Name: Viet Trinh Nguyen
// Class: CS 145 f-f
// Date: 5/7/24
// Purpose: Linked list
public class ListNode {

//declare variables 
  String Name;
  String City;
  String Address;
  String PhoneNumber;
  ListNode next; 

//constructor to initialize the listNode 
public ListNode( String Name, String City, String Address, String PhoneNumber){
    this.Name = Name;
    this.City = City;
    this.Address = Address;
    this.PhoneNumber = PhoneNumber;
    this.next = null; 
}

// update info of the current node
public void updateNode(String City, String Address, String PhoneNumber){
    this.City = City;
    this.Address = Address;
    this.PhoneNumber = PhoneNumber;
}

//Getter method to retrieve the name of the person stored in this note
public String getName(){
  return Name;
}

//display information
@Override
public String toString() {
    return "ListNode{name = " + Name + ", address='" + Address + ", city='" + City + ", phoneNumber='" + PhoneNumber +'}';
}
 
}
