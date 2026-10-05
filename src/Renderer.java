/**
 * 桥接模式的“实现者”（Implementor）接口：定义渲染低级操作。
 * 抽象层只通过该接口调用，不关心具体的渲染技术。
 */
public interface Renderer {

    /** 把形状描述渲染成当前实现特有的文本结果。 */
    String render(String description);
}
