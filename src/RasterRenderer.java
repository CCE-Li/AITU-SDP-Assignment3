/** I2：光栅渲染器。 */
public class RasterRenderer implements Renderer {

    @Override
    public String render(String description) {
        return "RASTER " + description;
    }
}
