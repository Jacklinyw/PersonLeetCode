package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Created with IntelliJ IDEA. User: Linyw Date: 2021/8/30 Time: 21:52 Description: 查找和替换模式 */
public class FindAndReplacePattern_890 {

  /*
     你有一个单词列表 words 和一个模式  pattern，你想知道 words 中的哪些单词与模式匹配。
   如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。
   （回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
   返回 words 中与给定模式匹配的单词列表。
   你可以按任何顺序返回答案。
  */
  // 示例：
  // 输入：words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
  // 输出：["mee","aqq"]
  // 解释：
  // "mee" 与模式匹配，因为存在排列 {a -> m, b -> e, ...}。
  // "ccc" 与模式不匹配，因为 {a -> c, b -> c, ...} 不是排列。
  // 因为 a 和 b 映射到同一个字母。
  // 提示：
  // 1 <= words.length <= 50
  // 1 <= pattern.length = words[i].length <= 20

  public static void main(String[] args) {
    String[] words = {"abca", "deqe", "meem", "aqqa", "dkdk", "ccce"};
    String pattern = "abba";
    List<String> res = findAndReplacePattern(words, pattern);
    System.out.println(res);
  }

  /**
   * 固定格式的字符串做对比 思路： 1、通过char做映射 2、转成数字做映射 3、字符串之间互相做映射
   *
   * @param words words
   * @param pattern pattern
   * @return result
   */
  public static List<String> findAndReplacePattern(String[] words, String pattern) {
    List<String> res = new ArrayList<>();
    for (String w : words) {
      if (match1(w, pattern)) {
        res.add(w);
      }
    }
    return res;
  }

  private static boolean match1(String word, String pattern) {
    Map<Character, Character> map = new HashMap<>();
    for (int i = 0; i < word.length(); i++) {
      char w = word.charAt(i);
      char p = pattern.charAt(i);
      if (!map.containsKey(w)) {
        map.put(w, p);
      } else if (map.get(w) != p) {
        return false;
      }
    }

    boolean [] boo = new boolean[26];
    for (Character c : map.values()) {
      if (boo[c - 'a']) {
        return false;
      } else {
        boo[c - 'a'] = true;
      }
    }
    return true;
  }

  private static boolean match(String w, String pattern) {
    Map<Character, Integer> word = new HashMap<>();
    Map<Character, Integer> pat = new HashMap<>();
    for (int i = 0; i < pattern.length(); i++) {
      if (!pat.containsKey(pattern.charAt(i))) {
        pat.put(pattern.charAt(i), i);
      }
      if (!word.containsKey(w.charAt(i))) {
        word.put(w.charAt(i), i);
      }
      if (pat.containsKey(pattern.charAt(i)) && word.containsKey(w.charAt(i))) {
        if (!pat.get(pattern.charAt(i)).equals(word.get(w.charAt(i)))) {
          return false;
        }
      } else {
        return false;
      }
    }
    return true;
  }
}
