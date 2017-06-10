package graphEditor.interfaces;

import graphEditor.utility.PersistentInputStream;
import graphEditor.utility.PersistentOutputStream;
import sun.rmi.transport.ObjectTable;

import java.io.IOException;

/**
 * Created by PhilO on 10-Jun-17.
 */
public interface Persistent {
    public void registerConnectionsInTable(ObjectTable ot);
    public void write(PersistentOutputStream os);
    public void read(PersistentInputStream is) throws IOException;

}
