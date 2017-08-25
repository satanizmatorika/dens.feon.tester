package ru.dens.feon.tester.sometests;

import ru.dens.feon.tester.benchmark.BenchmarkDFT;
import ru.dens.feon.tester.benchmark.ObjectSizeFetcherDFT;

import java.util.ArrayList;
import java.util.LinkedList;

public class TestsStringAndBuilderAndBufferAppendDuration {


	public static void main(String[] args) {

			System.out.println(ObjectSizeFetcherDFT.getObjectSize(new String()));

//		testAddingToArrayListVsLinkedList(BenchStaticDFT.ONE_HUNDRED_THOUSAND_TIMES);

//		testStringVsNewString(BenchStaticDFT.ONE_HUNDRED_THOUSAND_TIMES);
//		testStringBuilderVsStringBuffer(BenchStaticDFT.ONE_HUNDRED_MILLION_TIMES / 4);

//		testForIIteration(BenchStaticDFT.ONE_HUNDRED_THOUSAND_TIMES, BenchStaticDFT.ONLY_ONE_TIME);

	}

	private static void testForIIteration(int iterationListSize, int benchFunctionTimes) {
		ArrayList<String> iterationArrayList = new ArrayList<>(iterationListSize);

		for (int i = 0; i < iterationListSize; i++) {
			iterationArrayList.add(new String("testForIIteration"));
		}
		System.out.println("iterationArrayList.size(): " + iterationArrayList.size());

		BenchmarkDFT.setBenchmakTimes(benchFunctionTimes);

		new BenchmarkDFT("fori_with_dynamic_size", iterationArrayList) {
			@Override
			protected void benchmarkFunction() {
				ArrayList<String> arrayList = (ArrayList<String>) object;
				String tmp;
				for (int i = 0; i < arrayList.size(); i++) {
					tmp = arrayList.get(i);
				}
			}
		}.bench().printBenchResult();

		new BenchmarkDFT("fori_with_static_size", iterationArrayList) {
			@Override
			protected void benchmarkFunction() {
				ArrayList<String> arrayList = (ArrayList<String>) object;
				String tmp;
				for (int i = 0, size = arrayList.size(); i < size; i++) {
					tmp = arrayList.get(i);
				}
			}
		}.bench().printBenchResult();

		new BenchmarkDFT("foreach", iterationArrayList) {
			@Override
			protected void benchmarkFunction() {
				ArrayList<String> arrayList = (ArrayList<String>) object;
				String tmp;
				for (String anArrayList : arrayList) {
					tmp = anArrayList;
				}
			}
		}.bench().printBenchResult();

	}

	private static void testAddingToArrayListVsLinkedList(int benchFunctionTimes) {
		BenchmarkDFT.setBenchmakTimes(benchFunctionTimes);

		new BenchmarkDFT("ArrayList", new ArrayList<String>()) {
			protected void benchmarkFunction() {
				((ArrayList<String>) object).add("ArrayList");
			}
		}.bench().printBenchResult();

		new BenchmarkDFT("ArrayListWithCapacity", new ArrayList<String>(benchFunctionTimes)) {
			protected void benchmarkFunction() {
				((ArrayList<String>) object).add("ArrayList");
			}
		}.bench().printBenchResult();

		new BenchmarkDFT("LinkedList", new LinkedList<String>()) {
			protected void benchmarkFunction() {
				((LinkedList<String>) object).add("LinkedList");
			}
		}.bench().printBenchResult();

	}

	private static void testStringVsNewString(int benchFunctionTimes) {
		BenchmarkDFT.setBenchmakTimes(benchFunctionTimes);

		new BenchmarkDFT("String concatenation with new String()", new String("")) {
			@Override
			protected void benchmarkFunction() {
				object += new String("some string1");
			}
		}.bench().printBenchResult();


		new BenchmarkDFT("String concatenation with literal(\"\") constructor", new String("")) {
			@Override
			protected void benchmarkFunction() {
				object += "some string1";
			}
		}.bench().printBenchResult();

	}


	private static void testStringBuilderVsStringBuffer(int benchFunctionTimes) {
		BenchmarkDFT.setBenchmakTimes(benchFunctionTimes);

		new BenchmarkDFT(new StringBuilder()) {
			@Override
			protected void benchmarkFunction() {
				((StringBuilder) this.getObject()).append("some string3");
			}
		}.bench().printBenchResult();

		new BenchmarkDFT(new StringBuffer()) {
			@Override
			protected void benchmarkFunction() {
				((StringBuffer) this.object).append("some string2");
			}
		}.bench().printBenchResult();

	}

}
