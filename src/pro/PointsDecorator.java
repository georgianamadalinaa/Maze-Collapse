package pro;

public class PointsDecorator implements Level {
    private Level level;

    public PointsDecorator(Level level) {
        this.level = level;
    }

    @Override
    public void play() {
        level.play();
        System.out.println("Bonus: Ai câștigat 20 de puncte!");
        addPoints(20); // Adaugare puncte bonus
    }

    @Override
    public int getPoints() {
        return level.getPoints();
    }

	@Override
	public void addPoints(int points) {
		// TODO Auto-generated method stub
		level.addPoints(points);
	}
}
