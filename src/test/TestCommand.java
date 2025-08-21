package test;
import static org.junit.jupiter.api.Assertions.*;
import pro.GameManager;
import pro.Command;
import pro.MoveUpCommand;
import pro.MoveDownCommand;
import pro.MoveLeftCommand;
import pro.MoveRightCommand;
import org.junit.jupiter.api.Test;

class TestCommand {

    @org.junit.jupiter.api.Test
    void testMoveUpCommand() {
        GameManager gameManager = GameManager.getInstance();
        int initialRow = gameManager.getPlayerRow();

        Command moveUpCommand = new MoveUpCommand();
        moveUpCommand.execute();

        assertEquals(initialRow, gameManager.getPlayerRow());
    }

    @org.junit.jupiter.api.Test
    void testMoveDownCommand() {
        GameManager gameManager = GameManager.getInstance();
        int initialRow = gameManager.getPlayerRow();

        Command moveDownCommand = new MoveDownCommand();
        moveDownCommand.execute();

        assertEquals(initialRow + 1, gameManager.getPlayerRow());
    }


    @org.junit.jupiter.api.Test
    void testMoveRightCommand() {
        GameManager gameManager = GameManager.getInstance();
        int initialCol = gameManager.getPlayerCol();

        Command moveRightCommand = new MoveRightCommand();
        moveRightCommand.execute();

        assertEquals(initialCol + 1, gameManager.getPlayerCol());
    }
}

