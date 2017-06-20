/*
    GraphEditor
    v0.1
    Phil Oetinger - s2966018
    Said Faroghi  - s3000966
 */

package graphEditor;

import graphEditor.controller.SelectionController;
import graphEditor.model.GraphModel;
import graphEditor.view.GraphFrame;

import javax.swing.*;

public class GraphEditor {
    public static void main(String[] args) {
        String fileName;
        GraphModel model = new GraphModel();
        if (args.length > 0) {
            fileName = args[0];
            model.loadFromFile(fileName);
        }else{
            model.loadFromFile("persistent.txt");
        }
        GraphFrame frame = new GraphFrame(model);
    }
}

