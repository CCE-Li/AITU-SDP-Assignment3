/**
 * 桥接模式的“抽象层”（Abstraction）基类。
 * 通过构造方法注入实现者接口引用（桥），只依赖 Renderer 接口，
 * 不创建、不转换、也不判断任何具体实现类型。
 */
public abstract class Shape {

    /** 抽象层标识：运行时切换实现后仍保持不变。 */
    private final String id;

    /** 桥：接口类型的引用，指向当前使用的实现方式。 */
    private Renderer renderer;

    protected Shape(String id, Renderer renderer) {
        this.id = id;
        this.renderer = renderer;
    }

    public String getId() {
        return id;
    }

    /** 运行时替换实现方式：抽象层代码无需任何改动。 */
    public void setImplementation(Renderer renderer) {
        this.renderer = renderer;
    }

    /** 子类各自的领域行为：返回带尺寸的形状描述。 */
    protected abstract String describe();

    /** 对外统一入口：通过桥接口引用调用低级操作，并以字符串返回结果。 */
    public String execute() {
        return renderer.render(describe());
    }
}
