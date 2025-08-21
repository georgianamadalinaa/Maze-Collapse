package test;
import pro.Level1;
import pro.Level2;
import pro.Level3;

import static org.junit.jupiter.api.Assertions.*;

class Test {

	@org.junit.jupiter.api.Test
	void test() {
		 Level1 level1 = new Level1();
	        Level2 level2 = new Level2();
	        Level3 level3 = new Level3();

	        // Verificăm tranziția de la Level1 la Level2
	        level1.transitionToNextLevel(level2);
	        assertEquals(level2, level1.getNextLevel());

	        // Verificăm tranziția de la Level2 la Level3
	        level2.transitionToNextLevel(level3);
	        assertEquals(level3, level2.getNextLevel());
	}

}
