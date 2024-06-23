package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MapaTest {

    private Mapa mapa;

    @BeforeEach
    public void setUp() {
        mapa = new Mapa();
    }

    @Test
    public void testIsCellAvailableForTower() {
        assertTrue(mapa.isCellAvailableForTower(0, 0));
        assertFalse(mapa.isCellAvailableForTower(1, 1));
    }

    @Test
    public void testSetCell() {
        mapa.setCell(0, 0, 'T');
        assertFalse(mapa.isCellAvailableForTower(0, 0));
    }

    @Test
    public void testGetEntryPoint() {
        assertArrayEquals(new int[]{0, 0}, mapa.getEntryPoint());
    }

    @Test
    public void testGetPath() {
        assertNotNull(mapa.getPath());
        assertTrue(mapa.getPath().size() > 0);
    }
}
