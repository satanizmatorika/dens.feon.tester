package ru.dens.feon.tester.benchmark;

import java.util.List;

public abstract class BenchmarkDFT {


	private static int benchmakTimes;

	private static String outer;


	static {
		benchmakTimes = BenchStaticDFT.ONLY_ONE_TIME;
		outer = String.valueOf(BenchStaticDFT.DEFAULT_OUTER_SYSTEM_OUT_PRINT);
	}


	private long startTime;
	private long endTime;
	private long funcTimes = -1;
	private String name;

	public Object getObject() {
		return object;
	}

	public Object object;

	public static void setBenchmakTimes(int i) {
		if (i > 0) benchmakTimes = i;
	}

	public static void setOuter(String outer) {
		BenchmarkDFT.outer = outer;
	}

	public static String getOuter() {
		return outer;
	}

	public long getStartTime() {
		return startTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public long getFuncTimes() {
		return funcTimes;
	}

	public BenchmarkDFT setFuncTimes(long funcTimes) {
		this.funcTimes = funcTimes;
		return this;
	}

	public String getName() {
		return name;
	}

	public BenchmarkDFT(Object benchObject) {
		this(benchObject.getClass().getName(), benchObject);
	}

	public BenchmarkDFT(Object benchObject, int funcTimes) {
		this(benchObject.getClass().getName(), benchObject, funcTimes);
	}

	public BenchmarkDFT(String benchName, Object benchObject) {
		this(benchName, benchObject, -1);
	}

	public BenchmarkDFT(String benchName, Object benchObject, int funcTimes) {
		this.object = benchObject;
		this.name = benchName;
		this.funcTimes = funcTimes;
	}


	public BenchmarkDFT bench() {
		if (funcTimes <= 0) funcTimes = benchmakTimes;
		startTime = System.currentTimeMillis();
		for (int i = 0; i < funcTimes; i++) {
			benchmarkFunction();
		}
		endTime = System.currentTimeMillis();
		return this;
	}


	protected abstract void benchmarkFunction();


	public BenchmarkDFT printBenchResult() {
		StringBuilder benchResult = new StringBuilder("\nstart ").append(name).append(" test in  ").append(startTime)
				.append(" and end in ").append(endTime).append("\r\n").append(name).append(" test times: ")
				.append(funcTimes).append("; test duration: ").append(endTime - startTime).append("\r\n")
				.append(name).append(".toString().length(): ").append(object.toString().length()).append("\r\n");

		if (object instanceof List) benchResult.append(name).append(".size(): ")
				.append(((List) object).size()).append("\r\n");

		if (outer.toLowerCase().equals(BenchStaticDFT.DEFAULT_OUTER_SYSTEM_OUT_PRINT)) {
			System.out.println(benchResult.toString());
		}
		return this;
	}
}
