package nl.han.aim.asd.expression;

public class Expression {
    private String content;
    private Expression left;
    private Expression right;

    @Override
    public String toString() {
        if (left == null) {
            return content;
        } else {
            if (right != null) {
                return left + content + right;
            }
            return left + content;
        }
    }

    public String getContent() {
        return content;
    }

    public void setContent(String newContent) {
        content = newContent;
    }

    public void setLeft(Expression newLeft) {
        left = newLeft;
    }

    public void setRight(Expression newRight) {
        right = newRight;
    }

    public double evaluate() {
        if (left == null && right == null) {
            return Double.valueOf(content);
        } else {
            double newleft = Double.valueOf(left.evaluate());
            double newRight = Double.valueOf(right.evaluate());

            switch (content) {
                case "*":
                    return newleft * newRight;
                case "+":
                    return newleft + newRight;
                case "-":
                    return newleft - newRight;
                case "/":
                    return newleft / newRight;
                default:
                    throw new IllegalStateException("Unexpected content: " + content);
            }
        }

    }
}
