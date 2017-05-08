package nl.rug.oop.rpg.Utility;

import nl.rug.oop.rpg.Player.Player;
import nl.rug.oop.rpg.Utility.HelperClass;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/** Handles game saving and loading
 * Created by saidf on 5/8/2017.
 */
public abstract class SaveFileController {

    // Handles filename selection
    private static String selectFilename(){
        File file = new File(HelperClass.DIRECTORY_NAME);
        System.out.println("Which file ? ( -1 : none )");
        System.out.println();
        List<String> serFileList = new ArrayList<>();
        String[] fileList = file.list();
        if (fileList == null){
            return "";
        }
        for (String fileName : fileList){
            if (fileName.endsWith(HelperClass.SAVEFILE_EXTENSION)){
                serFileList.add(fileName);
            }
        }
        for (int i = 0; i < serFileList.size(); i++){
            System.out.println("(" + i + ") " + serFileList.get(i));
        }
        int choice = HelperClass.pause(-1, serFileList.size() - 1);
        return choice == -1 ? "" : serFileList.get(choice);
    }

    //Loads a saved game state from a file
    private static Player load(String fileName) {
        if (fileName.isEmpty()){
            return null;
        }
        FileInputStream fis;
        ObjectInputStream ois = null;
        Player player = null;
        String filePath = HelperClass.DIRECTORY_NAME + File.separatorChar + fileName;
        File f = new File(filePath);
        if (!f.exists()){
            return null;
        }
        try {
            fis = new FileInputStream(filePath);
            ois = new ObjectInputStream(fis);
            // (Player) casts the object as a player object when it is read
            player = (Player) ois.readObject();
        } catch (FileNotFoundException e) {
            System.err.println("File not found " + e.getMessage());
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Loading...");
        return player;
    }

    //Saves the current game state to a file
    private static void save(Player player, String fileName) {
        FileOutputStream fos;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(HelperClass.DIRECTORY_NAME + File.separatorChar + fileName + HelperClass.SAVEFILE_EXTENSION);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(player);
        } catch (FileNotFoundException e) {
            System.err.println("File not found exception. " + e.getMessage());
            e.printStackTrace();
            System.out.println("File not found. Attempting to create save-folder.\n Please Try again.");
            new File(HelperClass.DIRECTORY_NAME).mkdir();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                System.out.println("Saving...");
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void save(Player player){
        System.out.println("Filename? ");
        String fileName = HelperClass.getValidChoice();
        save(player, fileName);
    }

    public static Player load(){
        String fileName = selectFilename();
        return load(fileName);


    }

    public static Player quickLoad(){
        return load(HelperClass.QUICKSAVE_FILENAME + HelperClass.SAVEFILE_EXTENSION);
    }

    public static void quickSave(Player player){
        save(player, HelperClass.QUICKSAVE_FILENAME);
    }
}
