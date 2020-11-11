/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compjavaact12;

import java.util.Arrays;
import java.util.Scanner;

import compjavaact12.Print;
import compjavaact12.Add;
import compjavaact12.Delete;

import java.io.*;
import java.net.*;
import java.util.*;
import java.nio.charset.Charset;

/**
 *
 * @author hgarz
 */
public class CompJavaAct12 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int exit = 0;
        int answer;
        do {
            System.out.println("--------Welcome to Address Book---------");
            System.out.println("Enter '1' to Add contact");
            System.out.println("Enter '2' to Print contact");
            System.out.println("Enter '3' to Delete contact");
            System.out.println("Enter '0' to Exit");
            try {
                answer = input.nextInt();
            } catch (NumberFormatException e) {
                e.printStackTrace();
                answer = -1;
            }
            if (answer == 1)//according to user's input we go to each class
            {
                Add.add_contact();
            } else if (answer == 2) {
                Print.show_contacts();
            } else if (answer == 3) {
                Delete.choose_field();
            }

        } while (answer != exit);
        System.out.println("Exiting.");
    }
}
