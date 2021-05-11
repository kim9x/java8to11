package me.pulpury.java8to11;

// java에서 지원해주는 자바에서 지원해주는 @FunctionalInterface 에노테이션을 사용하여
// 좀 더 견고하게 사용하자.!
@FunctionalInterface
public interface RunSomething {
	
	
	// 인터페이스에 추상 메서드가 하나만 있으면 함수형 인터페이스.
	// 다른 메서드(ex. static, default 등)들은 상관없이 추상 메서드만 하나 있으면
	// functional interface
	// abstract는 생략 가능.
//	abstract void doIt();
	
	int doIt(int number);
	
	// 두개가 있으면 안된다.
//	void doItAgain();
	
	// 자바 8부터 인터페이스에 static 메서드 사용 가능.
	static void printName() {
		System.out.println("Taeju");
	}
	
	// 인터페이스에 정의할 수 있는 형태가 더 다양해져서
	// default도 가능
	default void pringAge() {
		System.out.println("27");
	}

}
