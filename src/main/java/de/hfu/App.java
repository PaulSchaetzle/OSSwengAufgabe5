package de.hfu;
import java.io.*;

/**
 * Class to convert given string to upper case
 *
 */
public class App 
{
    public static void main( String[] args )
    {
	BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
	String line = null;
        try {
            line = buffer.readLine();
	    System.out.println(line.toUpperCase());
        }catch (Exception e){}
	}
}
