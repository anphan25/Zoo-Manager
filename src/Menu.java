
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class Menu implements I_Menu{
    ArrayList<String> ds=new ArrayList();
    Scanner sc=new Scanner(System.in);

    public Menu() {
    }
    
    @Override
    public void addItem(String s) {
        ds.add(s);
    }

    @Override
    public int getChoice() {
        int choice=0;
        System.out.println("-----Animals Manager-----");
        for(int i=0;i<ds.size();i++){
            System.out.println((i+1)+"- "+ds.get(i));
        }
        System.out.print("Input your choice: ");
        choice=Integer.parseInt(sc.nextLine());
    	return choice;
    }
    
}
