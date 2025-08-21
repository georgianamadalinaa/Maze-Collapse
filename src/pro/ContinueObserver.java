package pro;

public class ContinueObserver implements Observer {
	 private SubjectObserver subject;
	public ContinueObserver(SubjectObserver subject) {
		 this.subject = subject;
	        this.subject.attach(this);
	}
	@Override
	public void update(int newState) {
		System.out.println("Starea jocului a fost actualizată la: " + newState);
	      
		
	}

}
