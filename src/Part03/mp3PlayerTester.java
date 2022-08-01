package Part03;

import Part01.*;

public class mp3PlayerTester {

	public static void main(String[] args) {
		TCase_1();
		TCase_2();
		
	}
	
	public static void TCase_1() {
		
		System.out.println("Test Case One - Valid getTuneInfo Construction");
		System.out.println("==============================================");
		
		try {
			MP3Player player = new MP3Player();
			player.addTune("TestTitle" , "TestArtist", 100, Genre.POP);
			
			System.out.println("Expected Result: " + "TestTitle, TestArtist, 100 " + Genre.POP + "," + " 0");
			
			System.out.print("Actual Result");
			String[] array = player.getTuneInfo();
			for (String result: array)	{
				System.out.println(result);
		}
		System.out.println();
		
		}catch(Exception ex) {
			System.out.println("Exception : " + ex);
			System.out.println("Error - This should not happen for valid data.");
		}

	}
	
	public static void TCase_2() {
		System.out.println("Test Case Two - play Construction");
		System.out.println("=================================");
	
		String validTitle = "Test Title One";
		String validArtist = "Test Artist One";
		int validDuration = 100;
		Genre validGenre = Genre.ROCK;
		
		try {
			MP3Player player = new MP3Player();
			player.addTune("TestTitle" , "TestArtist", 100, Genre.POP);
			
			System.out.println("Expected Result: " + "TestTitle, TestArtist, 100 " + Genre.POP + "," + " 1");
			
			System.out.print("Actual Result");
			String[] array = player.play();
			for (String result: array)	{
				System.out.println(result);
		}
		System.out.println();
		
		}catch(Exception ex) {
			System.out.println("Exception : " + ex);
			System.out.println("Error - This should not happen for valid data.");
		}
	
		
	}
}
