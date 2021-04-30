
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class Run_Animal {
    public static void main(String[] args) {
        Menu menu=new Menu();
        
        String filename="animal.txt";
        menu.addItem("Load data from file");
        menu.addItem("Add new animal");
        menu.addItem("Update animal");
        menu.addItem("Delete animal");
        menu.addItem("Search animal");
        menu.addItem("Show animal list");
        menu.addItem("Store data to file");
        menu.addItem("Quit");
        AnimalList list=new AnimalList();
        int choice;
        do{
            choice=menu.getChoice();
            switch (choice){
                case 1:
                    list.loadFromFile(filename);
                    break;
                case 2:
                    list.add();
                    break;
                case 3:
                    list.update();
                    break;
                case 4:
                    list.delete();
                    break;
                case 5:
                    list.search();
                    break;
                case 6:
                    list.show();
                    break;
                case 7:
                    list.storeToFile(filename);
                    break;
            }
        }while(choice>=1 && choice <=7);
    }
}
