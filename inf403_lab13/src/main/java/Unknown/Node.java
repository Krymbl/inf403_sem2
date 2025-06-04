package Unknown;

import java.util.function.Function;

public class Node {

    private Integer value;
    private Node left;
    private Node right;
    // Возвращает либо left либо right
    private Function<RawRow, Node> function;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Function<RawRow, Node> getFunction() {
        return function;
    }

    public void setFunction(Function<RawRow, Node> function) {
        this.function = function;
    }
}