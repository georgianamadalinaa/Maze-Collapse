package pro;

import java.util.ArrayList;
import java.util.List;

class SubjectObserver {
	private int state;
    private List<Observer> observers = new ArrayList<>();
    
    public int getState() {
        return state;
    }
    

    public void setState(int state) {
        this.state = state;
        notifyObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
    	 for (Observer observer : observers) {
             observer.update(state); // Folosește indicele stării
         }
    }
}
