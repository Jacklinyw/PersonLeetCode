import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Linyw
 * Date: 2021/5/10
 * Time: 21:53
 * Description:
 * 20. 有效的括号:给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 1、左括号必须用相同类型的右括号闭合。
 * 2、左括号必须以正确的顺序闭合。
 */
public class ValidParentheses_20 {
    /**
     * 示例 1：    输入：s = "()"    输出：true
     * 示例2：    输入：s = "()[]{}"    输出：true
     * 示例3：    输入：s = "(]"    输出：false
     * 示例4：    输入：s = "([)]"    输出：false
     * 示例5：    输入：s = "{[]}"    输出：true
     */

    /*
     * 1、报错输入："(("，未判断运行结束栈是否为空
     * 2、报错输入："){"，未判断栈在pop时是否为空。
     * 3、报错输入"(){}}{"，未判断栈在pop时是否为空。
     */

    public boolean isValid(String s) {
        Stack<Character> charStack = new Stack<>();
        char[] chars = s.toCharArray();
        if (chars.length % 2 == 1) {
          return false;
        }
      for (char aChar : chars) {
        if (aChar == '(' || aChar == '[' || aChar == '{') {
          charStack.push(aChar);
        } else {
          if (charStack.empty() || !checkParentheses(charStack.pop(), aChar)) {
            return false;
          }
        }
      }
      return charStack.empty();
    }

  private boolean checkParentheses(char left, char right) {
      if (left == '(') {
        return right == ')';
      }
      if (left == '[') {
        return right == ']';
      }
      if (left == '{') {
        return right == '}';
      }
      return false;
  }

  // TODO:网上贴的大神答案
  public boolean isValid1(String s) {
    Stack<Character>stack = new Stack<>();
    for(char c: s.toCharArray()){
      if(c=='(')stack.push(')');
      else if(c=='[')stack.push(']');
      else if(c=='{')stack.push('}');
      else if(stack.isEmpty()||c!=stack.pop())return false;
    }
    return stack.isEmpty();
  }
}