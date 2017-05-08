package nl.rug.oop.rpg.Dungeon;

/** An abstract class for a special door
 * Created by saidf on 5/2/2017.
 */
public abstract class SpecialDoor extends Door{
    protected boolean wentThrough;
    protected boolean usageNoticeReceived;
    protected boolean leadsBack;
    protected Room roomInfrontDoor;

    public SpecialDoor(String s){
        super(s);
        wentThrough = false;
        usageNoticeReceived = false;
        leadsBack = false;
    }

    public boolean isLeadsBack() {
        return leadsBack;
    }

    public void setLeadsBack(boolean leadsBack) {
        this.leadsBack = leadsBack;
    }
}
