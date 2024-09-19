package violet.apeiron.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApeironMath {
	
	/**
	 * Returns the nth prime, where 2 is the first (n = 1) prime.
	 * 
	 * <br/><br/>
	 * 
	 * This is currently implemented with brute-force, and runs in {@code O(n)}.
	 * 
	 * @param n The index of the prime number, i.e., {@code nthPrime(1) == 2}, {@code nthPrime(2) == 3}, and so on.
	 * 
	 * @return The nth prime number.
	 * 
	 * @throws IllegalArgumentException if the given index is less than 1.
	 */
	public static int nthPrime(int n) {
		if (n < 1) throw new IllegalArgumentException("Attempted to generate the \"" + n + "th\" prime, but the index of the prime to generate must be at least 1.");

		int currentPrime = 2;
		int primeCount = 1;

		while (primeCount < n) {
			currentPrime += 1;
			if (isPrime(currentPrime)) primeCount++;
		}

		return currentPrime;
	}

	public static int primeIndex(int n) {
		if (!isPrime(n)) throw new IllegalArgumentException("Attempted to get the prime index of " + n + ", but " + n + " isn't prime");

		int primesLessThanN = 0;

		for (int lowerNumber = 2; lowerNumber < n; lowerNumber++) {
			if (isPrime(lowerNumber)) primesLessThanN++;
		}		

		return primesLessThanN + 1;
	}

	/**
	 * Checks if a number is prime. This currently brute-force checks and runs in {@code O(sqrt(n))}. This will return {@code false}
	 * for {@code n = 1}.
	 * 
	 * @param n The number to check primality for.
	 * 
	 * @return Whether the given number is prime.
	 * 
	 * @throws IllegalArgumentException if the given number is less than 1.
	 */
	public static boolean isPrime(int n) {
		if (n < 1) throw new IllegalArgumentException("Attempted to check if " + n + " is prime, but the number to check must be at least 1.");
		if (n == 1) return false;

		for (int possibleFactor = 2; possibleFactor <= Math.sqrt(n); possibleFactor++) {
			if (n % possibleFactor == 0) return false;
		}

		return true;
	}

	/**
	 * Returns the prime factors of a number, including duplicates, in ascending order.
	 * 
	 * @param n
	 * 
	 * @return
	 */
	public static int[] primeFactorsOf(int n) {
		if (isPrime(n)) return new int[] { n };

		List<Integer> primeFactors = new ArrayList<>();
		for (int possibleFactor = 2; possibleFactor < n; possibleFactor++) {
		    if (isPrime(possibleFactor) && n % possibleFactor == 0) {
				primeFactors.add(possibleFactor);
				primeFactors.addAll(Arrays.stream(primeFactorsOf(n / possibleFactor)).boxed().toList());
				break;
		    } 
		}

		return primeFactors.stream().mapToInt(factor -> factor).toArray();
	}

}
