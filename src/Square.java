/** A2：正方形，领域数据为边长。 */
public class Square extends Shape {

    private final int side;

    public Square(String id, int side, Renderer renderer) {
        super(id, renderer);
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    @Override
    protected String describe() {
        return "square side=" + side;
    }
}
