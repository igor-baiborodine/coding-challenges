import java.util.HashMap;
import java.util.Map;

/**
 * Implement a method that validates if a string, that can only contain '()[]{}' characters, is well formatted,
 * i.e., every opening character has a matching closing character.
 *
 * Input format: a string that contains only the following characters '()[]{}'
 * Output format: true, if the input string is well formatted, false otherwise
 *
 * Examples: "()" -> true, well formatted
 *           "())" -> false, not well formatted
 */
public class WellFormattedString {

	private static Map<String, String> openingToClosingCharMap = new HashMap<>();
	static {
		openingToClosingCharMap.put("(", ")");
		openingToClosingCharMap.put("[", "]");
		openingToClosingCharMap.put("{", "}");
	}

	public static final void main(String...args) {
		System.out.printf("expected=false, actual=%b%n", isWellFormatted(")"));
		System.out.printf("expected=false, actual=%b%n", isWellFormatted("("));
		System.out.printf("expected=false, actual=%b%n", isWellFormatted(")("));
		System.out.printf("expected=true, actual=%b%n", isWellFormatted("({[]})"));
		System.out.printf("expected=false, actual=%b%n", isWellFormatted("([)"));
		System.out.printf("expected=false, actual=%b%n", isWellFormatted("())(()"));
		System.out.printf("expected=true, actual=%b%n", isWellFormatted("(([]))({})"));
	}

	private static boolean isWellFormatted(String s) {
		if (isClosingChar(String.valueOf(s.charAt(0)))) {
			return false;
		}
		Map<String, Integer> closingCharToCountMap = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			if (isAnyClosingCountNegative(closingCharToCountMap)) {
				return false;
			} else {
				String currentChar = String.valueOf(s.charAt(i));
				if (isClosingChar(currentChar)) {
					int count = closingCharToCountMap.getOrDefault(currentChar, 0);
					closingCharToCountMap.put(currentChar, --count);
				} else {
					String closingChar = openingToClosingCharMap.get(currentChar);
					int count = closingCharToCountMap.getOrDefault(closingChar, 0);
					closingCharToCountMap.put(closingChar, ++count);
				}
			}
		}
		return !isAnyClosingCountGreaterThanZero(closingCharToCountMap);
	}

	private static boolean isClosingChar(String s) {
		return openingToClosingCharMap.containsValue(s);
	}

	private static boolean isAnyClosingCountNegative(Map<String, Integer> charToCountMap) {
		return openingToClosingCharMap.values()
				.stream()
				.map(c -> charToCountMap.getOrDefault(c, 0))
				.min(Integer::compare).get() < 0;
	}

	private static boolean isAnyClosingCountGreaterThanZero(Map<String, Integer> charToCountMap) {
		return openingToClosingCharMap.values()
				.stream()
				.map(c -> charToCountMap.getOrDefault(c, 0))
				.max(Integer::compare).get() > 0;
	}

}
