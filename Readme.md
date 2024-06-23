## Clases principales:
- Game: Clase principal que maneja la lógica del juego.
![img_2.png](img_2.png)
- Map: Representa el mapa del juego.
![img_3.png](img_3.png)
- Enemy: Clase base para todos los enemigos.
![img_4.png](img_4.png)
- Tower: Clase base para todas las torres.
![img_5.png](img_5.png)
- Wave: Maneja las oleadas de enemigos.
![img_6.png](img_6.png)
- Player: Representa al jugador y sus estadísticas.
![img_7.png](img_7.png)
## Interfaces y clases de Mocking:
- EnemyFactory: Interfaz para la creación de enemigos (concretas: BasicEnemyFactory,
BossEnemyFactory).
![img_8.png](img_8.png)

- TowerFactory: Interfaz para la creación de torres (concretas: CannonTowerFactory,
LaserTowerFactory).
![img_9.png](img_9.png)

## Implementación de pruebas
### Mocks:

- Utiliza Mockito para crear mocks de las clases Enemy y Tower para verificar la interacción
entre objetos.

Creando la clase testEnemyInteractionWithTower():
![img_22.png](img_22.png)
![img_23.png](img_23.png)

![img_26.png](img_26.png)
![img_27.png](img_27.png)

### Stubs:
- Crea stubs para métodos que devuelven enemigos o torres específicos.
  
Se crea la clase testStubsForEnemyFactory
![img_24.png](img_24.png)  
![img_25.png](img_25.png)

### Fakes:
- Utilizar fakes para simular la base de datos de puntuación o estados de oleadas.

Se crea la clase FakeDatabase
![img_28.png](img_28.png)

y su test

![img_29.png](img_29.png)
![img_30.png](img_30.png)

### Pruebas de mutación:
- Implementa pruebas de mutación para verificar la calidad de las pruebas unitarias.

MapaTest:

![img_40.png](img_40.png)

WaveTest:

![img_39.png](img_39.png)

EnemyTest:

![img_41.png](img_41.png)


- ¿Qué herramienta utilizarías para realizar pruebas de mutación en este proyecto, y cómo la
configurarías?

En este caso usare piptest para las pruebas

- Configura la herramienta de pruebas de mutación para el proyecto y ejecuta un análisis de
mutación en la clase TowerDefenseGame.

Agregamos la configuración al gradle:
![img_43.png](img_43.png)

![img_45.png](img_45.png)

### Evaluación de cobertura de pruebas:

- ¿Cómo interpretarías los resultados de las pruebas de mutación y qué acciones tomarías
para mejorar la cobertura de las pruebas?

Ejecutamos el piptest y analizamos el resultado
![img_46.png](img_46.png)

Estos números indican cuánto del código está cubierto por pruebas 
y qué tan efectivas son esas pruebas para detectar mutaciones 
o errores en el código.

Las acciones que puedo tomar son:

- Identifica áreas del código que no están cubiertas por pruebas y 
crear casos de prueba para esas partes tratando de abordar diferentes 
escenarios y condiciones.


- Implementa mejoras en las pruebas unitarias basándote en los resultados de las pruebas de
mutación y explica las razones de cada cambio.

## Preguntas de diseño e implementación (5 puntos)
### Diseño de la clase Map:
- ¿Cómo implementarías la clase Map para representar el mapa del juego, asegurando que se
puedan agregar y verificar posiciones de torres y caminos?

Primero verificariamos que las coordenadas estén dentro de los límites del mapa. 
Luego, debemos asegurarnos de que la celda esté vacía o no este ocupada por algo más.

- Implementa un método en la clase Map llamado isValidPosition(int x, int y) que verifique si
una posición es válida para colocar una torre.

![img_11.png](img_11.png)

### Enemigos con diferentes características:
- Diseña e implementa una clase SpeedyEnemy que herede de Enemy y tenga una velocidad
mayor pero menos vida.

![img_12.png](img_12.png)

![img_13.png](img_13.png)


- ¿Cómo gestionarías el movimiento de los enemigos en el mapa, asegurando que sigan el
camino predefinido?

Se crea la clase path que se encargara del camino predefinido tambien se agrega la logica de movimiento y algunos atributos a las demás clases
![img_14.png](img_14.png)

### Torres con diferentes habilidades:
- Implementa una clase SniperTower que tenga un daño alto y un alcance muy largo pero una
velocidad de disparo baja.

![img_15.png](img_15.png)

![img_16.png](img_16.png)


- ¿Cómo implementarías el método attack(List<Enemy> enemies) en la clase Tower para
atacar a los enemigos dentro de su alcance?

![img_17.png](img_17.png)

### Sistema de oleadas:
- ¿Cómo diseñarías la generación de oleadas para que cada oleada sea progresivamente más
difícil?

Para que cada oleada sea progresivamente más difícil, podemos hacer que el 
número y tipo de enemigos aumenten con cada oleada. A medida que avanza el 
juego, las oleadas podrían incluir enemigos más fuertes y en mayor cantidad.

![img_18.png](img_18.png)

- Implementa un método en la clase Wave llamado spawnEnemies() que genere los enemigos
de la oleada y los coloque en el mapa.

Implementacion del metodo

![img_19.png](img_19.png)


### Sistema de puntuación y salud de la base:
- ¿Cómo actualizarías la puntuación del jugador y la salud de la base cuando un enemigo es
derrotado o alcanza la base?

Para actualizar la puntuación del jugador y la salud de la base cuando un 
enemigo es derrotado o alcanza la base, se debe implementar un metodo que haga estas acciones.
Este método actualizará la 
puntuación del jugador si el enemigo es derrotado y reducirá la salud de 
la base si el enemigo alcanza la base.

- Implementa un método en la clase Player llamado updateScoreAndHealth(Enemy enemy,
boolean defeated).

Implementación del metodo
![img_20.png](img_20.png)

## Pruebas estructurales (3 puntos)
Las pruebas estructurales se centran en verificar que el código cumpla con su estructura esperada y
que todas las ramas, condiciones y caminos estén correctamente cubiertos.
### Cobertura de ramas:
- **Ejercicio:** Implementa pruebas para garantizar que todas las ramas del método placeTower
en la clase TowerDefenseGame estén cubiertas.

clase TowerDefenseGame:
![img_21.png](img_21.png)

clase TowerDefenseGameTest:

![img_31.png](img_31.png)
![img_32.png](img_32.png)

### Cobertura de condiciones:
- **Ejercicio:** Escribe pruebas unitarias para verificar todas las condiciones en el método attack
de la clase Tower.
![img_33.png](img_33.png)
![img_34.png](img_34.png)
### Cobertura de rutas:
- **Ejercicio:** Implementa pruebas para cubrir todos los caminos posibles en el método
startWave de la clase TowerDefenseGame.
![img_35.png](img_35.png)
![img_38.png](img_38.png)
![img_37.png](img_37.png)

## Preguntas de pruebas con Mockito (2 puntos)
### Mocking de dependencias:
- ¿Cómo usarías Mockito para crear un mock del Map y probar la colocación de torres en la
clase TowerDefenseGame?

Al llamar al método placeTower con una torre y la posición (3,4), 
debería colocar la torre correctamente. Se puede lograr esto mediante 
la creación de un mock de la clase Map y configurando su 
comportamiento para que devuelva la torre esperada cuando se 
consulte la posición (3,4).

- Implementa un test con Mockito para verificar que el método placeTower solo permite
colocar torres en posiciones válidas del mapa.
![img_47.png](img_47.png)
