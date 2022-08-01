package Part01;

import java.util.ArrayList;

public class MP3Player implements iPlayer {
	private ArrayList<Tune> soundData;

	public MP3Player() {
		soundData = new ArrayList<Tune>();

	}

	/**
	 * Method used to assign a tune with a title, artist, duration and genre.
	 * 
	 * @param title    - title of the song.
	 * @param artist   - who the song is by.
	 * @param duration - how long the song will play for in seconds.
	 * @param gen      - the genre of the music.
	 * @return - title, artist, duration and the genre of the music and store it in
	 *         the mp3 player OR return false if fields are null.
	 */
	public boolean addTune(String title, String artist, int duration, Genre gen) {
		int count = soundData.size();

		if (title == null || artist == null || duration < 0 || gen == null) {
			return false;
		}
		for (int index = 0; index < count; index++) {
			Tune thisTune = soundData.get(index);
			if (title.equals(thisTune.getTitle()) && artist.equals(thisTune.getArtist())
					&& duration == thisTune.getDuration() && gen == thisTune.getGenre()) {
				return false;
			}
		}

		Tune addTune = new Tune(title, artist, duration, gen);
		soundData.add(addTune);
		return true;
	}

	/**
	 * method used to get the information about a tune and the play count
	 */
	public String[] getTuneInfo() {
		int num = soundData.size();
		String[] data = new String[num];
		if (num == 0) {
			return null;
		} else {
			for (int index = 0; index < num; index++) {
				Tune currentTune = soundData.get(index);
				data[index] = currentTune.toString() + ", " + currentTune.getPlayCount();
			}
		}
		return data;

	}

	/**
	 * method used to get the genre of a tune
	 */
	public String[] getTuneInfo(Genre gen) {
		ArrayList<String> styleArray = new ArrayList<String>();
		String data[] = new String[soundData.size()];
		for (int index = 0; index < data.length; index++) {
			if (soundData.get(index).getGenre().equals(gen)) {
				styleArray.add(soundData.get(index).toString());
			}
		}
		int number = styleArray.size();
		String details[] = new String[number];
		for (int index = 0; index < number; index++) {
			details[index] = styleArray.get(index);
		}
		return details;

	}

	/**
	 * method used to get the tune info ie the artist
	 */
	public String[] getTuneInfo(String artist) {
		ArrayList<String> artistArray = new ArrayList<String>();
		String data[] = new String[soundData.size()];
		for (int index = 0; index < data.length; index++) {
			if (soundData.get(index).getArtist().equals(artist)) {
				artistArray.add(soundData.get(index).toString());
			}
		}
		int number = artistArray.size();
		String details[] = new String[number];
		for (int index = 0; index < number; index++) {
			details[index] = artistArray.get(index);
		}
		return details;

	}

	/**
	 * method used to play a tune and print out the song that is being played along
	 * with who the song is by
	 * 
	 * @param tuneId - the id of the tune
	 * @return - this returns the title and the artist along with strings to help
	 *         identify the song that is playing
	 */
	public String play(int tuneId) {
		String details = "";
		for (int index = 0; index < soundData.size(); index++) {
			if (soundData.get(index).getId() == tuneId) {
				soundData.get(index).play();
				details = soundData.get(index).getTitle() + "By " + soundData.get(index).getArtist() + " Now Playing!";
				return details;
			}
		}
		return null;

	}
}
