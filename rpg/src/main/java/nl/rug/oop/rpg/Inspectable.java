package nl.rug.oop.rpg;

/**
 * An abstract object to super other objects that have instpectable descriptions
 * Contains a description
 * Created by PhilO on 27-Apr-17.
 */
abstract class Inspectable {
    // The description is stored in a string
    private String description;

    public Inspectable(String s) {
        this.description = s;
    }

    // Return the description when inspect is called.
    public String inspect() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
