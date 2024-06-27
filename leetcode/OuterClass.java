public class OuterClass {
    private String outerField = "Outer Field";

    public void accessInnerPrivateField() {
        InnerClass inner = new InnerClass("Inner Field");
        // 无法直接访问 inner.innerField
        // 通过公有方法访问
        System.out.println("Inner field: " + inner.innerField);
    }

    // 定义一个内部类
    public class InnerClass {
        private String innerField;

        // 构造器
        public InnerClass(String innerField) {
            this.innerField = innerField;
        }

        // 公有的getter方法
        public String getInnerField() {
            return innerField;
        }
    }

    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        outer.accessInnerPrivateField();
    }
}
