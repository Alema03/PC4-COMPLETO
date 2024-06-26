package org.example;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class WaveTest {

    private Mapa mockMap;
    private Wave wave;

    @BeforeEach
    public void setUp() {
        mockMap = mock(Mapa.class);
        when(mockMap.getEntryPoint()).thenReturn(new int[]{0, 0});
        wave = new Wave(1);
    }

    @Test
    public void testGenerateEnemies() {
        List<Enemy> enemies = wave.getEnemies();
        assertEquals(5, enemies.size());
    }

    @Test
    public void testSpawnEnemies() {
        List<Enemy> enemies = wave.spawnEnemies(mockMap);
        for (Enemy enemy : enemies) {
            assertArrayEquals(new int[]{0, 0}, enemy.getPosition());
        }
    }
}
