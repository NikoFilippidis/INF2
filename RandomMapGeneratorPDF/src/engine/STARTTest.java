package engine;

import static org.junit.Assert.*;

import java.awt.SplashScreen;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class STARTTest {
	int i = 0;
	String line;
	int counter=0;
	String vergl;
	
	@Test
	public void test() {
		 FileReader in = null;
		try {
			in = new FileReader("randomMap.map");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		    BufferedReader br = new BufferedReader(in);
		    
		    try {
				while (br.readLine() != null) {
					line = br.readLine();
					counter++;
						if (counter>4) {
						String[] splitResult = line.split(";");
						
						System.out.println(splitResult[2]);
						
						}
					}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	   
	}


	

	
}
