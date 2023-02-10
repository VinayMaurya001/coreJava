import java.util.function.BiConsumer;

public class ExceptionHandlingExample8 {

	public static void main(String[] args) {
		int[] someNumbers = { 1, 2, 3, 4, 5 };
		int key = 0;
		BiConsumer<Integer, Integer> wrapperLambda1 = wrapperLambda((v, k) -> {
			System.out.println(v / k);
		});
		
		process(someNumbers, key, wrapperLambda1);
		
		process(someNumbers, key, wrapperLambda((v, k) -> {System.out.println(v / k);}));
	}

	private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer) {
		return (v, k) -> {
			try {
				consumer.accept(v, k);
				
			} catch (ArithmeticException e) {
				System.out.println("Inside Wrapper Lambda"+e);
			}
		};
	}

	private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> consumer) {
		for (int i : someNumbers) {
			consumer.accept(i, key);
		}
	}
}
