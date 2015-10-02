import java.util.Random;
import java.util.ArrayList;

public class UT
{
	private static Random rand = new Random();

	// Returns a random element from a String array.
	public static String randSTR(String[] array)
	{
		return array[randInt(0,array.length-1)];
	}

	// Returns a capitalized String.
	public static String capitalize(String a)
	{
		String b = a.substring(0,1).toUpperCase();
		String c = a.substring(1).toLowerCase();
		return b+c;
	}

	// Simulates a percent chance out of 100.
	public static boolean chance(int chance)
	{
		return (randInt(0,100)<=chance);
	}

	// Returns a random int in [min, max].
	public static int randInt(int min, int max)
	{
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}

	// Waits for the designated number of milliseconds
	public static void wait(int time)
	{
		try {
				Thread.sleep(time);
			} catch (InterruptedException e) {System.out.println("Error in \"wait\" method.");}
	}

	// Rounds to the specified number of decimal places. Doesn't work for all cases.
	public static double roundTo(double value, int n)
	{
		return (double) Math.round(value*Math.pow(10,n))/Math.pow(10,n);
	}

	// Binary searches a String Array List for a specified string and returns the index. Returns -1 if not found.
	// Array must be sorted alphabetically.
	public static int stringBinarySearch(ArrayList<String> stringArray, String word)
	{
		int start = 0;
		int end = stringArray.size()-1;
		while (start<=end)
		{
			int mid = start + (end - start) / 2;
			if (word.compareTo(stringArray.get(mid))<0)
				end = mid -1;
			else if (word.compareTo(stringArray.get(mid))>0)
				start = mid + 1;
			else return mid;
		}
		return -1;
	}


}
