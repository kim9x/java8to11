package me.pulpury.java8to11;

//public interface Bar extends Foo2 {
public interface Bar {
	
	// Bar에서 Foo2에 정의된 Default Method를 사용하고싶지 않을 시
	// 아래처럼 구현체에서 재정의할 수 있도록 해주면 된다.
//	void printNameUpperCase();
	
	default void printNameUpperCase() {
		System.out.println("Bar");
	}
	
}
