package hello;

public class DoMain {

    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

	public static void main(String[] args) {

		System.out.println(COUNT_BITS);
		System.out.println(CAPACITY);
	}

}
