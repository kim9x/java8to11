package me.pulpury.java8to11;

public interface Foo2 {
	
	void printName();
	
	/**
	 * @implSpec
	 * 이 구현체는 getName()으로 가져온 문자열을 대문자로 바꿔 출력한다.
	 */
	default void printNameUpperCase() {
		System.out.println(getName().toUpperCase());
	}
	
	// static 메소드도 구현이 가능하다..
	static void printAnything() {
		System.out.println("FOO2");
	}
	
	String getName();

}
