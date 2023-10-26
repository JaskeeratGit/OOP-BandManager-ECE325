package ece325.labs.lab2;

import java.io.BufferedReader;
import java.lang.Math;

import java.io.FileReader;
import java.io.IOException;

public class BandNameGenerator {
	String[] adjectives;
	String[] nouns;
	
	boolean adjectivesLoaded = false;
	boolean nounsLoaded = false;
	
	String adjectivesFile;
	String nounsFile;
	
	public BandNameGenerator(String adjectivesFile, String nounsFile) {
		this.adjectivesFile = adjectivesFile;
		this.nounsFile = nounsFile;		
	}
	
	
	/**
	 * Load the adjectives file and initialize that part of the generator.
	 */
	public void loadAdjectives() {
		adjectives = loadTxt(adjectivesFile) ;
		adjectivesLoaded = true;
	}
	
	/**
	 * Load the nouns file and initialize that part of the generator.
	 */
	public void loadNouns() {
		nouns = loadTxt(nounsFile);
		nounsLoaded = true;
	}
			
	/**
	 * Return a string that capitalizes only the first letter of s. So for example,
	 * cat becomes Cat.
	 * 
	 * @param s
	 * @return
	 */
	public String capitalizeFirst(String s) {
		String capitalized = s.substring(0,1).toUpperCase() + s.substring(1);
		return capitalized;
	} 
	
	
	/** 
	 * Generate a name for your band consisting of two adjectives and one noun.
	 * Make sure to return "UNINITIALIZED" if the band name generator is not initialized correctly yet.
	 * @return the generated name or "UNINITIALIZED"
	 */
	public String generateName() { //DO THIS WHEN TESTED
		
		/*
		Finding a random index between 0 and the length of the array of adj/nouns to keep it within
		index. We do not need to do anything else apart from what is below because the max we can go to
		is lenght of the array - 1 because int truncates decimal points. So 0.99999.... x length of array
		will give us lenght of array -1 after being truncated.
		
		*/

		int adj_1_index = (int) (Math.random()*adjectives.length);	
		int adj_2_index = (int) (Math.random()*adjectives.length);	
		int noun_index = (int) (Math.random()*nouns.length);
		
		return capitalizeFirst(adjectives[adj_1_index]) + " " + capitalizeFirst(adjectives[adj_2_index]) + " " + capitalizeFirst(nouns[noun_index]);
	}

	
	/**
	 * This method loads a text file into a String array. It assumes the number of 
	 * lines in the file is on the first line of the file itself.
	 * 
	 * Note: you are not allowed to make changes to this method. You can use this method for 
	 * loading text files in the other lab and course assignments as well.
	 * 
	 * @param file
	 * @return
	 */
	private String[] loadTxt(String file) {
		String[] data = new String[0];
		BufferedReader in = null;
		
		try { 
			in = new BufferedReader(new FileReader(file));
			String line;
			int i = 0;
			int totalLines = Integer.parseInt(in.readLine());
			data = new String[totalLines];
			while((line = in.readLine()) != null)
			{
				data[i] = line;
				i++;
				
			}
		} catch (Exception e) {
			System.err.println("Problem while reading file: " + file);
			e.printStackTrace();			
		}
		finally {
			if(in != null) { 
				try {
					in.close();
				} catch (IOException e) {
					System.err.println("Problem closing file: " + file);
					e.printStackTrace();
				} 
			}
		}
		return data;
	}
	
	/**
	 * Returns the list of adjectives.
	 * @return
	 */
	public String[] getAdjectives() {
		return adjectives;
	}
	
	/**
	 * Returns the list of nouns.
	 * @return
	 */
	public String[] getNouns() {
		return nouns;
	}
	
	public static void main(String[] args) {
		// create a BandNameGenerator and initialize it
		BandNameGenerator n = new BandNameGenerator("adjectives.txt","nouns.txt");
		// generate and print 20 names for your band
		
		/*
		n.loadAdjectives();
		n.loadNouns();
		System.out.println(n.capitalizeFirst(n.nouns[1]));
		System.out.println(n.generateName());
		System.out.println(n.nouns[n.nouns.length]);
		System.out.println(n.getNouns()[1]);
		*/
		
		//loading the adjectives and nouns from files into nouns and adjectives
		n.loadAdjectives(); 
		n.loadNouns();
		
		//setting up for loop for generating 20 band names using the generateName() method
		for (int i = 0; i<20; i++) {	
			System.out.println(n.generateName());
		}
	}

}