
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
public class Animal  {
   
    String attribute;
    double weight;
    String name;
    String ID;
    int type;
    
    Scanner sc=new Scanner(System.in);

    Animal(String id, String name, int type, String attribute, double weight) {
        this.ID=id;
        this.name=name;
        this.type=type;
        this.attribute=attribute;
        this.weight=weight;
    }

    Animal() {
         //To change body of generated methods, choose Tools | Templates.
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }
 
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    public void input(){
        
        System.out.print("Inut ID: ");
        this.ID=sc.nextLine();
        System.out.print("Input name: ");
        this.name=sc.nextLine();
        System.out.print("Input type: ");
        this.type=Integer.parseInt(sc.nextLine());
        System.out.print("Input attribute: ");
        this.attribute=sc.nextLine();
        System.out.print("Input weight: ");
        this.weight=Double.parseDouble(sc.nextLine());
    }
    @Override
    public String toString(){
        return ID+" | "+name+" | "+type+" | "+attribute+" | "+weight;
    }
}
