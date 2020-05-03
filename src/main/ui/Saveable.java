package ui;

import java.io.*;

public interface Saveable {

    //EFFECTS: saves info from list into appropriate text files
    void save() throws IOException;
}
