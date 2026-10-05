/**
 * I3：ASCII 字符渲染器（扩展阶段新增）。
 * 只新增本类，抽象层、接口、I1 与 I2 均未修改。
 */
public class AsciiRenderer implements Renderer {

    @Override
    public String render(String description) {
        return "ASCII " + description;
    }
}
