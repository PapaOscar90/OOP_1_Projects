package nl.rug.oop.rpg;

/**An abstract object to super other objects
 * Contains a description
 * Created by PhilO on 27-Apr-17.
 */
abstract class Inspectable {
    private String description;

    public void Inspectable(String s){
        description = s;
    }
}
