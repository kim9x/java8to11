package me.pulpury.java8to11;

public class App {
	
	public static void main(String[] args) {
		Foo2 foo = new DefaultFoo("taeju");
//		Bar foo = new DefaultFoo("taeju");
		foo.printName();
		foo.printNameUpperCase();
		
		Foo2.printAnything();
	}
}
