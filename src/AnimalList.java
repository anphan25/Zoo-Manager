
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ASUS
 */
public class AnimalList extends ArrayList<Animal> implements I_List {

    ArrayList<Animal> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    @Override
    public void add() {
        int mark = 1;
        do {    
            Animal ani = new Animal();
            ani.input();
            if (list.add(ani)) {
                System.out.println("Added Successfully");
            } else {
                System.out.println("Added Failed");
            }
            String ask;
            System.out.print("Do you want to continue add(Y/N): ");
            ask=sc.nextLine();
            
            
            
            if (ask.compareToIgnoreCase("Y") == 0) {
                mark = 1;
            } else {
                mark = 0;
            }
        } while (mark == 1);
    }

    @Override
    public void update() {
        String UpID;
        int mark = 0;
        System.out.print("Input the ID that you want to update: ");
        UpID = sc.nextLine();
        for (Animal o : list) {
            if (o.getID().equalsIgnoreCase(UpID)) {
                mark++;
                o.input();
            }
        }

        if (mark == 0) {
            System.out.println("Animal dose not exist");
        } else {
            System.out.println("Updated successfully");
        }
    }

    @Override
    public void delete() {
        String DelID;
        int mark = 0;
        System.out.print("Input the ID you want to delete: ");
        DelID = sc.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (DelID.equalsIgnoreCase(list.get(i).getID())) {
                list.remove(list.get(i));
                mark++;
            }
        }
        if (mark == 0) {
            System.out.println("The ID is not existed");
        } else {
            System.out.println("Deleted successfully");
        }
    }

    @Override
    public void search() {
        int choice;
        System.out.println("Which one you want to search: ");
        System.out.println("1. Search by Name");
        System.out.println("2. Search by Weight");
        System.out.print("Your choice: ");
        choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1:
                int mark = 0;
                String seekName;
                System.out.print("Input a name you want to search: ");
                seekName = sc.nextLine();
                for (Animal o : list) {
                    if (o.getName().contains(seekName)) {
                        System.out.println(o);
                        mark++;
                    }
                }
                if (mark == 0) {
                    System.out.println("the name is not existed");
                }
                break;
            case 2:
                double lowerWeight;
                double upperWeight;
                int check = 0;
                
                System.out.print("Input the lower bound: ");
                lowerWeight = Double.parseDouble(sc.nextLine());
                System.out.print("Input the upper bound: ");
                upperWeight = Double.parseDouble(sc.nextLine());
                if(lowerWeight>upperWeight){
                    double t=lowerWeight;
                    lowerWeight=upperWeight;
                    upperWeight=t;
                }
                for (Animal o : list) {
                    if (o.getWeight() <= upperWeight && o.getWeight() >= lowerWeight) {
                        System.out.println(o);
                        check++;
                    }
                }
                if (check == 0) {
                    System.out.println("Can not find the qualified animals");
                }
        }
    }

    @Override
    public void show() {
        System.out.println("1. Show by type");
        System.out.println("2. Show all");
        System.out.print("Your choice: ");
        int choice;
        choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1:
                int mark = 0;
                int showType;
                System.out.print("Input the type you want to show: ");
                showType = Integer.parseInt(sc.nextLine());
                for (Animal o : list) {
                    if (o.getType()==showType){
                        System.out.println(o);
                        mark++;
                    }
                }
                if (mark == 0) {
                    System.out.println("The type is not existed");
                }
                break;
            case 2:
                for (Animal o : list) {
                    System.out.println(o);
                }
                break;
        }
    }

    @Override
    public void loadFromFile(String fName) {
        try {
            File f = new File(fName);
            if (!f.exists()) {
                System.out.println("Empty List");
                return;
            }
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String details;
            while ((details = br.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(details, "|");
                String id = stk.nextToken();
                String name = stk.nextToken();
                int type = Integer.parseInt(stk.nextToken());
                String attribute = stk.nextToken();
                double weight = Double.parseDouble(stk.nextToken());
                list.add(new Animal(id, name, type, attribute, weight));
            }
            
            br.close();
            fr.close();
            int num=list.size();
            System.out.println("Loaded: "+num+" animals");
        } catch (Exception e) {
            System.out.println(e);  
        }
    }

    @Override
    public void storeToFile(String fName) {
        if(list.size()==0){
            System.out.println("Empty list");
            return;
        }
        try{
            File f=new File(fName);
            FileWriter fw=new FileWriter(f);
            PrintWriter pw=new PrintWriter(fw);
            for(Animal o:list){
                pw.println(o.getID()+"|"+o.getName()+"|"+o.getType()+"|"+o.getAttribute()+"|"+o.getWeight());
            }
            pw.close();fw.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }

}
