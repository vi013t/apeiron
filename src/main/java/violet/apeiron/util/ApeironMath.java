package violet.apeiron.util;

import java.util.ArrayList;
import java.util.List;

public class ApeironMath {
	
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

	public static boolean isPrime(int n) {
		for (int possibleFactor = 2; possibleFactor <= Math.sqrt(n); possibleFactor++) {
			if (n % possibleFactor == 0) return false;
		}

		return true;
	}

	public static int[] primeFactorsOf(int n) {
		if (n < 1) throw new IllegalArgumentException("Attempted to factor " + n + ", but the number to factor must be at least 1.");

		List<Integer> factors = new ArrayList<>();

		for (int possibleFactor = 2; possibleFactor <= n; possibleFactor += 1) {
			if (isPrime(possibleFactor) && n % possibleFactor == 0) factors.add(possibleFactor);
		}

		return factors.stream().mapToInt(factor -> factor).toArray();
	}
}
