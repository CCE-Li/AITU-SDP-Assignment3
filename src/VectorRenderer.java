/** I1：矢量渲染器。 */
public class VectorRenderer implements Renderer {

    @Override
    public String render(String description) {
        return "VECTOR " + description;
    }
}
