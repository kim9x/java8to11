package me.pulpury.java8to11;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class App {
	
	public static void main(String[] args) {
		
		List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));
        
        OnlineClass spring_boot = new OnlineClass(1, "spring boot", true);
//        Duration studyDurtaion = spring_boot.getProgress().getStudyDuration();
//        System.out.println(studyDurtaion);
        
//        Progress progress = spring_boot.getProgress();
//        if ( progress != null) {
//        	System.out.println(progress.getStudyDuration());
//        }
        
        // primitive type의 경우 아래처럼 사용할 시
        // 박싱 언박싱이 일어나기 때문에(성능 저하 우려)
        Optional.of(10);
        // 아래처럼 지원해주는 OptionalInt 같은 것을 사용하자.!
        OptionalInt.of(10);
        
        Optional<OnlineClass> onlineClass = springClasses.stream()
        	.filter(oc -> oc.getTitle().startsWith("jpa"))
        	.findFirst();
        
        boolean present = onlineClass.isPresent();
        System.out.println(present);
        
//        if (onlineClass.isPresent()) {
//    	OnlineClass onlineClass1 = onlineClass.get();
//    	System.out.println(onlineClass1.getTitle());        	
//        }
        
//        OnlineClass onlineClass1 = onlineClass.get();
//    	System.out.println(onlineClass1.getTitle());
    	
    	onlineClass.ifPresent(oc -> {
    		System.out.println(oc.getTitle());
    	});
    	
    	// 'orElse' 사용 시 무조건 'createNewClass()' 메서드가 실행된다. 
//    	OnlineClass onlineClass2 = onl?ineClass.orElse(createNewClass());
    	
    	// 'orElseGet'을 사용하면 있는 경우엔 실행되지 않는다.
//    	OnlineClass onlineClass2 = onlineClass.orElseGet(() -> createNewClass());
//    	OnlineClass onlineClass2 = onlineClass.orElseGet(App::createNewClass);
//    	System.out.println(onlineClass2.getTitle());
    	
//    	OnlineClass onlineClass3 = onlineClass.orElseThrow(() -> {
//    		return new IllegalArgumentException();
//    	});
    	
//    	OnlineClass onlineClass3 = onlineClass.orElseThrow(IllegalStateException::new);
    	
    	Optional<OnlineClass> onlineClass4 = onlineClass
    								.filter(oc -> oc.getId() > 10);
    	
    	Optional<OnlineClass> onlineClass5 = onlineClass
//				.filter(oc -> !oc.isClosed());
    			.filter(OnlineClass::isClosed);
    	
    	System.out.println(onlineClass5.isEmpty());
    	
    	Optional<Integer> id = onlineClass.map(oc -> oc.getId());
    	Optional<Integer> id2 = onlineClass.map(OnlineClass::getId);
    	
    	System.out.println(id.isPresent());
    	
    	// Optional 안에 Optional이 있다.
    	// 아래처럼 flatMap을 사용하면 한번에 처리가 가능하다.
    	// Why? Optional 안의 map을 한번 까주기 때문.
//    	Optional<Optional<Progress>> progress = onlineClass.map(OnlineClass::getProgress);
//    	Optional<Progress> progress1 = progress.orElse(Optional.empty());
//    	progress1.orElseThrow();
    	
    	// flatMap 사용 시 
    	// 위의 progress1 과정까지 한번에 처리가 가능하다.
		Optional<Progress> progress = onlineClass.flatMap(OnlineClass::getProgress);
		
		// Stream의 flatMap과는 다르다.
		// list에 담고 있는 container 성격 안에 있는 것을 가져올 때..
		// input은 하나이지만 output은 여러 개 일 때 사용.
    	
		
	}

	private static OnlineClass createNewClass() {
		// TODO Auto-generated method stub
		System.out.println("createing new online class");
		return new OnlineClass(10, "New class", false);
	}
}
