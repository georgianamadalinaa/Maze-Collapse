package pro;
public class BaseLevel implements Level {
    private int points = 0;

    @Override
    public void play() {
        // Logica de bază a jocului
        System.out.println("Jocul de bază a fost jucat!");
        addPoints(10);// Puncte pentru jocul de bază
    }

    @Override
    public int getPoints() {
        return points;
    }

	@Override
	public void addPoints(int points) {
		// TODO Auto-generated method stub
		this.points += points;
	}
}