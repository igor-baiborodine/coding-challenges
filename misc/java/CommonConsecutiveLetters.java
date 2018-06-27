/**
 * Write a function that counts the number of consecutive letters that a name has in common with another name.
 * Spaces and punctuation characters should be ignored. The series of consecutive letters can start anywhere
 * in the name, and need only be consecutive in the first name (i.e. it’s ok to skip letters in the second name).
 *
 * Examples:
 * "I.B.M.", "International Business Machines" -> 3
 * "Microsoft Inc.", "Microsoft Corporation" -> 9
 * "The Society for Creative Anachronism", "Creative Agencies Inc." - >	9
 * "Statcan", "Statistics Canada" -> 7
 */
public class CommonConsecutiveLetters {

	public static void main(String...args) {
		System.out.printf("expected=3, actual=%d%n",
				countConsecutiveLetters("I.B.M.", "International Business Machines"));
		System.out.printf("expected=9, actual=%d%n",
				countConsecutiveLetters("Microsoft Inc.", "Microsoft Corporation"));
		System.out.printf("expected=9, actual=%d%n",
				countConsecutiveLetters("The Society for Creative Anachronism", "Creative Agencies Inc."));
		System.out.printf("expected=7, actual=%d%n",
				countConsecutiveLetters("Statcan", "Statistics Canada"));
	}

	private static int countConsecutiveLetters(String firstName, String secondName) {
		firstName = firstName.replaceAll("[^A-Za-z]", "");
		secondName = secondName.replaceAll("[^A-Za-z]", "");
		int count = 0;
		String previousConsecutiveLetter = "";

		for (int i = 0; i < firstName.length(); i++) {
			String letter = firstName.substring(i, i + 1);
			if ((previousConsecutiveLetter.isEmpty()
					|| firstName.substring(i - 1, i).equals(previousConsecutiveLetter))
					&& secondName.contains(letter)) {
				count++;
				previousConsecutiveLetter = letter;
			}
		}
		return count;
	}

}
