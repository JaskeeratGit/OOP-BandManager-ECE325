package ece325.lec.assignment2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SongCollectionArrayList {
	private ArrayList<String> songs;
	private String[] nonUniqueSongs;
	/**
	 * Create a SongCollectionArrayList object.
	 * 
	 */
	public SongCollectionArrayList() {
		songs = new ArrayList<String>();
	}

	/**
	 * Add s to the collection. Only add s if it is not in the collection yet. 
	 * Return true if the addition was successful, otherwise return false.
	 * 
	 * @param s the song to be added
	 * @return
	 */
	public boolean add(String s) {		
		if (!this.contains(s)) {		// Using contains(String s) to see if song already there, if not then adding
			songs.add(s);
			return true;
		}
		return false;
	}

	/**
	 * Remove s from the collection.
	 * @param s the song to be removed
	 */
	public void remove(String s) {
		songs.remove(s);
	}

	/**
	 * Return true if the collection contains s, false otherwise.
	 * @param s the song to be searched for
	 * @return
	 */
	public boolean contains(String s) {
		if (songs.contains(s)){				//Using the ArrayList<String>.contains() method instead of writing it all
			return true;
		}
		return false;
	}
	
	/**
	 * If there is a song at position index in the collection, return it. Otherwise return null.
	 * @param index the index of the song to return
	 * @return
	 */
	public String getSong(int index) {
		if (index>=0 && index<songs.size()) {
			return songs.get(index);
		}
		return null;
	}

	/**
	 * Return the number of songs in the collection.
	 * @return
	 */
	public int getNumberOfSongs() {
		return songs.size();
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
		
		SongCollectionArrayList collection = new SongCollectionArrayList();
		collection.loadSongs();
		collection.makeUniqueSongList();
		System.out.println(collection.getNumberOfSongs());
		
	}

}
