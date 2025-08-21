package pro;

class StartObserver implements Observer {
    private SubjectObserver subject;

    public StartObserver(SubjectObserver subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update(int newState) {
        System.out.println("Starea jocului a fost actualizată la: " + newState);
        // Alte acțiuni de reacție la schimbare de stare
    }
}

