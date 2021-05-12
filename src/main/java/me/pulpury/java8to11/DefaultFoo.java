package me.pulpury.java8to11;

public class DefaultFoo implements Foo2, Bar {
	
	String name;
	
	public DefaultFoo(String name) {
		this.name = name;
	}

	// 재정의 또한 가능하다.
	// Object에서 정의된 메서드들은 재정의가 불가능하다.
	@Override
	public void printNameUpperCase() {
		// TODO Auto-generated method stub
		Foo2.super.printNameUpperCase();
	}

	@Override
	public void printName() {
		System.out.println(this.name);
	}

	@Override
	public String getName() {
		return this.name;
	}
	
}
