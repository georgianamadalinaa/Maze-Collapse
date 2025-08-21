package pro;

import java.awt.event.KeyEvent;

public class MoveLeftCommand implements Command {
    @Override
    public void execute() {
        GameManager.getInstance().movePlayer(KeyEvent.VK_LEFT);
    }
}
