package Part03;

import java.time.Duration;

import Part01.*;

public class tuneTester {

	public static void main(String[] args) {
		TCase_1();
		TCase_2();
		TCase_3();
		TCase_4();
		TCase_5();
	}

	public static void TCase_1() {
		String validTitle = "Test Title One";
		String validArtist = "Test Artist One";
		int validDuration = 100;
		Genre validGenre = Genre.ROCK;

		System.out.println("Test Case One - Valid Add Tune Construction");
		System.out.println("===========================================");

		try {
			Tune tune = new Tune(validTitle, validArtist, validDuration, validGenre);
			System.out.println("Expected Title: " + "Test Title One");
			System.out.println("Actual Title: " + validTitle);
			System.out.println("Expected Artist: " + "Test Artist One");
			System.out.println("Actual Artist: " + validArtist);
			System.out.println("Expected Duration: " + "100");
			System.out.println("Actual Duration: " + validDuration);
			System.out.println("Expected Genre: " + "Rock and Roll");
			System.out.println("Actual Genre: " + validGenre);
			System.out.println();

		} catch (Exception ex) {
			System.out.println("Exception : " + ex);
			System.out.println("Error - This should not happen for valid data.");
		}
		System.out.println("End Test Case One");
		System.out.println("=================");
		System.out.println();
	}

	public static void TCase_2() {
		String title = "Song Name";
		String artist = "Song Artist";
		int duration = 100;

		Genre gen1 = Genre.ROCK;
		Genre gen2 = Genre.POP;
		Genre gen3 = Genre.JAZZ;
		Genre gen4 = Genre.DANCE;
		Genre gen5 = Genre.OTHER;

		System.out.println("Test Case Two - Valid Genre Construction");
		System.out.println("===========================================");

		try {
			Tune tune1 = new Tune(title, artist, duration, gen1);
			Tune tune2 = new Tune(title, artist, duration, gen2);
			Tune tune3 = new Tune(title, artist, duration, gen3);
			Tune tune4 = new Tune(title, artist, duration, gen4);
			Tune tune5 = new Tune(title, artist, duration, gen5);

			System.out.println("Expected Result " + "Genre ROCK");
			System.out.println("Actual Result: " + "Song Title: " + title + " Genre: " + gen1);

			System.out.println("Expected Result " + "Genre POP");
			System.out.println("Actual Result: " + "Song Title: " + title + " Genre: " + gen2);

			System.out.println("Expected Result " + "Genre JAZZ");
			System.out.println("Actual Result: " + "Song Title: " + title + " Genre: " + gen3);

			System.out.println("Expected Result " + "Genre DANCE");
			System.out.println("Actual Result: " + "Song Title: " + title + " Genre: " + gen4);

			System.out.println("Expected Result " + "Genre OTHER");
			System.out.println("Actual Result: " + "Song Title: " + title + " Genre: " + gen5);

			System.out.println();
		} catch (Exception ex) {
			System.out.println("Exception : " + ex);
			System.out.println("Error - This should not happen for valid data.");
		}
		System.out.println("End Test Case Two");
		System.out.println("=================");
		System.out.println();
	}

	public static void TCase_3() {
		String invalidTitle = null;
		String invalidArtist = null;
		int invalidDuration = 0;
		Genre invalidGenre = null;

		System.out.println("Test Case Three - Invalid Add Tune Construction");
		System.out.println("=============================================");

		try {
			Tune tune = new Tune(invalidTitle, invalidArtist, invalidDuration, invalidGenre);
			System.out.println("Expected Title: " + "null");
			System.out.println("Actual Title: " + invalidTitle);
			System.out.println("Expected Artist: " + "null");
			System.out.println("Actual Artist: " + invalidArtist);
			System.out.println("Expected Duration: " + "0");
			System.out.println("Actual Duration: " + invalidDuration);
			System.out.println("Expected Genre: " + "null");
			System.out.println("Actual Genre: " + invalidGenre);
			System.out.println();

		} catch (Exception ex) {
			System.out.println("Exception : " + ex);
			System.out.println("Error - This should not happen for valid data.");
		}
		System.out.println("End Test Case Three");
		System.out.println("=================");
		System.out.println();
	}

	public static void TCase_4() {
		String title = "Test Title Two";
		String artist = "Test Artist Two";
		int duration = 0;
		Genre genre = Genre.CLASSICAL;

		System.out.println("Test Case Four - Valid Play Construction");
		System.out.println("===========================================");

		try {
			Tune testTune = new Tune(title, artist, duration, genre);
			System.out.println("Expected Result: " + "Now Playing: Test Title Two By: Test Artist Two ");
			System.out.println("Actual Result: " + testTune.play());
			System.out.println("Expected Result: " + "1");
			System.out.println("Actual Result: " + testTune.getPlayCount());
			System.out.println();

		} catch (Exception ex) {
			System.out.println("Exception : " + ex);
			System.out.println("Error - This should not happen for valid data.");
		}
		System.out.println("End Test Case Four");
		System.out.println("=================");
		System.out.println();

	}

	public static void TCase_5() {
		String title1 = "Title1";
		String artist1 = "Artist1";
		int duration1 = 100;
		Genre gen1 = Genre.POP;

		String title2 = "Title2";
		String artist2 = "Artist2";
		int duration2 = 200;
		Genre gen2 = Genre.CLASSICAL;

		System.out.println("Test Case Five - Valid Unique ID Construction");
		System.out.println("===========================================");

		try {
			Tune tune1 = new Tune(title1, artist1, duration1, gen1);
			Tune tune2 = new Tune(title2, artist2, duration2, gen2);
			System.out.println("Expected Result: " + "4 " + "and " + "5");
			System.out.println("Actual Result: " + "Tune1- " + tune1.getId() + " and" + " Tune2- " + tune2.getId());
			System.out.println();
		} catch (Exception ex) {
			System.out.println("Exception : " + ex);
			System.out.println("Error - This should not happen for valid data.");
		}
		System.out.println("End Test Case Five");
		System.out.println("==================");
		System.out.println();
	}

}
