package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import model.entity.LogEntry;

public class Program {

	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter file full path: ");
		String path = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader (new FileReader(path))){
			
			Set<LogEntry> set = new HashSet<>();

			String line = br.readLine();//read first line 
			while(line != null) {
				String[] fields = line.split(" ");
				String username = fields[0];// getname
				Date moment = Date.from(Instant.parse(fields[1]));//get Date
				
				set.add(new LogEntry(username, moment));
				
				line = br.readLine();
			}
			System.out.println("Total users: " + set.size() );
			
		}catch (IOException e) {
			System.out.println("Error: " + e.getMessage() );
		}
		sc.close();
	}
}
