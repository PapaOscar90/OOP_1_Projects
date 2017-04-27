package nl.rug.oop.introduction;

/* Door object that points to a room number
 * Created by PhilO on 27-Apr-17.
 */
class Door extends Inspectable{
    private int goesTo;

    Door(String desc, int n) {
        super(desc);
        goesTo =n;
    }

    int toRoom(){
        return goesTo;
    }
}
