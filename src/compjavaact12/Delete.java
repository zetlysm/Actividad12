package compjavaact12;

import java.io.*;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author hgarz
 */
public class Delete {
	public static void choose_field() throws FileNotFoundException, IOException {
		name_search();
	}
	
	public static void name_search() throws IOException, FileNotFoundException{
		Scanner input= new Scanner(System.in);
		String f1;
		System.out.println("Give Name: ");
		f1 = input.nextLine();
		File file = new File(System.getProperty("user.dir")+"/src/contacts.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String currentLine;
		boolean first = false;
		String[] fields = new String[0];
		List<String> lines = new ArrayList<String>();
		while((currentLine = reader.readLine()) !=null) {
			if(!first) {
				fields = currentLine.split(",");
				first = true;
			}
			else {
				String[] info=currentLine.split(",");
				if(info[0].equals(f1)) {
					System.out.println("----There is a contact for the information you gave----");
					for (int i = 0; i < fields.length; i++ ) {
						System.out.println(fields[i] +": "+ info[i]);					
					}
					lines.add(currentLine);
				}
				else if(info[0].equals(f1)) {
					System.out.println("----There is a contact for the Name you gave----");
					for (int i = 0; i < fields.length; i++ ) {
						System.out.println(fields[i] +": "+ info[i]);					
					}
					System.out.println("----Name ans Surname must be valid----");
				}
				else if(!info[0].equals(f1)) {
					System.out.println("----There is a contact for the Surname you gave----");
					for (int i = 0; i < fields.length; i++ ) {
						System.out.println(fields[i] +": "+ info[i]);					
					}
					System.out.println("----Name and Surname must be valid----");
				}
				
			}
		}
		System.out.println("-------------------");
		reader.close();
		for(Object str:lines){
			contact_delete(str.toString());
		} 
		choose_field();
	}
	
	
	
	public static void contact_delete(String line)  throws IOException, FileNotFoundException{
		File file1 = new File(System.getProperty("user.dir")+"/src/contacts.txt");
		BufferedReader reader1 = new BufferedReader(new FileReader(file1));	
		String currentLine1;
		boolean first = false;
		String[] fields = new String[0];
		File file2 = new File(System.getProperty("user.dir")+"/src/contactstemp.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(file2));
		while((currentLine1 = reader1.readLine()) !=null) {
			if(!first) {
				fields = currentLine1.split(",");
				writer.write(currentLine1 + "\n");
				first = true;
			}
			else if(!currentLine1.equals(line)){	
				writer.write(currentLine1 + "\n");
			}
		}
		reader1.close();
		writer.close();
		file1.delete();
		file2.renameTo(file1);
		System.out.println("Information was valid, deletion completed successfully");
	}	
	
	
}
