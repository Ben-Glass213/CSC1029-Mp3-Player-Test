package Part01;

public class Tune implements iTune {
	private int id;
	private static int nextId = 1;
	private String title;
	private String artist;
	private int duration;
	private int playCount;
	private Genre style;
	
	public Tune(String title, String artist, int duration, Genre gen) {
		this.id = useNextId();
		this.title = title;
		this.artist = artist;
		this.duration = duration;
		this.playCount = 0;
		this.style = gen;
		
	}
	// getter used to increment and Id each time it is used
	private int useNextId() {
		return nextId++;
	}
	// getter used to get and id
	public int getId() {
		return this.id;
	}
	// getter used to get the title of a song
	public String getTitle(){
		return this.title;
	}
	// getter used to get the artist
	public String getArtist(){
		return this.artist;
	}
	// getter used to get the duration of the song
	public int getDuration(){
		return this.duration;
	}
	// getter used to get the genre of the song using the enumeration
	public Genre getGenre(){
		return this.style;
	}
	// getter used to get the play count of the song ie how many times its been played
	public int getPlayCount() {
		return this.playCount;
	}
	// toString method used to add up all the important information about a song so that it can be called and printed easily
	public String toString() {
		String str = this.id + ", " + this.title + ", " + this.artist + ", " + this.duration + ", " + this.style;
		return str;
		// Change Later
	}
	/*
	 *  play is used to get inform the user of what song is being played where it will then print a message to say
	 *  "Now Playing" and "By" allowing the user to see the song being played and the artist.
	 */
	public String play() {
		this.playCount++;
		String str = "Now Playing: " + this.title;
		str += " By: " + this.artist + "\n";
		return str;
		
	}
	
}
