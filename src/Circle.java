/** A1：圆形，领域数据为半径。 */
public class Circle extends Shape {

    private final int radius;

    public Circle(String id, int radius, Renderer renderer) {
        super(id, renderer);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    protected String describe() {
        return "circle radius=" + radius;
    }
}
