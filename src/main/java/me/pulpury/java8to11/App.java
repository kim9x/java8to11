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
        
        
		
	}
}
