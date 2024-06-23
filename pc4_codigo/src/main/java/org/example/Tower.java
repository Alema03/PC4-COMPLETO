package org.example;

import java.util.List;

public class Tower {
    private int damage; // cantidad de daño
    private int range; // número de celdas de alcance
    private int fireRate; // turnos entre disparos
    private int[] position; // posición de la torre

    // Constructor
    public Tower(int damage, int range, int fireRate, int row, int col) {
        this.damage = damage;
        this.range = range;
        this.fireRate = fireRate;
        this.position = new int[]{row, col};
    }

    // Getters y setters
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getFireRate() {
        return fireRate;
    }

    public void setFireRate(int fireRate) {
        this.fireRate = fireRate;
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int x, int y) {
        this.position[0] = x; // Establecer coordenada x
        this.position[1] = y; // Establecer coordenada y
    }

    // Método para atacar a los enemigos dentro de su alcance
    public void attack(List<Enemy> enemies) {
        for (Enemy enemy : enemies) {
            if (isInRange(enemy)) {
                enemy.takeDamage(damage);
                break; // Ataca al primer enemigo en alcance
            }
        }
    }

    // Verifica si un enemigo está dentro del alcance de la torre
    private boolean isInRange(Enemy enemy) {
        int[] enemyPos = enemy.getPosition();
        int dx = enemyPos[0] - position[0];
        int dy = enemyPos[1] - position[1];
        return dx * dx + dy * dy <= range * range;
    }
}
