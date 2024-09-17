package violet.apeiron.util;

import java.util.Arrays;

public class Serializer {
	
	public static int intListToInt(int[] list) {
		int product = 1;
		for (int number : list) product *= ApeironMath.nthPrime(number);
		return product;
	}

	public static int[] intToIntList(int number) {
		return Arrays.stream(ApeironMath.primeFactorsOf(number)).map(primeFactor -> ApeironMath.primeIndex(primeFactor)).toArray();
	}
}
