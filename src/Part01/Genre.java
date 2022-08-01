package Part01;

public enum Genre {
	ROCK(0), POP(1), DANCE(2), JAZZ(3), CLASSICAL(4), OTHER(5);
	/**
	 * creating an enum for the different genres of music
	 */
	private String spelling[] = { "Rock and Roll", "Easy Listening Pop", "Techno Dance", "Smooth Jazz", "Classical",
			"Unknown Genre" };

	private int index;

	private Genre(int str) {
		index = str;
	}

	public String toString() {
		return spelling[index];
		// toString will return the enum into a string instead of an integer
	}

}
