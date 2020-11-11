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
public class Print extends CompJavaAct12{
	public static void show_contacts() throws IOException, FileNotFoundException{
		File file = new File(System.getProperty("user.dir")+"/src/contacts.txt");
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getParentFile());
		System.out.println(file.exists());
		file.createNewFile();
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String currentLine;
		boolean first = false;
		String[] fields = new String[0];
		while((currentLine = reader.readLine()) !=null) {
			if(!first) {
				fields = currentLine.split(",");
				first = true;
			}
			else {
				System.out.println("-------------------");
				String[] info=currentLine.split(",");
				for (int i = 0; i < fields.length; i++ ) {
					System.out.println(fields[i] +": "+ info[i]);					
				}
			}
		}
		System.out.println("-------------------");
		reader.close();
	}
}
