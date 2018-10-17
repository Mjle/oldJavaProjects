package com.fdmgroup.exfileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;


public class FileIO {
	
	public int countE(String file, char check) {
	int counter = 0;
		try {
			 FileReader fileReader = 
		               new FileReader(file);
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            int r;
            while ((r = bufferedReader.read()) != -1) {
	            if (r == (int) check) {
	            	counter++;
	            }
            }
            bufferedReader.close(); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(counter);
		return counter;
	}
	
	public void writeUserToFile(String file) {
		Scanner s = new Scanner(System.in);
		FileWriter fileWriter;
		BufferedWriter bufferedWriter;
		try {
			fileWriter = new FileWriter(file, true);
			bufferedWriter = new BufferedWriter(fileWriter);
			do {
				System.out.println("Please enter a name: ");
				String name = s.nextLine();
				bufferedWriter.write(name + ", ");
				System.out.println("Please enter a address: ");
				String addr = s.nextLine();
				bufferedWriter.write(addr + ", ");
				System.out.println("Please enter a email: ");
				String email = s.nextLine();
				bufferedWriter.write(email + "\n");
				System.out.println("Add more users? Or type 'exit'");
			} while(!s.nextLine().equals("exit"));
			
			s.close();
			bufferedWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void readUserToObject(String file) {
        ArrayList<String[]> users = new ArrayList<String[]>();
		try {
			 FileReader fileReader = 
		               new FileReader(file);
           BufferedReader bufferedReader = 
               new BufferedReader(fileReader);
           String infos;
           while ((infos = bufferedReader.readLine()) != null) {
        	   String[] info;
        	   info = infos.split(", ");
        	   users.add(info);
           }
           bufferedReader.close(); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(users);
		for (String[] user : users) {
			for (String in : user) {
				System.out.println(in);
			}
			System.out.println("User!");
		}
	}
}
