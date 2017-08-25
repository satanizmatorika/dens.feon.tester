package ru.dens.feon.tester.sometests;


//@URL: https://stackoverflow.com/questions/355089/difference-between-stringbuilder-and-stringbuffer
/**
 * Run this program a couple of times. We see that the StringBuilder does not
 * give us reliable results because its methods are not thread-safe as compared
 * to StringBuffer.
 *
 * For example, the single append in StringBuffer is thread-safe, i.e.
 * only one thread can call append() at any time and would finish writing
 * back to memory one at a time. In contrast, the append() in the StringBuilder
 * class can be called concurrently by many threads, so the final size of the
 * StringBuilder is sometimes less than expected.
 *
 */
public class StringBufferVSStringBuilder {

	public static void main(String[] args) throws InterruptedException {

		int n = 10;

		//*************************String Builder Test*******************************//
		StringBuilder sb = new StringBuilder();
		StringBuilderTest[] builderThreads = new StringBuilderTest[n];
		for (int i = 0; i < n; i++) {
			builderThreads[i] = new StringBuilderTest(sb);
		}
		for (int i = 0; i < n; i++) {
			builderThreads[i].start();
		}
		for (int i = 0; i < n; i++) {
			builderThreads[i].join();
		}
		System.out.println("StringBuilderTest: Expected result is 1000; got " + sb.length());

		//*************************String Buffer Test*******************************//

		StringBuffer sb2 = new StringBuffer();
		StringBufferTest[] bufferThreads = new StringBufferTest[n];
		for (int i = 0; i < n; i++) {
			bufferThreads[i] = new StringBufferTest(sb2);
		}
		for (int i = 0; i < n; i++) {
			bufferThreads[i].start();
		}
		for (int i = 0; i < n; i++) {
			bufferThreads[i].join();
		}
		System.out.println("StringBufferTest: Expected result is 1000; got " + sb2.length());

	}

}

// Every run would attempt to append 100 "A"s to the StringBuilder.
class StringBuilderTest extends Thread {

	StringBuilder sb;

	public StringBuilderTest (StringBuilder sb) {
		this.sb = sb;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			sb.append("A");
		}

	}
}


//Every run would attempt to append 100 "A"s to the StringBuffer.
class StringBufferTest extends Thread {

	StringBuffer sb2;

	public StringBufferTest (StringBuffer sb2) {
		this.sb2 = sb2;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			sb2.append("A");
		}

	}
}