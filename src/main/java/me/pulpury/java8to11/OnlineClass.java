package me.pulpury.java8to11;

import java.util.Optional;

public class OnlineClass {
	
	private Integer id;

    private String title;

    private boolean closed;
    
    public Progress progress;

    public OnlineClass(Integer id, String title, boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    // return 타입으로만 Optional을 사용한다.
    // 문법적으로 제한은 없지만 return 타입으로만 사용하는 것이 권장 사항이다.
	public Optional<Progress> getProgress() {
//		if (this.progress == null) {
//			throw new IllegalStateException();
//		}
//		return progress;
		
		// null이 들어올만한 상황이 아니라면 'of'를 사용한다.
		// 이 때, 만약 null이 들어올다면 NullPointerException이 발생한다.
		// null이 들어올 수 있으면 'ofNullable'을 사용해줘야한다.
//		return Optional.ofNullable(progress);
		
		return Optional.empty();
		
		// null을 return 하지 말자. (return null;)
		// Optional을 리턴하자.! (Optional.empty();)
	}

	public void setProgress(Progress progress) {
		this.progress = progress;
	}
	
	// progress에 null이 들어와버리면
	// null 값으로 무언가를 하려하기 때문에
	// ifPresent 과정에서 NullPointerException이 발생.
//	public void setProgress(Optional<Progress> progress) {
//		this.progress = progress.get();
//		progress.ifPresent(p -> this.progress = p);
//	}
	
}
