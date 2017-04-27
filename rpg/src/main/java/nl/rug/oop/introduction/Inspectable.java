package nl.rug.oop.introduction;

/**Abstract Inspectable object for anything that can be inspected in the world
 * Created by PhilO on 27-Apr-17.
 */

public class Inspectable {
    // The description of the object being inspected.
    protected String description;

    // Constructor
    public Inspectable(String desc){
        description=desc;
    }

    // Returns string of object's description
    public String inspect(int selection){
        switch(selection) {
            case 0:
                System.out.print("You see: "+description);
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }
        return description;
    }

}
