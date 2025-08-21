package pro;

import java.awt.event.KeyEvent;

public class MoveRightCommand implements Command {
    @Override
    public void execute() {
        GameManager.getInstance().movePlayer(KeyEvent.VK_RIGHT);
    }
}