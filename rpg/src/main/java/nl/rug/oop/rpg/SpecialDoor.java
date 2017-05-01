package nl.rug.oop.rpg;

/**
 * Created by saidf on 5/2/2017.
 */
abstract class SpecialDoor extends Door{
    protected boolean wentThrough;
    protected boolean usageNoticeReceived;

    public SpecialDoor(String s){
        super(s);
        wentThrough = false;
        usageNoticeReceived = false;
    }
}
