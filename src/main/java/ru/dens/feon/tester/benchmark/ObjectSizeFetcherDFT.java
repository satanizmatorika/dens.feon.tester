package ru.dens.feon.tester.benchmark;


import java.lang.instrument.Instrumentation;

public class ObjectSizeFetcherDFT {
	private static Instrumentation instrumentation;

	public static void premain(String args, Instrumentation instrumentation) {
		ObjectSizeFetcherDFT.instrumentation = instrumentation;
	}

	public static long getObjectSize(Object o) {
		return instrumentation.getObjectSize(o);
	}
}