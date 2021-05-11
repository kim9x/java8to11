package me.pulpury.java8to11;

public class Foo {
	
	public static void main(String[] args) {
		
		// java 8 전에는 아래처럼 익명 내부 클래스(anonymous inner class)로 사용
//		RunSomething runSomething1 = new RunSomething() {
//			
//			@Override
//			public void doIt() {
//				System.out.println("Hello");
//				
//			}
//		};
		
		// 한줄인 경우 람다로 아래처럼 사용 가능
//		RunSomething runSomething2 = () -> System.out.println("Hello");
//		runSomething2.doIt();
//		
//		// 한줄이 아닌 경우 람다로 아래처럼 사용 가능
//		RunSomething runSomething3 = () -> {
//			System.out.println("Hello");
//			System.out.println("Lamda");
//		};
		
		// 다른 언어의 함수를 정의한 것처럼 보이지만
		// 사실 java에서 람다는 특수한 형태의 오브젝트
		// 함수형 인터페이스를 인라인으로 구현한 오브젝트
		// 
		
		int baseNumber = 10;
		RunSomething runSomething = number -> number + baseNumber;
		System.out.println(runSomething.doIt(10));
		
	}

}
