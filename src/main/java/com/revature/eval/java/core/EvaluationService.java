package com.revature.eval.java.core;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		// store all characters into array of chars
		char[] charArr = string.toCharArray();
		// find midpoint
		int mid = charArr.length / 2;
		// swap the characters
		for (int i = 0; i < mid; i++) {
			char temp = charArr[i];
			charArr[i] = charArr[(charArr.length - 1) - i];
			charArr[(charArr.length - 1) - i] = temp;
		}
		// convert array of chars to string
		String output = String.valueOf(charArr);
		return output;
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// use regex to split words separated by space and '-'
		String[] wordsArr = phrase.split("[ |-]");
		String output = "";
		// loop through array and append first character to output
		for (int i = 0; i < wordsArr.length; i++) {
			output += wordsArr[i].substring(0, 1).toUpperCase();// set first letters to caps
		}
		return output;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		// check if all three sides are equal
		public boolean isEquilateral() {
			// if sideOne is the same as sideTwo and sideThree
			if (this.getSideOne() == this.getSideTwo() && this.getSideOne() == this.getSideThree()) {
				// and sideTwo is the same as sideThree then triangle is equilateral
				if (this.getSideTwo() == this.getSideThree())
					return true;
			}
			return false;
		}

		// check if only two sides are equal
		public boolean isIsosceles() {
			if (this.getSideOne() == this.getSideTwo() || this.getSideOne() == this.getSideThree()
					|| this.getSideTwo() == this.getSideThree())
				return true;

			return false;
		}

		// check if all three sides are different
		public boolean isScalene() {
			if (this.getSideOne() != this.getSideTwo() && this.getSideOne() != this.getSideThree()) {
				if (this.getSideTwo() != this.getSideThree())
					return true;
			}
			return false;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		int score = 0;
		for (int i = 0; i < string.length(); i++) {
			// set each letter to lower case and append score with appropriate values
			char letter = string.toLowerCase().charAt(i);
			switch (letter) {
			case 'a':
				score += 1;
				break;
			case 'e':
				score += 1;
				break;
			case 'i':
				score += 1;
				break;
			case 'o':
				score += 1;
				break;
			case 'u':
				score += 1;
				break;
			case 'l':
				score += 1;
				break;
			case 'n':
				score += 1;
				break;
			case 'r':
				score += 1;
				break;
			case 's':
				score += 1;
				break;
			case 't':
				score += 1;
				break;
			case 'd':
				score += 2;
				break;
			case 'g':
				score += 2;
				break;
			case 'b':
				score += 3;
				break;
			case 'c':
				score += 3;
				break;
			case 'm':
				score += 3;
				break;
			case 'p':
				score += 3;
				break;
			case 'f':
				score += 4;
				break;
			case 'h':
				score += 4;
				break;
			case 'v':
				score += 4;
				break;
			case 'w':
				score += 4;
				break;
			case 'y':
				score += 4;
				break;
			case 'k':
				score += 5;
				break;
			case 'j':
				score += 8;
				break;
			case 'x':
				score += 8;
				break;
			case 'q':
				score += 10;
				break;
			case 'z':
				score += 10;
				break;
			}
		}
		return score;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		// remove any special chars, letters, and extra spaces
		String baseFormat = string.replaceAll("[.\\s-()a-z!@#$%^&*:]", "");
		// check that baseFormat has the correct amount of numbers
		if (baseFormat.length() != 10) {
			if (baseFormat.length() == 11) {
				if (baseFormat.charAt(0) == 1) {
					return baseFormat.substring(1);
				}
			}

			// if baseFormat has more than or less than 11 numbers then the input is invalid
			if (baseFormat.length() > 11 || baseFormat.length() < 11)
				throw new IllegalArgumentException();
		}
		return baseFormat;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		int count = 1;
		Map<String, Integer> wordMap = new HashMap<String, Integer>();
		// split words that are partitioned by comma, space, or newline
		String[] wordsArr = string.split("[,\\s\\n]");
		// loop through array and check if word exists in map
		for (int i = 0; i < wordsArr.length; i++) {
			// ignore any empty array cells
			if (!wordsArr[i].equals("")) {
				// if word exists in map then increment that word's count value
				if (wordMap.containsKey(wordsArr[i])) {
					wordMap.replace(wordsArr[i], count, ++count);
				}
				// otherwise add new word to map with count value of 1
				else {
					wordMap.put(wordsArr[i], 1);
				}
			}

		}
		return wordMap;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T extends Comparable<T>> {
		private List<T> sortedList;

		public int indexOf(T t) {
			int start = 0;
			int end = this.getSortedList().size() - 1;
			// pass search val and start and end indexes to overloaded method
			return indexOf(t, start, end);
		}

		public int indexOf(T t, int start, int end) {
			// find midpoint of list
			int mid = ((end - start) / 2) + start;
			// if the midpoint contains our search val then return the index it's located
			if (this.getSortedList().get(mid).equals(t)) {
				return mid;
			}

			// if start == end check if list.get(start) contains the search val, return if
			// true
			if (start == end) {
				if (this.getSortedList().get(start) == t)
					return start;
			}

			// if search val < list.get(mid) set end to mid-1 and recursively call indexOf
			if(t.compareTo(this.getSortedList().get(mid)) < 0) {
				end = mid-1;
				return indexOf(t, start, end);
			}
			// if search val > list.get(mid) set start to mid+1 and recursively call indexOf
			if(t.compareTo(this.getSortedList().get(mid)) > 0) {
				start = mid+1;
				return indexOf(t, start, end);
			}
			return -1;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		String output = "";
		// split phrase to words
		String[] wordsArr = string.split(" ");
		for (int i = 0; i < wordsArr.length; i++) {
			// identify words that begin with vowel sounds
			char firstLetter = wordsArr[i].toLowerCase().charAt(0);
			String first2Phrase = wordsArr[i].substring(0, 2);
			String first3Phrase = wordsArr[i].toLowerCase().substring(0, 3);

			if (first3Phrase.equals("sch")) {
				// create new word with StringBuilder and append startingPhrase+"ay" to the end
				StringBuilder newWord = new StringBuilder(wordsArr[i].substring(3));
				newWord.append(first3Phrase + "ay ");
				// return String value of newWord
				output += String.valueOf(newWord);
			}

			else if (first2Phrase.equals("th") || first2Phrase.equals("qu")) {
				// create new word with StringBuilder and append new startingPhrase+"ay" to the
				// end
				StringBuilder newWord = new StringBuilder(wordsArr[i].substring(2));
				newWord.append(first2Phrase + "ay ");
				output += String.valueOf(newWord);
			}

			else if (firstLetter == 'a' || firstLetter == 'e' || firstLetter == 'i' || firstLetter == 'o'
					|| firstLetter == 'u') {
				// create new word with StringBuilder and append "ay" to the end
				StringBuilder newWord = new StringBuilder(wordsArr[i]);
				newWord.append("ay ");
				output += String.valueOf(newWord);
			}

			else {
				// create new word with StringBuilder and append firstLetter+"ay" to the end
				StringBuilder newWord = new StringBuilder(wordsArr[i].substring(1));
				newWord.append(firstLetter + "ay ");
				output += String.valueOf(newWord);
			}
		}
		return output.trim();// remove any trailing spaces
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		ArrayList<Integer> digit = new ArrayList<>();
		int savedInput = input;// needed to store original input
		int sum = 0;
		int raisedDigit;
		// add each digit to ArrayList in reverse order
		while (input > 0) {
			digit.add(input % 10);
			input = input / 10;
		}
		// travel through ArrayList
		for (int i = 0; i < digit.size(); i++) {
			// calculate the raisedDigit
			raisedDigit = (int) (Math.pow(digit.get(i), digit.size()));
			// sum them together
			sum += raisedDigit;
		}
		// check if the sum value is the same as the input
		if (sum == savedInput)
			return true;

		return false;
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		List<Long> factorList = new ArrayList<>();
		// generate a list of factors to the input 'l'
		for (long i = 2; i <= l; i++) {
			while (l % i == 0) {
				factorList.add(i);
				l = l / i;
			}
		}

		return factorList;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			String output = "";
			// travel through each character in the string
			for (int i = 0; i < string.length(); i++) {
				char letter = string.charAt(i);
				// ignore empty space characters
				if (letter != ' ') {
					int charVal = (int) letter;// get ascii val of character
					// check if character's ascii val is between cap letter range
					if (charVal > 64 && charVal < 91) {
						int shift = (charVal + key);// shift by key value
						// check if letter shifts out of range
						if (shift > 90) {
							int diff = shift - 90;// find the difference
							shift = 64 + diff;// then add to ascii val of 'A'-1 to keep in range
						}
						// append to output
						output += (char) shift;
					}
					// check if character's ascii val is between lower case letter range
					else if (charVal > 96 && charVal < 123) {
						int shift = (charVal + key);// shift by key value
						// check if letter shifts out of range
						if (shift > 122) {
							int diff = shift - 122;// find the difference
							shift = 96 + diff;// then add to ascii val of 'A'-1 to keep in range
						}
						// append to output
						output += (char) shift;
					}
					// otherwise leave the character alone
					else
						output += letter;
				}
				// append space
				else
					output += letter;
			}
			return output;
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		ArrayList<Integer> primes = new ArrayList<>();
		if (i == 0)
			throw new IllegalArgumentException();

		int check = 2;
		while (primes.size() < i) {
			if (isPrime(check))
				primes.add(check);

			check++;
		}
		return primes.get(primes.size() - 1);
	}

	public static boolean isPrime(int check) {
		// only need to check up to the square root of check
		int stopPoint = (int) (Math.sqrt(check));
		for (int i = 2; i <= stopPoint; i++) {
			if (check % i == 0)
				return false;
		}
		return true;
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			String output = "";
			int count = 0;
			for (int i = 0; i < string.length(); i++) {
				//change letters to lower case
				char letter = string.toLowerCase().charAt(i);
				//ignore white space
				if (letter != ' ') {
					int charVal = (int)letter;//get ascii value
					if (charVal > 96 && charVal < 123) {
						//subtract the largest ascii val from the difference between the letter's ascii val and the lowest 
						//possible ascii val
						int shift = 122 - (charVal - 97);
						//append to output
						output += (char)shift;
						count++;//increment count
						//when the fifth letter has been appended to output append a space
						if(count==5) {
							output += " ";
							count = 0;
						}
					}
					//ignore any other character besides numbers
					else if(charVal > 47 && charVal < 58) {
						output += letter;
						count++;
						if(count==5) {
							output += " ";
							count = 0;
						}
					}
				}
			}
			return output.trim();
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			String output = "";
			for (int i = 0; i < string.length(); i++) {
				//change letters to lower case
				char letter = string.toLowerCase().charAt(i);
				//ignore white space
				if (letter != ' ') {
					int charVal = (int)letter;//get ascii value
					if (charVal > 96 && charVal < 123) {
						//subtract the largest ascii val from the difference between the letter's ascii val and the lowest 
						//possible ascii val
						int shift = 122 - (charVal - 97);
						//append to output
						output += (char)shift;
					}
					else if(charVal > 47 && charVal < 58) 
						output += letter;

				}
			}
			return output;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		int sum = 0;
		//remove all dashes and any invalid characters except for 'X'
		String numOnly = string.replaceAll("[-A-WYZ]", "");
		//check length if less than 10 then invalid characters were removed and ISBN was invalid
		if(numOnly.length() != 10)
			return false;
		
		//travel through each number
		for(int i=0;i<10;i++) {
			char number = numOnly.charAt(i);
			//replace 'X' with 10
			if(number == 'X') {
				sum += 10*(10-i);
			}
			else {
				//multiply each number by 10-i (i should increment with each iteration)
				sum += Character.getNumericValue(number)*(10-i);
			}
		}
		
		//check if valid ISBN
		if(sum % 11 == 0)
			return true;
		
		return false;
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {		
		//ensure string has at least 26 characters
		if(string.length() < 26)
			return false;
		
		//travel through alphabet by incrementing through their ascii values
		for(char i='a'; i<='z'; i++) {
			//ensure all letters appear in string at least once
			if(!string.contains(String.valueOf(i)))
				return false;
		}
		return true;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		int year=0, month=0, day=0, hour=0, minute=0, second=0;
		//attempt to receive all fields of information from given
		try {
			year = given.get(ChronoField.YEAR);
			month = given.get(ChronoField.MONTH_OF_YEAR);
			day = given.get(ChronoField.DAY_OF_MONTH);
			hour = given.get(ChronoField.HOUR_OF_DAY);
			minute = given.get(ChronoField.MINUTE_OF_HOUR);
			second = given.get(ChronoField.SECOND_OF_MINUTE);
		}
		//when exception occurs b/c time is not provided then provide default values 
		catch(UnsupportedTemporalTypeException e) {
			hour = 0;
			minute = 0;
			second = 0;
		}
		//create correct output format
		LocalDateTime dateWithTime = LocalDateTime.of(year, month, day, hour, minute, second);
		int gigaSec = (int)Math.pow(10, 9);
		Duration amount = Duration.ofSeconds(gigaSec);
		//add gigasecond to time
		dateWithTime = dateWithTime.plus(amount);
		
		return dateWithTime;
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		HashSet<Integer> numSet = new HashSet<>();
		int total = 0;
		//find multiples of each number in set array
		for(int j=0;j<set.length;j++) {
			//generate list of numbers that are multiples of each number in the array up to 
			//but not including the limit number i
			for(int k=1;k<i;k++) {
				if(k%set[j] == 0) {
					numSet.add(k);//numbers stored in set to keep only unique multipliers
				}
			}
		}
		//sum the contents of numSet together
		for(int num:numSet) {
			total += num;
		}
		
		return total;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		ArrayList<Integer> numList = new ArrayList<>(); 
		int sumVal = 0;
		//remove all whitespaces
		String check = string.replaceAll("[\\s]", "");
		//check length of characters to ensure valid number of characters, 
		//9 for social insurance number and 16 for credit cards
		int digitLength = check.length();
		if(digitLength == 9 || digitLength == 16) {
			int count = 1;
			for(int i=0;i<digitLength;i++) {
				//start with the last number, convert from char to int
				int number = Character.getNumericValue(check.charAt((digitLength-1)-i));
				//convert every other number according to the luhn formula then store into numList
				if(count == 2) {
					int result = number*2;
					//when result > 9 overwrite it's value with the difference between result and 9
					if(result>9) {
						result = result - 9;
					}
					numList.add(result);
					count = 1;//reset count
				}
				//store every first number into the numList
				else {
					numList.add(number);
					count++;
				}
			}
			//sum contents of arrayList
			for(int digit:numList) {
				sumVal += digit;
			}
			if(sumVal % 10 == 0)
				return true;
			
		}
		return false;
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		int output = 0;
		//remove all unnecessary characters
		String input = string.replaceAll("(What is )|(by )|\\?", "");
		//[operand1, operation, operand2]
		String[] inputArr = input.split(" ");
		String operation = inputArr[1];//should always be the operation
		//convert string numbers to ints
		int op1 = Integer.parseInt(inputArr[0]);
		int op2 = Integer.parseInt(inputArr[2]);
		switch(operation) {
		case "plus":
			output = op1 + op2;
			break;
		case "minus":
			output = op1 - op2;
			break;
		case "multiplied":
			output = op1 * op2;
			break;
		case "divided":
			output = op1 / op2;
			break;
		}
		return output;
	}

}
