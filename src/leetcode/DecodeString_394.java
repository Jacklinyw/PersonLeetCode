package leetcode;

import java.util.Scanner;
import java.util.Stack;

/** Created with IntelliJ IDEA. User: Linyw Date: 2021/8/29 Time: 23:26 Description: 字符串解码 */
public class DecodeString_394 {
  /*
         给定一个经过编码的字符串，返回它解码后的字符串。
     编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
     你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
     此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4]的输入。
  */
  // 示例 1：
  // 输入：s = "3[a]2[bc]"
  // 输出："aaabcbc"
  // 示例 2：
  // 输入：s = "3[a2[c]]"
  // 输出："accaccacc"
  // 示例 3：
  // 输入：s = "2[abc]3[cd]ef"
  // 输出："abcabccdcdcdef"
  // 示例 4：
  // 输入：s = "abc3[cd]xyz"
  // 输出："abccdcdcdxyz"
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String input = "";
    if (sc.hasNextLine()) {
      input = sc.nextLine();
    }
    System.out.println(decodeString(input));
  }

  private static String decodeString(String s) {
    StringBuilder sb = new StringBuilder();
    Stack<Integer> nums = new Stack<>();
    Stack<String> str = new Stack<>();
    int n = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
        n = n * 10 + s.charAt(i) - '0';
      } else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z'
          || s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
        sb.append(s.charAt(i));
      } else if (s.charAt(i) == '[') {
        nums.push(n);
        n = 0;
        str.push(sb.toString());
        sb = new StringBuilder();
      } else {
        StringBuilder tmp = new StringBuilder();
        for (int j = 0; j < nums.peek(); j++) {
          tmp.append(sb);
        }
        sb = new StringBuilder(str.pop() + tmp);
        nums.pop();
      }
    }
    return sb.toString();
  }
}
