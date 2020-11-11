package compjavaact12;

import java.util.*;
import java.util.Arrays;
import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

/**
 *
 * @author hgarz
 */
public class Add extends CompJavaAct12{
	public static void add_contact() throws IOException, FileNotFoundException{
		File file1 = new File(System.getProperty("user.dir")+"/src/contacts.txt");
		BufferedReader reader1 = new BufferedReader(new FileReader(file1));
		OutputStreamWriter writer1 = new OutputStreamWriter(
                new FileOutputStream(System.getProperty("user.dir")+"/src/contacts.txt", true), "UTF-8");
		BufferedWriter writer = new BufferedWriter(writer1);
		Scanner input= new Scanner(System.in);
		boolean duplicate, valid;
		String currentLine1;
		String f1 = "";
		int f3 = -1;

		String str;
		System.out.println("Give Name: ");
		f1 = input.nextLine();	
		do {
			duplicate = false;
			valid = true;
			System.out.println("Give Phone: ");
			try {
			    f3 = Integer.parseInt(input.nextLine());
			} catch (NumberFormatException e) {
				valid = false;
				System.out.println("Phone must be number.");
			    e.printStackTrace();
			}
			reader1 = new BufferedReader(new FileReader(file1));
		}while (duplicate == true || valid == false);
		
		if(f1 == "" || f3 == -1 ) {
			System.out.println("You gave false inputs, adding new contact wasn't successful: ");
		}
		else {
			str = f1 + "," + String.valueOf(f3);
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file1, true)));
			out.println(str);
			out.close();
		}
		//input.close();
		//writer1.close();
		writer.close(); 
		reader1.close(); 
	}

}
