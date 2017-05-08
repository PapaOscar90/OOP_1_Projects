package nl.rug.oop.rpg;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/** Handles game saving and loading
 * Created by saidf on 5/8/2017.
 */
public class SaveFileController {

    private static String selectFilename(){
        File file = new File("Savegames");
        System.out.println("Which file ? ( -1 : none )");
        System.out.println();
        List<String> serFileList = new ArrayList<>();
        String[] fileList = file.list();
        if (fileList == null){
            return "";
        }
        for (String fileName : fileList){
            if (fileName.endsWith(".ser")){
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
        String filePath = "Savegames/" + fileName;
        File f = new File(filePath);
        if (!f.exists()){
            return null;
        }
        try {
            fis = new FileInputStream(filePath);
            ois = new ObjectInputStream(fis);
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
            fos = new FileOutputStream("Savegames/" + fileName + ".ser");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(player);
        } catch (FileNotFoundException e) {
            System.err.println("File not found " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Saving...");
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
        return load("Quicksave.ser");
    }

    public static void quickSave(Player player){
        save(player, "Quicksave");
    }
}
