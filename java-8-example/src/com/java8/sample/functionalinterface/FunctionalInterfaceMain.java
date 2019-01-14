package com.java8.sample.functionalinterface;

public class FunctionalInterfaceMain {

	public static void main(String[] args) {
		FunctionalInterfaceSample add = (n1,n2) -> {
			return n1+n2;
		};
		FunctionalInterfaceSample addMR = Utility::add; /** Method Reference example */
		FunctionalInterfaceSample substract = (n1,n2) -> {
			if(n1 > n2) return n1-n2;
			else return n2-n1;
		};
		FunctionalInterfaceSample substractMR = Utility::substract; /** Method Reference example */
		FunctionalInterfaceSample multiply = (n1,n2) -> {
			return n1*n2;
		};
		FunctionalInterfaceSample divide = (n1,n2) -> {
			if(n2 != 0) return n1/n2;
			else return -1;
		};
		
		new FunctionalInterfaceMain().calculate(add,12, 13);
		new FunctionalInterfaceMain().calculate(substract,19, 15);
		new FunctionalInterfaceMain().calculate(addMR,22,29);
		new FunctionalInterfaceMain().calculate(substractMR,15, 21);
		new FunctionalInterfaceMain().calculate(multiply,5, 6);
		new FunctionalInterfaceMain().calculate(divide,25, 2);
	}
	
	public void calculate(FunctionalInterfaceSample process, Integer... integers){
		System.out.println(process.calculate(integers[0], integers[1]));
	}

}
