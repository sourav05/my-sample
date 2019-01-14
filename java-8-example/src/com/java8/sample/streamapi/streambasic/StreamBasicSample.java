package com.java8.sample.streamapi.streambasic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamBasicSample {

	public static void main(String[] args) {
		new StreamBasicSample().findAnyExample();
		new StreamBasicSample().skipExample();
	}
	
	public void findAnyExample(){
		List<String> list = Arrays.asList("G","B","F","E");
		String any = list.stream().findAny().get();
		System.out.println("FindAny: "+ any);
		String first = list.stream().findFirst().get();
		System.out.println("FindFirst: "+ first);
	}
	
	public void skipExample(){
		Integer[] array = {3,5,10,15,20};
		/*Stream<int[]> arrStream = Stream.of(array);
		arrStream.skip(1).forEach(e -> System.out.println(e));*/
		Stream.of(array).skip(2).forEach(w -> System.out.println(w.intValue()));
	}
}
