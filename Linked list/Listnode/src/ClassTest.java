// Name: Viet Trinh Nguyen
// Class: CS 145 f-f
// Date: 5/7/24
// Purpose: Linked list

public class ClassTest {
    public static void main(String[] args) {
        PhoneBookManager phoneBookManager = new PhoneBookManager();
        phoneBookManager.addEntry("Jayce", "Seatle", "311 Stateside", "360 001");
        phoneBookManager.addEntry("Michael", "Seatle2", "312 Stateside", "360 002");
        phoneBookManager.addEntry("Wukong", "Seatle3", "313 Stateside", "360 003");
        phoneBookManager.addEntry("Rebecca", "Seatle4", "314 Stateside", "360 004");
        phoneBookManager.addEntry("Elizabeth", "Seatle5", "315 Stateside", "360 005");
        phoneBookManager.deleteEntry("Elizabeth");
        phoneBookManager.modify("Wukong", "California", "5050 Cedarside Court", "858 789");
        phoneBookManager.printBook();
             
    }

}
