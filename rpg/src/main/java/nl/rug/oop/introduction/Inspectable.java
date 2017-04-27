package nl.rug.oop.introduction;

/**Abstract Inspectable object for anything that can be inspected in the world
 * Created by PhilO on 27-Apr-17.
 */

abstract class Inspectable {
    // The description of the object being inspected.
    private String description;

    // Constructor
    Inspectable(String desc) {
        description=desc;
    }

    String  inspect(){
        return description;
    }
}
