# Assignment 3 — Bridge Pattern (Topic A: Drawing / Shapes)

**Student:** 李易鑫 (Yixin Li)  
**Group:** SE-2526  
**Topic:** A — Drawing/Shapes (abstraction: shapes; implementor: renderers)  
**Repository:** https://github.com/CCE-Li/AITU-SDP-Assignment3

## Role map

| Role | Class | Source |
| --- | --- | --- |
| Abstraction (abstract base) | `Shape` | `src/Shape.java` |
| A1 (radius = 2) | `Circle` | `src/Circle.java` |
| A2 (side = 3) | `Square` | `src/Square.java` |
| Implementor (interface) | `Renderer` | `src/Renderer.java` |
| I1 | `VectorRenderer` | `src/VectorRenderer.java` |
| I2 | `RasterRenderer` | `src/RasterRenderer.java` |
| Client | `Main` | `src/Main.java` |

Where to look:

- **Bridge field:** `Shape.renderer` — type `Renderer`, injected through the `Shape(String, Renderer)` constructor.
- **`execute()`:** `Shape.execute()` returns `renderer.render(describe())`; it is the only path from the abstraction to the implementation.
- **`setImplementation(...)`:** `Shape.setImplementation(Renderer)` swaps the implementation at runtime.
- **T5 check:** `Main.runRuntimeSwitchCheck()` proves the same object (`==`), unchanged `id`/`radius`, and the results before/after the switch.

## Build and run

```
javac --release 17 -encoding UTF-8 -d out "@sources.txt"
java -cp out Main --demo
```

## Expected output of `--demo`

```
T1 PASS | Circle + VectorRenderer | result=VECTOR circle radius=2
T2 PASS | Circle + RasterRenderer | result=RASTER circle radius=2
T3 PASS | Square + VectorRenderer | result=VECTOR square side=3
T4 PASS | Square + RasterRenderer | result=RASTER square side=3
T5 PASS | sameObject=true | stateUnchanged=true | before=VECTOR circle radius=2 | after=RASTER circle radius=2
SUMMARY: 5/5 PASS
```
