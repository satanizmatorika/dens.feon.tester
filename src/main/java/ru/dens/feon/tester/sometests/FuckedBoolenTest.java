package ru.dens.feon.tester.sometests;

public class FuckedBoolenTest {
	public static void main(String[] args) {
		Boolean[] values = getValues();
		for (Boolean bVal : values) {
			if (bVal == Boolean.TRUE) {
				System.out.println("TRUE");
			} else if (bVal == Boolean.FALSE) {
				System.out.println("FALSE");
			} else if (Boolean.TRUE.equals(bVal)) {
				System.out.println("true");
			} else if (Boolean.FALSE.equals(bVal)) {
				System.out.println("false");
			} else {
				System.out.println("null");
			}

		}
	}

	private static Boolean[] getValues() {
		return new Boolean[]{false, true, new Boolean(false), new Boolean(true), true, false, null};
	}
}
