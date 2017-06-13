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

public class GraphEditor{
    public static void main(String[] args){
        System.out.println("Hello world.");
        GraphModel model = new GraphModel();
        model.loadFromFile("testFile.txt");
        GraphFrame frame = new GraphFrame(model);
    }
}

