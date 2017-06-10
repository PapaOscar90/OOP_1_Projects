package graphEditor.utility;

import graphEditor.interfaces.Persistent;
import sun.rmi.transport.ObjectTable;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Vector;

/**
 * Created by PhilO on 10-Jun-17.
 */
public class PersistentOutputStream extends PrintStream {
    private ObjectTable objectTable;

    private void setTable(ObjectTable ot){objectTable = ot;}

    public PersistentOutputStream(OutputStream out) {super(out);}

    public void writeObjectsStart () {print ("Objects[\n") ;
    }
    /** write a end-tag for object-data
     */
    public void writeObjectsEnd  () {print("]\n") ;
    }
    /** write an object, use the persistent-interface method write
     for reading the object's data */
    public void writeObject (Persistent x) {
        print(((Object)x).getClass().getName());
        print("[\n");
        x.write(this);
        print("]\n");
    }

}
