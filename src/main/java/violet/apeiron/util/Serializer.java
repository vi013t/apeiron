package violet.apeiron.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Class for serialization helpers. This class provides methods that convert complex data types to and from more simple ones,
 * such as converting a list of integers into a unique single integer, and converting such an integer back into it's original
 * list.
 */
public class Serializer {
	
	/**
	 * Converts a set of integers into a single unique integer identifier. This integer can then be used in {@link #intToIntSet(int)}
	 * to get back a copy of the original set. This doesn't mutate the given set.
	 * 
	 * <br/><br/>
	 * 
	 * Currently, this is rather inefficient, and runs in {@code O(n^2)}. Use it sparingly. 
	 * 
	 * @param set The set of integers to convert to a single unique integer.
	 * 
	 * @return A unique integer identifier for the given set.
	 */
	public static int intSetToInt(Set<Integer> set) {
		return set.stream().reduce(1, (accumulator, current) -> accumulator * ApeironMath.nthPrime(current));
	}

	/**
	 * Converts a unique integer identifier for an integer set back into a copy of the original set. The given number should be a value from
	 * {@link #intSetToInt(Set)}.
	 * 
	 * <br/><br/>
	 * 
	 * Currently, this is a bit inefficient, and runs in {@code O(n * sqrt(n))}.
	 * 
	 * @param number The number to convert to an integer set, which must be a returned value from a call to {@link #intSetToInt(Set)}.
	 * 
	 * @return A copy of the original set passed to {@link #intSetToInt(Set)}.
	 */
	public static Set<Integer> intToIntSet(int number) {
		return Arrays.stream(ApeironMath.primeFactorsOf(number)).map(primeFactor -> ApeironMath.primeIndex(primeFactor)).boxed().collect(Collectors.toSet());
	}
}
