package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pro.Level;
import pro.PointsDecorator;
import pro.BaseLevel;

class TestPointsDecorator {

    @Test
    void testPointsDecorator() {
        
        Level baseLevel = new BaseLevel();

        // Creezi un decorator pentru puncte
        PointsDecorator pointsDecorator = new PointsDecorator(baseLevel);

        // Verifici inițial dacă punctajul este 0
        assertEquals(0, pointsDecorator.getPoints());

        // Joci nivelul decorat (care ar trebui să adauge 20 de puncte)
        pointsDecorator.play();

        // Verifici dacă punctajul a fost actualizat corespunzător
        assertEquals(60, pointsDecorator.getPoints());

        // Adaugi mai multe puncte și verifici din nou
        pointsDecorator.addPoints(30);
        assertEquals(50, pointsDecorator.getPoints());
    }
}

