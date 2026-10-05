/**
 * 客户端与演示入口（基础版本）：运行 T1-T5 检查，无交互输入。
 * 运行方式：java -cp out Main --demo
 */
public class Main {

    /** 已通过的检查数。 */
    private static int passed = 0;

    /** 已执行的检查总数。 */
    private static int total = 0;

    public static void main(String[] args) {
        if (args.length == 1 && "--demo".equals(args[0])) {
            runDemo();
        } else {
            System.out.println("Usage: java -cp out Main --demo");
        }
    }

    /** 依次执行 T1-T5，并输出根据实际结果计算出的汇总。 */
    private static void runDemo() {
        runMatrixChecks();
        runRuntimeSwitchCheck();
        System.out.println("SUMMARY: " + passed + "/" + total + (passed == total ? " PASS" : " FAIL"));
    }

    /** T1-T4：两种抽象（圆/正方形）与两种实现（矢量/光栅）的 2x2 组合。 */
    private static void runMatrixChecks() {
        Circle circleWithVector = new Circle("A1", 2, new VectorRenderer());
        verify("T1", "Circle + VectorRenderer", circleWithVector.getId().equals("A1") && circleWithVector.getRadius() == 2,
                circleWithVector.execute(), "VECTOR circle radius=2");

        Circle circleWithRaster = new Circle("A1", 2, new RasterRenderer());
        verify("T2", "Circle + RasterRenderer", circleWithRaster.getId().equals("A1") && circleWithRaster.getRadius() == 2,
                circleWithRaster.execute(), "RASTER circle radius=2");

        Square squareWithVector = new Square("A2", 3, new VectorRenderer());
        verify("T3", "Square + VectorRenderer", squareWithVector.getId().equals("A2") && squareWithVector.getSide() == 3,
                squareWithVector.execute(), "VECTOR square side=3");

        Square squareWithRaster = new Square("A2", 3, new RasterRenderer());
        verify("T4", "Square + RasterRenderer", squareWithRaster.getId().equals("A2") && squareWithRaster.getSide() == 3,
                squareWithRaster.execute(), "RASTER square side=3");
    }

    /** T5：同一对象运行时从 I1 切换到 I2；用 == 证明对象未变，ID 与领域数据保持。 */
    private static void runRuntimeSwitchCheck() {
        total++;
        Circle circle = new Circle("A1", 2, new VectorRenderer());
        Circle original = circle;                        // 保留切换前的引用
        String before = circle.execute();

        circle.setImplementation(new RasterRenderer());  // 运行时替换实现方式
        String after = circle.execute();

        boolean sameObject = original == circle;         // 引用相等 => 同一对象
        boolean stateUnchanged = "A1".equals(circle.getId()) && circle.getRadius() == 2;
        boolean pass = sameObject && stateUnchanged
                && "VECTOR circle radius=2".equals(before)
                && "RASTER circle radius=2".equals(after);
        if (pass) {
            passed++;
        }
        System.out.println("T5 " + (pass ? "PASS" : "FAIL")
                + " | sameObject=" + sameObject
                + " | stateUnchanged=" + stateUnchanged
                + " | before=" + before
                + " | after=" + after
                + (pass ? "" : " | expectedBefore=VECTOR circle radius=2 | expectedAfter=RASTER circle radius=2"));
    }

    /** 通用校验：由预期字符串 (expected) 与领域数据 (domainOk) 共同计算 PASS/FAIL。 */
    private static void verify(String testId, String participants, boolean domainOk, String actual, String expected) {
        total++;
        boolean pass = domainOk && expected.equals(actual);
        if (pass) {
            passed++;
        }
        System.out.println(testId + (pass ? " PASS" : " FAIL")
                + " | " + participants
                + " | result=" + actual
                + (pass ? "" : " | expected=" + expected + " | domainOk=" + domainOk));
    }
}
