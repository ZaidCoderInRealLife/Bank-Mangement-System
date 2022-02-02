package com.company;

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        main_frame(); }
    static void main_frame(){
        JFrame frame=new JFrame("Welcome to Bank management system");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setSize(500, 700);
        frame.setAlwaysOnTop(true);
        JLabel label = new JLabel();
        JButton button=new JButton("Enter as manager");
        button.addActionListener(e -> frame.setVisible(false));
        button.addActionListener(e -> manager());
        JButton button1=new JButton("Enter as Client");
        button1.addActionListener(e -> frame.setVisible(false));
        button1.addActionListener(e -> client());
        button.setBounds(190, 60, 150, 50);
        button1.setBounds(190, 120, 150, 50);
        button.setBackground(Color.LIGHT_GRAY);
        button1.setBackground(Color.LIGHT_GRAY);
        label.add(button1);
        label.add(button);
        frame.add(label);
        frame.setVisible(true);
    }
    static void manager(){
        JFrame frame=new JFrame("Searching_histroy");
        JLabel label=new JLabel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setAlwaysOnTop(true);
        frame.setSize(500, 700);
        JTextArea text=new JTextArea();
        JButton button=new JButton("Back");
        button.setBounds(0, 20, 100, 50);
        JScrollPane scroll=new JScrollPane(text,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(50, 120, 300, 300);
        try {
            int integer=1;
            Scanner name_file=new Scanner(new File("Names.txt"));
            Scanner CNIC_file=new Scanner(new File("CNIC.txt"));
            Scanner fathername_file=new Scanner(new File("fathername.txt"));
            Scanner amount_file=new Scanner(new File("Amount.txt"));
            Scanner password_file=new Scanner(new File("Password.txt"));
            String name,password,cnic,fathername,amount;
            while ((name_file.hasNext()) && (password_file.hasNext()) && (fathername_file.hasNext()) && (CNIC_file.hasNext()) && (amount_file.hasNext())) {
                name = name_file.nextLine();
                password = password_file.nextLine();
                amount = amount_file.nextLine();
                cnic = CNIC_file.nextLine();
                fathername = fathername_file.nextLine();
                text.append("Client number = "+integer+"\nName = " + name + "\n");
                text.append("Father name = " + fathername + "\n");
                text.append("CNIC = " + cnic + "\n");
                text.append("Password = " + password + "\n");
                text.append("Current Amount = " + amount + "\n\n\n");
                integer++;
            }
        }
        catch (Exception e){
            System.out.println("Reading ERROR");
        }
        button.setBackground(Color.LIGHT_GRAY);
        button.addActionListener(e ->main_frame());
        button.addActionListener(e -> frame.setVisible(false));
        label.add(button);
        frame.add(scroll);
        frame.add(label);
        frame.setVisible(true);

    }
    static void client(){
        JFrame frame=new JFrame("Welcome to Bank management system");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setSize(500, 700);
        frame.setAlwaysOnTop(true);
        JLabel label = new JLabel();
        JButton button=new JButton("Login In");
        button.addActionListener(e -> frame.setVisible(false));
        button.addActionListener(e -> login());
        JButton button1=new JButton("Create Account");
        button1.addActionListener(e -> frame.setVisible(false));
        button1.addActionListener(e -> creating_account());
        JButton button2=new JButton("Back");
        button2.setBounds(0, 20, 100, 50);

        button.setBounds(190, 60, 150, 50);
        button1.setBounds(190, 120, 150, 50);
        button.setBackground(Color.LIGHT_GRAY);
        button1.setBackground(Color.LIGHT_GRAY);
        button2.setBackground(Color.LIGHT_GRAY);
        button2.addActionListener(e ->main_frame());
        button2.addActionListener(e -> frame.setVisible(false));
        label.add(button2);
        label.add(button1);
        label.add(button);
        frame.add(label);
        frame.setVisible(true);
    }
    static void login(){
        JFrame frame=new JFrame("Entering name");
        JLabel label = new JLabel();
        JTextField textfield=new JTextField();
        textfield.setBounds(50, 50, 200, 50);
        JLabel label1 = new JLabel("Enter Client name");
        JButton button=new JButton("Next");
        button.addActionListener(e -> frame.setVisible(false));
        button.addActionListener(e ->Searching(textfield.getText()));
        label1.setBounds(0, 0, 200, 50);
        button.setBounds(100, 110, 100, 40);
        button.setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setSize(400, 200);
        frame.setAlwaysOnTop(true);
        label.add(textfield);
        label.add(button);
        label.add(label1);
        frame.add(label);
        frame.setVisible(true);
    }
    static void Searching(String Name){
        int found=0;
        try {
            Scanner name_file=new Scanner(new File("Names.txt"));
            String name;
            while(name_file.hasNext()){
                name=name_file.nextLine();
                if((name.compareTo(Name))==0){
                    found=1;
                }
            }
        }
        catch (Exception e){
            System.out.println("Reading Error");
        }
        if(found==1){
            login_found(Name);
        }
        else{
            Invalid();
        }
    }
    static void login_found(String name){
        JFrame frame=new JFrame("Entering Password");
        JLabel label = new JLabel();
        JTextField textfield=new JTextField();
        textfield.setBounds(50, 50, 200, 50);
        JLabel label1 = new JLabel("Enter Client Password");
        JButton button=new JButton("Next");
        button.addActionListener(e -> frame.setVisible(false));
        button.addActionListener(e ->Checking_password(name,textfield.getText()));
        label1.setBounds(0, 0, 200, 50);
        button.setBounds(100, 110, 100, 40);
        button.setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setSize(400, 200);
        frame.setAlwaysOnTop(true);
        label.add(textfield);
        label.add(button);
        label.add(label1);
        frame.add(label);
        frame.setVisible(true);
    }
    static void Checking_password(String Name,String Password){
        int found=0;
        try {
            Scanner name_file=new Scanner(new File("Names.txt"));
            Scanner passowrd_file=new Scanner(new File("Password.txt"));
            String name,password;
            while(name_file.hasNext() && passowrd_file.hasNext()){
                name=name_file.nextLine();
                password=passowrd_file.nextLine();
                if(( (Password.compareTo(password))==0 ) && ( (name.compareTo(Name))==0 )){
                    found=1;
                }
            }
        }
        catch (Exception e){
            System.out.println("Reading Error");
        }
        if(found==1){
            entering_client_account(Name);
        }
        else{
            Invalid();
        }
    }
    static void entering_client_account(String Name){
        JFrame frame=new JFrame("Welcome to Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setSize(500, 700);
        frame.setAlwaysOnTop(true);
        JLabel label = new JLabel();
        JButton button=new JButton("Add amount to Current amount");
        button.addActionListener(e -> frame.setVisible(false));
        button.addActionListener(e -> ENTERING_AMOUNT(Name));
        JButton button1=new JButton("Change password");
        button1.addActionListener(e -> frame.setVisible(false));
        button1.addActionListener(e -> ENTERING_PASSWORD(Name));
        JButton button2=new JButton("Check Client Information");
        button2.addActionListener(e -> frame.setVisible(false));
        button2.addActionListener(e -> Checking_info(Name));
        JButton button3=new JButton("Withdraw money");
        button3.addActionListener(e -> Entering_Withdrawing_amount(Name));
        button3.addActionListener(e -> frame.setVisible(false));
        button.setBounds(190, 60, 250, 50);
        button1.setBounds(190, 120, 150, 50);
        button2.setBounds(190, 180, 200, 50);
        button3.setBounds(190, 240, 200, 50);
        button3.setBackground(Color.LIGHT_GRAY);
        button.setBackground(Color.LIGHT_GRAY);
        button1.setBackground(Color.LIGHT_GRAY);
        button2.setBackground(Color.LIGHT_GRAY);
        label.add(button2);
        label.add(button3);
        label.add(button1);
        label.add(button);
        frame.add(label);
        frame.setVisible(true);
    }
    static void Entering_Withdrawing_amount(String Name){
        JFrame frame=new JFrame("Entering Amount");
        JLabel label = new JLabel();
        JTextField textfield=new JTextField();
        textfield.setBounds(50, 50, 200, 50);
        JLabel label1 = new JLabel("Enter Client Amount");
        JButton button=new JButton("Next");
        button.addActionListener(e ->Checking_amount(Name,textfield.getText()));
        button.addActionListener(e -> frame.setVisible(false));
        label1.setBounds(0, 0, 200, 50);
        button.setBounds(100, 110, 100, 40);
        button.setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setSize(400, 200);
        frame.setAlwaysOnTop(true);
        label.add(textfield);
        label.add(button);
        label.add(label1);
        frame.add(label);
        frame.setVisible(true);
    }
    static void Checking_amount(String Name,String Amount){
        try {
            Scanner name_file=new Scanner(new File("Names.txt"));
            Scanner amount_file=new Scanner(new File("Amount.txt"));
            String name,amount;
            int found=0;
            while (name_file.hasNext() && amount_file.hasNext()) {
                name = name_file.nextLine();
                amount = amount_file.nextLine();
                int Amount1=Integer.parseInt(Amount);
                int amount1=Integer.parseInt(amount);
                if(((Name.compareTo(name))==0) && (Amount1<=amount1)){
                    found=1;
                    break;
                }
            }
            if(found==1){
                withdrawing_amount(Name, Amount);
            }
            else{
                Invalid();
            }
        }
        catch (Exception e){
            System.out.println("Reading ERROR");
        }
    }
    static void withdrawing_amount(String Name,String Amount){
        try {
            String[] AMOUNTS=new String[50];
            int i=0;
            Scanner name_file=new Scanner(new File("Names.txt"));
            Scanner amount_file=new Scanner(new File("Amount.txt"));
            String name,amount;
            while (name_file.hasNext() && amount_file.hasNext()){
                name=name_file.nextLine();
                amount=amount_file.nextLine();
                if((name.compareTo(Name))==0){
                    int amount1=Integer.parseInt(amount);
                    int amount2=Integer.parseInt(Amount);
                    int sum=amount1-amount2;
                    AMOUNTS[i]=String.valueOf(sum);
                }
                else{
                    AMOUNTS[i]=amount;
                }
                i++;
            }
            FileWriter fw=new FileWriter("Amount.txt");
            fw.close();
            int integer=0;
            while(integer<i){
                FileWriter writer=new FileWriter("Amount.txt",true);
                writer.write(AMOUNTS[integer]+"\n");
                writer.close();
                integer++;
            }
            Finised();
        }
        catch (Exception e){
            System.out.println();
        }


    }
    static void Checking_info(String Name){
        JFrame frame=new JFrame("Searching_histroy");
        JLabel label=new JLabel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setAlwaysOnTop(true);
        frame.setSize(500, 700);
        JTextArea text=new JTextArea();
        JButton button=new JButton("Back");
        button.setBounds(0, 20, 100, 50);
        JScrollPane scroll=new JScrollPane(text,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(50, 120, 300, 300);
        try {
            Scanner name_file=new Scanner(new File("Names.txt"));
            Scanner CNIC_file=new Scanner(new File("CNIC.txt"));
            Scanner fathername_file=new Scanner(new File("fathername.txt"));
            Scanner amount_file=new Scanner(new File("Amount.txt"));
            Scanner password_file=new Scanner(new File("Password.txt"));
            String name,password,cnic,fathername,amount;
            while ((name_file.hasNext()) && (password_file.hasNext()) && (fathername_file.hasNext()) && (CNIC_file.hasNext()) && (amount_file.hasNext())) {
                name = name_file.nextLine();
                password = password_file.nextLine();
                amount = amount_file.nextLine();
                cnic = CNIC_file.nextLine();
                fathername = fathername_file.nextLine();
                if ((Name.compareTo(name)) == 0) {
                    text.append("Name = " + name + "\n");
                    text.append("Father name = " + fathername + "\n");
                    text.append("CNIC = " + cnic + "\n");
                    text.append("Password = " + password + "\n");
                    text.append("Current Amount = " + amount + "\n");
                    break;
                }
            }
        }
        catch (Exception e){
            System.out.println("Reading ERROR");
        }
        button.setBackground(Color.LIGHT_GRAY);
        button.addActionListener(e ->main_frame());
        button.addActionListener(e -> frame.setVisible(false));
        label.add(button);
        frame.add(scroll);
        frame.add(label);
        frame.setVisible(true);
    }
    static void ENTERING_PASSWORD(String Name){
        JFrame frame=new JFrame("Entering Password");
        JLabel label = new JLabel();
        JTextField textfield=new JTextField();
        textfield.setBounds(50, 50, 200, 50);
        JLabel label1 = new JLabel("Enter Client Password");
        JButton button=new JButton("Next");
        button.addActionListener(e ->Changing_password(Name,textfield.getText()));
        button.addActionListener(e -> frame.setVisible(false));
        label1.setBounds(0, 0, 200, 50);
        button.setBounds(100, 110, 100, 40);
        button.setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setSize(400, 200);
        frame.setAlwaysOnTop(true);
        label.add(textfield);
        label.add(button);
        label.add(label1);
        frame.add(label);
        frame.setVisible(true);
    }
    static void Changing_password(String Name,String Password){
        try {
            String[] PASSWORDS=new String[50];
            int i=0;
            Scanner name_file=new Scanner(new File("Names.txt"));
            Scanner password_file=new Scanner(new File("Password.txt"));
            String name,password;
            while (name_file.hasNext() && password_file.hasNext()){
                name=name_file.nextLine();
                password=password_file.nextLine();
                if((name.compareTo(Name))==0){
                    PASSWORDS[i]=Password;
                }
                else{
                    PASSWORDS[i]=password;
                }
                i++;
            }
            FileWriter fw=new FileWriter("Password.txt");
            fw.close();
            int integer=0;
            while(integer<i){
                FileWriter writer=new FileWriter("Password.txt",true);
                writer.write(PASSWORDS[integer]+"\n");
                writer.close();
                integer++;
            }
            Finised();
        }
        catch (Exception e){
            System.out.println();
        }

    }
    static void ENTERING_AMOUNT(String Name){
        JFrame frame=new JFrame("Entering Amount");
        JLabel label = new JLabel();
        JTextField textfield=new JTextField();
        textfield.setBounds(50, 50, 200, 50);
        JLabel label1 = new JLabel("Enter Client Amount");
        JButton button=new JButton("Next");
        button.addActionListener(e ->Adding_amount(Name,textfield.getText()));
        button.addActionListener(e -> frame.setVisible(false));
        label1.setBounds(0, 0, 200, 50);
        button.setBounds(100, 110, 100, 40);
        button.setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setSize(400, 200);
        frame.setAlwaysOnTop(true);
        label.add(textfield);
        label.add(button);
        label.add(label1);
        frame.add(label);
        frame.setVisible(true);
    }
    static void Adding_amount(String Name,String Amount){
        try {
            String[] AMOUNTS=new String[50];
            int i=0;
            Scanner name_file=new Scanner(new File("Names.txt"));
            Scanner amount_file=new Scanner(new File("Amount.txt"));
            String name,amount;
            while (name_file.hasNext() && amount_file.hasNext()){
                name=name_file.nextLine();
                amount=amount_file.nextLine();
                if((name.compareTo(Name))==0){
                    int amount1=Integer.parseInt(amount);
                    int amount2=Integer.parseInt(Amount);
                    int sum=amount1+amount2;
                    AMOUNTS[i]=String.valueOf(sum);
                }
                else{
                    AMOUNTS[i]=amount;
                }
                i++;
            }
            FileWriter fw=new FileWriter("Amount.txt");
            fw.close();
            int integer=0;
            while(integer<i){
                FileWriter writer=new FileWriter("Amount.txt",true);
                writer.write(AMOUNTS[integer]+"\n");
                writer.close();
                integer++;
            }
            Finised();
        }
        catch (Exception e){
            System.out.println();
        }
    }

    static void Invalid(){
        JFrame frame=new JFrame("Invalid Entry");
        JLabel label = new JLabel("Invalid Entry");
        label.setBounds(0, 20, 200, 50);
        JButton button=new JButton("Back to main Frame");
        button.addActionListener(e ->main_frame());
        button.addActionListener(e -> frame.setVisible(false));
        button.setBounds(50, 110, 300, 40);
        button.setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setSize(400, 200);
        frame.setAlwaysOnTop(true);
        label.add(button);
        frame.add(label);
        frame.setVisible(true);
    }
    static void creating_account(){
        JFrame frame=new JFrame("Entering name");
        JLabel label = new JLabel();
        JTextField textfield=new JTextField();
        textfield.setBounds(50, 50, 200, 50);
        JLabel label1 = new JLabel("Enter Client name");
        JButton button=new JButton("Next");
        button.addActionListener(e ->saving_name(textfield.getText()));
        button.addActionListener(e -> frame.setVisible(false));
        button.addActionListener(e ->Entering_CNIC());
        label1.setBounds(0, 0, 200, 50);
        button.setBounds(100, 110, 100, 40);
        button.setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setSize(400, 200);
        frame.setAlwaysOnTop(true);
        label.add(textfield);
        label.add(button);
        label.add(label1);
        frame.add(label);
        frame.setVisible(true);
    }
    static void saving_name(String name){
        try{
            FileWriter writer=new FileWriter("Names.txt",true);
            writer.write(name+"\n");
            writer.close();
        }
        catch(Exception e){
            System.out.println("Saving ERROR");
        }
    }
    static void Entering_CNIC(){
        JFrame frame=new JFrame("Entering CNIC");
        JLabel label = new JLabel();
        JTextField textfield=new JTextField();
        textfield.setBounds(50, 50, 200, 50);
        JLabel label1 = new JLabel("Enter Client CNIC");
        JButton button=new JButton("Next");
        button.addActionListener(e ->saving_CNIC(textfield.getText()));
        button.addActionListener(e -> frame.setVisible(false));
        button.addActionListener(e ->Entering_fathername());
        label1.setBounds(0, 0, 200, 50);
        button.setBounds(100, 110, 100, 40);
        button.setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setSize(400, 200);
        frame.setAlwaysOnTop(true);
        label.add(textfield);
        label.add(button);
        label.add(label1);
        frame.add(label);
        frame.setVisible(true);
    }
    static void saving_CNIC(String CNIC){
        try{
            FileWriter writer=new FileWriter("CNIC.txt",true);
            writer.write(CNIC+"\n");
            writer.close();
        }
        catch(Exception e){
            System.out.println("Saving ERROR");
        }
    }
    static void Entering_fathername(){
        JFrame frame=new JFrame("Entering Father name");
        JLabel label = new JLabel();
        JTextField textfield=new JTextField();
        textfield.setBounds(50, 50, 200, 50);
        JLabel label1 = new JLabel("Enter Client Father name");
        JButton button=new JButton("Next");
        button.addActionListener(e ->saving_fathername(textfield.getText()));
        button.addActionListener(e -> frame.setVisible(false));
        button.addActionListener(e ->Entering_amount());
        label1.setBounds(0, 0, 200, 50);
        button.setBounds(100, 110, 100, 40);
        button.setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setSize(400, 200);
        frame.setAlwaysOnTop(true);
        label.add(textfield);
        label.add(button);
        label.add(label1);
        frame.add(label);
        frame.setVisible(true);
    }
    static void saving_fathername(String fathername){
        try{
            FileWriter writer=new FileWriter("fathername.txt",true);
            writer.write(fathername+"\n");
            writer.close();
        }
        catch(Exception e){
            System.out.println("Saving ERROR");
        }
    }
    static void Entering_amount(){
        JFrame frame=new JFrame("Entering Amount");
        JLabel label = new JLabel();
        JTextField textfield=new JTextField();
        textfield.setBounds(50, 50, 200, 50);
        JLabel label1 = new JLabel("Enter Client Amount");
        JButton button=new JButton("Next");
        button.addActionListener(e ->saving_amount(textfield.getText()));
        button.addActionListener(e -> frame.setVisible(false));
        button.addActionListener(e ->Entering_password());
        label1.setBounds(0, 0, 200, 50);
        button.setBounds(100, 110, 100, 40);
        button.setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setSize(400, 200);
        frame.setAlwaysOnTop(true);
        label.add(textfield);
        label.add(button);
        label.add(label1);
        frame.add(label);
        frame.setVisible(true);
    }
    static void saving_amount(String address){
        try{
            FileWriter writer=new FileWriter("Amount.txt",true);
            writer.write(address+"\n");
            writer.close();
        }
        catch(Exception e){
            System.out.println("Saving ERROR");
        }
    }
    static void Entering_password(){
        JFrame frame=new JFrame("Entering Password");
        JLabel label = new JLabel();
        JTextField textfield=new JTextField();
        textfield.setBounds(50, 50, 200, 50);
        JLabel label1 = new JLabel("Enter Client Password");
        JButton button=new JButton("Next");
        button.addActionListener(e ->saving_password(textfield.getText()));
        button.addActionListener(e -> frame.setVisible(false));
        button.addActionListener(e ->Finised());
        label1.setBounds(0, 0, 200, 50);
        button.setBounds(100, 110, 100, 40);
        button.setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setSize(400, 200);
        frame.setAlwaysOnTop(true);
        label.add(textfield);
        label.add(button);
        label.add(label1);
        frame.add(label);
        frame.setVisible(true);
    }
    static void saving_password(String address){
        try{
            FileWriter writer=new FileWriter("Password.txt",true);
            writer.write(address+"\n");
            writer.close();
        }
        catch(Exception e){
            System.out.println("Saving ERROR");
        }
    }
    static void Finised(){
        JFrame frame=new JFrame("Information Successfully added");
        JLabel label = new JLabel("Information Successfully added");
        label.setBounds(0, 20, 200, 50);
        JButton button=new JButton("Back to main Frame");
        button.addActionListener(e ->main_frame());
        button.addActionListener(e -> frame.setVisible(false));
        button.setBounds(50, 110, 300, 40);
        button.setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setSize(400, 200);
        frame.setAlwaysOnTop(true);
        label.add(button);
        frame.add(label);
        frame.setVisible(true);
    }
}
