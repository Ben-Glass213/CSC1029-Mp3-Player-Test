package Part02;

import java.util.Scanner;

import Part01.*;

public class SystemApp {

	static MP3Player myPlayer = new MP3Player();

	public static void main(String[] args) {

		// Calling the addSomeTunesMethod in the main method.
		addSomeTunes();

		/**
		 * Creating an array which will act as our menu options
		 *  which will then be used to print the menu on screen.
		 *  this method will also check to see if user input == quit or not.
		 */
		String[] options = { "Select from full list", "Select tune by artist", "Select tune by genre", "Add new tune",
				"Display top ten", "Switch Off", "Switch On", "Exit" };
		Menu console = new Menu("MP3 Player", options);
		int quit = options.length;
		int userChoice;
		boolean done = false;
		do {
			userChoice = console.getUserChoice();
			if (userChoice == quit) {
				System.out.println("GoodBye! :)");
				done = true;
			} else {
				userOption(userChoice);
			}
		} while (!done);
	}

	// This method is used to process the user option and allow them to pick and
	// option from the menu.

	public static void userOption(int userChoice) {
		/**
		 * userOption uses switches to process user inputs, ie if the user
		 * picks 1, the switch will use case 1 and call the selectFromFullList method.
		 */
		switch (userChoice) {
		case 1:
			selectFromFullList();
			System.out.println();
			break;
		case 2:
			selectTuneByArtist();
			System.out.println();
			break;
		case 3:
			selectTuneByGenre();
			System.out.println();
			break;
		case 4:
			
			/**
			 * This case is for adding a new tune to the player and storing that information
			 * User will input a title, artist and duration along with genre and will throw an
			 * exception if it doesn't get the correct info ie == null.
			 * User info will then be stored and passed to the addNewTune method to add it to
			 * the list of tunes
			 */
			
			Scanner input1 = new Scanner(System.in);
			System.out.println("Enter a Title: ");
			String title = "";
			if (title != null) {
				title = input1.nextLine();
			}

			Scanner input2 = new Scanner(System.in);
			System.out.println("Enter a Artist: ");
			String artist = "";
			if (artist != null) {
				artist = input2.nextLine();
			}

			Scanner input3 = new Scanner(System.in);
			System.out.println("Enter a duration");
			int duration = 0;
			try {
				duration = input3.nextInt();
			} catch (Exception ex) {
				System.out.println("Input Error");
				break;
			}

			Scanner input4 = new Scanner(System.in);
			System.out.println("Enter a Genre");
			String gen = "";
			if (gen != null) {
				gen = input4.nextLine();
			}
			addNewTune(title, artist, duration, gen);
			System.out.println();
			break;

		case 5:
			displayTopTen();
			System.out.println();
			break;
		case 6:
			switchOff();
			System.out.println();
			break;
		case 7:
			switchOn();
			System.out.println();
			break;
		case 8:
			// will print a new line and method above (userInput == quit) then prints GoodBye!
			System.out.println();
			break;
		}
	}

	// Already added tunes from the starter kit
	private static void addSomeTunes() {
		myPlayer.addTune("One", "U2", 380, Genre.ROCK);
		myPlayer.addTune("Four Seasons - Winter", "Vivaldi", 5500, Genre.CLASSICAL);
		myPlayer.addTune("The Chain", "Fleetwood Mac", 750, Genre.ROCK);
		myPlayer.addTune("Graceland", "Paul Simon", 350, Genre.POP);
		myPlayer.addTune("Help", "The Beatles", 300, Genre.POP);
	}
	/**
	 *  This method is called when the user selects to add a new song to the mp3 player
	 * @param title - user input to assign a title to a song
	 * @param artist - user input to assign an artist to a song
	 * @param duration - user input to assign duration of the song
	 * @param gen - user input to assign a genre to a song
	 */
	public static void addNewTune(String title, String artist, int duration, String gen) {
		try {
			if (title == null) {
				System.out.println("Error in title input");
			}
			if (artist == null) {
				System.out.println("Error in artist input");
			}
			if (duration < 0) {
				System.out.println("Error");
			}
			if (gen == null) {
				System.out.println("Error in genre input");
			}
			Genre style = null;
			if (gen.contains("POP")) {
				style = Genre.POP;
			} else if (gen.contains("ROCK")) {
				style = Genre.ROCK;
			} else if (gen.contains("DANCE")) {
				style = Genre.DANCE;
			} else if (gen.contains("JAZZ")) {
				style = Genre.JAZZ;
			} else if (gen.contains("CLASSICAL")) {
				style = Genre.CLASSICAL;
			} else if (gen.contains("OTHER")) {
				style = Genre.OTHER;
			} else {
				System.out.println("Genre is not available");
			}

			myPlayer.addTune(title, artist, duration, style);
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}
	/**
	 * method called to switch off the mp3 player
	 */
	public static void switchOff() {
		System.out.println("Turning Off, GoodBye!");
	}
	/**
	 * method called to switch on the mp3 player
	 */
	public static void switchOn() {
		System.out.println("Turning On, Hello!");
	}
	/**
	 * Allows the user to select and see the songs from the list
	 * allowing them to play them
	 */
	public static void selectFromFullList() {
		// validation to see if there is any info to be displayed from the getTuneInfo method
		if (myPlayer.getTuneInfo() != null) {
			Menu myMenu = new Menu("Select a tune", myPlayer.getTuneInfo());
			int userChoice = myMenu.getUserChoice();
			String details[] = myPlayer.getTuneInfo();
			int number = details.length;
			/*
			 *  validation to check to see if user input is picking a song that is in the list,
			 *  is user is not picking a number that is out of bounds.
			 *  also plays the song that the user selects.
			 */
		
			if (userChoice >= 1 && userChoice <= number) {
				System.out.println(myPlayer.play(userChoice));
			} else {
				System.out.println("Tune not available");
			}
		}
	}

	/**
	 * method used to select a song using the artist's name.
	 */
	public static void selectTuneByArtist() {
		String artists[] = myPlayer.getTuneInfo();
		String settings[] = new String[artists.length];
		for (int index = 0; index < artists.length; index++) {
			String getArtist = artists[index]; // getting the artist name and storing that info in an array.
			String split[] = getArtist.split(", "); // splitting the string to add a comma.
			String test = split[2];
			settings[index] = test;

		}

		/**
		 * Creating a new menu and showing the list of artist to choose from, where
		 * the user will then select and artist.
		 */
		Menu selectMenu = new Menu("Artist list", settings);
		int userChoice = selectMenu.getUserChoice();
		String artist = settings[userChoice - 1];
		String info[] = myPlayer.getTuneInfo(artist);
		if (info.length != 0) {
			String layout[] = new String[info.length];
			for (int index = 0; index < info.length; index++) {
				String arrayTitles[] = info[index].split(", ");
				String title = arrayTitles[0];
				String artistList[] = info[index].split(", ");
				String thisArtist = artistList[1];
				layout[index] = title + " by " + thisArtist;

			}
			/*
			 * creating a new menu to which is then used once the user has selected an artist.
			 * songs from the artist are then displayed then the user is asked to select a song 
			 * they want to play.
			 */
			Menu listOfArtist = new Menu("Please select a tune", layout);
			int artistChoice = listOfArtist.getUserChoice();
			int id = -1;
			for (int index = 0; index < info.length; index++) {
				if (index == (artistChoice - 1)) {
					String arrayId[] = info[index].split(", ");
					String thisId = arrayId[0];
					id = Integer.parseInt(thisId);

				}

			}
			/**
			 * validation to ensure that a user picks a value that is not out of bounds.
			 */
			if (id == -1) {
				System.out.println("Tune unavalible");
			} else {
				String results = myPlayer.play(id);
				System.out.println(results);
			}

		}

	}
	/**
	 * method used to allow the user to pick a song based on the genre
	 */
	public static void selectTuneByGenre() {
		String options[] = { "Rock and Roll", "Easy Listening Pop", "Techno Dance", "Smooth Jazz", "Classical",
				"Unknown Genre" };
		Menu genreMenu = new Menu("Please select and genre", options); // creating and array and a new menu 
		int choice = genreMenu.getUserChoice();
		Genre style = null; // making the genre initially set to null
		/**
		 * switch used to allow the user to pick an option based on the order from the array above
		 */
		switch (choice) {
		case 1:
			style = Genre.ROCK;
			break;
		case 2:
			style = Genre.POP;
			break;
		case 3:
			style = Genre.DANCE;
			break;
		case 4:
			style = Genre.JAZZ;
			break;
		case 5:
			style = Genre.CLASSICAL;
			break;
		case 6:
			style = Genre.OTHER;
			break;
		default:
			// validation
			System.out.println("Genre Unavaliable");

		}
		/**
		 * similar method to the get artist method. This is used to collect and display information about songs based
		 * on the genre that the user picks.

		 * Creating a new menu and showing the list of genres to choose from, where
		 * the user will then select a genre of music.
		 */
		String info[] = myPlayer.getTuneInfo(style);
		if (info.length != 0) {
			String layout[] = new String[info.length];
			for (int index = 0; index < info.length; index++) {
				String arrayTitles[] = info[index].split(", ");
				String title = arrayTitles[1];
				String artistList[] = info[index].split(", ");
				String thisArtist = artistList[2];
				layout[index] = title + " by " + thisArtist;

			}
			
			/*
			 * creating a new menu to which is then used once the user has selected a genre.
			 * songs from the select genre are then displayed, then the user is asked to select a song 
			 * they want to play.
			 */
			Menu listOfGenres = new Menu("Please select a tune", layout);
			int artistChoice = listOfGenres.getUserChoice();
			int id = -1;
			for (int index = 0; index < info.length; index++) {
				if (index == (artistChoice - 1)) {
					String arrayId[] = info[index].split(", ");
					String thisId = arrayId[0];
					id = Integer.parseInt(thisId);

				}

			}
			// validation to ensure user choice is not out of bounds
			if (id == -1) {
				System.out.println("Tune unavalible");
			} else {
				String results = myPlayer.play(id);
				System.out.println(results);
			}

		}

	}

	/**
	 * method used to display the top ten songs that are played from the list.
	 * Also includes tunes that have been added.
	 */
	public static void displayTopTen() {
		String info[] = myPlayer.getTuneInfo();
		int length = info.length;
		String order[] = new String[length];
		for (int index = 0; index < info.length - 1; index++) {
			String playCounterOne[] = info[index].split(", ");
			String playCounterTwo[] = info[index + 1].split(", ");
			String playCountOne = playCounterOne[5];
			String playCountTwo = playCounterTwo[5];
			int counterOne = Integer.parseInt(playCountOne);
			int counterTwo = Integer.parseInt(playCountTwo);
			if (counterOne < counterTwo) {
				String swap = info[index];
				info[index] = info[index + 1];
				info[index + 1] = swap;
			}
		}
		System.out.println("Top Ten Played Tunes");
		for (int index = 0; index < info.length; index++) {
			System.out.println(info[index]);
		}
	}

}
