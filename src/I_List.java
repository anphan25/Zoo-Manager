/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public interface I_List {
    void add();
    void storeToFile(String fName);
    void loadFromFile(String fName);
    void update();
    void delete();
    void search();
    void show();
}
