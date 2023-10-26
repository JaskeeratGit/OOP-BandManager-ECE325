package ece325.lec.assignment2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SongCollectionArray {
	private String[] songs;
	private String[] nonUniqueSongs;
	/**
	 * Create a SongCollectionArray object with capacity i (= the number of songs it can hold).
	 * @param i the number of songs the collection can hold
	 */
	public SongCollectionArray(int i) {
		
		// Initializing required fields, I make 2 arrays, 1 with duplicates and 1 without using the methods
		
		songs = new String[i];
		nonUniqueSongs = new String[i];
	}
	
	
	/**
	 * Add s to the collection. Only add s if it is not in the collection yet. 
	 * Return true if the addition was successful, otherwise return false.
	 * 
	 * @param s the song to be added
	 * @return
	 */
	public boolean add(String s) {
		
		/** 
		 * Using the contains(s) method from down below to see if string is in the collection already.
		 * If it is not found, we loop through the collection to append it to an available index in the array.
		 * After it is confirmed we return true, otherwise false.
		 */
		
		if (this.contains(s) == false){
			for(int j=0; j < songs.length; j++) {
				if (songs[j] == null){
						songs[j] = s;
						return true;
				}
			}
			
		}
		return false;
	}
	
	
	/**
	 * Remove s from the collection. Make sure that all the empty spots of the array 
	 * are at the end. So if you remove a song from the 'middle' of the array, you need to
	 * make sure that the empty spot is filled up somehow.
	 * @param s the song to be removed
	 */
	public void remove(String s) {
		
		/**
		 * I use a temporary array as a clone of the collection so that I can remove a specific element from the
		 * collection and then copy the elements after the deleted one from the clone back into the collection
		 * 
		 */
		String[] tempArray = songs.clone();
		boolean inList = false;
		
		/** I use .equals(string) method because I want to compare content and not what they are referencing. Had
		 *  a few issues trying == instead
		 */
	
		for (int i = 0; i < songs.length; i++) {
			if(songs[i] != null && songs[i].equals(s)) {   
				inList = true;
			}
			if (inList == true && i < songs.length - 1) {	// Copying elements back after removal
				songs[i] = tempArray[i+1];		
			}
		}
		if (inList == true) {
			songs[songs.length-1] = null;	// Setting last element to be null
		}
		
	}
	
	/**
	 * Return true if the collection contains s, false otherwise.
	 * @param s the song to be searched for
	 * @return
	 */
	public boolean contains(String s) {
		
		// Looping through songs to see if string s is in it, exits as soon as it is found if found
		
		for (int i = 0; i < songs.length; i++) {
			if(songs[i] != null && songs[i].equals(s)) { 
				return true;
			}
		}
		return false;
	}
	/**
	 * If there is a song at position index in the collection, return it. Otherwise return null.
	 * @param index the index of the song to return
	 * @return
	 */
	public String getSong(int index) {
		
		// Returning song at index, if negative index/index out of range then returned null
		
		if (index >= 0 && index < songs.length) {
			return songs[index];
		}
		else {
			return null;
		}
	}
	
	/**
	 * Return the number of songs in the collection.
	 * @return
	 */
	public int getNumberOfSongs() {
		
		// Simple counter mechanism
		
		int count = 0;
		
		for (int i=0; i < songs.length; i++) {
			if (songs[i] != null) {
			count=count+1;
			}
		}
			
		return count;
	}
	
	/**
	 * Make sure to read the songs.txt file and print the number of unique songs in it.
	 * @param args
	 */
	
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
	
	public void loadSongs() {
		 nonUniqueSongs = loadTxt("songs.txt");		// Using the loadTxt function to read the songs.txt file
	}
	
	public void makeUniqueSongList() {			// Making the collection and ensuring it does not have duplicates
		for (int i = 0; i < nonUniqueSongs.length; i++) {	
			this.add(nonUniqueSongs[i]);
		}
	}
	
	public static void main(String[] args) {
		
		/*
		 * object creation, loading of songs.txt, making collection and printing out the number of songs the band has
		 * using the methods created earlier.
		 */
		
		SongCollectionArray s1 = new SongCollectionArray(100);	
		s1.loadSongs();
		s1.makeUniqueSongList();
		System.out.println(s1.getNumberOfSongs());
	}
}

