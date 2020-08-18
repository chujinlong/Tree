import java.util.Stack;

/**
 * @Class:
 * @Author:chujinlong
 * @Description:
 * @Data:2020/8/14
 */
public class StackTest {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("栈顶元素：" + stack.peek());
        System.out.println("栈：" + stack.empty() + stack);
        System.out.println(stack.search(1));
    }
}
