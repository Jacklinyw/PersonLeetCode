package deBangCode;

import java.util.Scanner;

/** Created with IntelliJ IDEA.
 *  User: Linyw
 *  Date: 2021/8/17
 *  Time: 23:23
 *  Description: 德科机试第一题
 *  注意记忆互质
 */
public class topic_01 {
  //        如果三个正整数A B C ,A²+B²=C²则为勾股数
  //        如果ABC之间两两互质，即A与B A与C B与C均互质没有公约数，
  //        则称其为勾股数元组。
  //        请求出给定n m 范围内所有的勾股数元组
  //        输入描述
  //          起始范围 1<n<10000    n<m<10000
  //        输出目描述
  //           abc 保证a<b<c输出格式  a b c
  //           多组勾股数元组 按照a升序b升序 c升序的排序方式输出。
  //           给定范围内，找不到勾股数元组时，输出  Na
  // 案例
  //  输入
  //   1
  //   20
  //  输出
  //   3 4 5
  //   5 12 13
  //   8 15 17

  //  输入
  //    5
  //    10
  //  输出
  //    Na
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int count = 0;
    try {
      int n = sc.nextInt();
      int m = sc.nextInt();
      for (int i = n; i < m; i++) {
        for (int j = n + 1; j < m; j++) {
          for (int k = n + 2; k < m; k++) {
            if (i < j
                && j < k
                && k * k == i * i + j * j
                && huZhi(i, j) == 1
                && huZhi(j, k) == 1
                && huZhi(i, k) == 1) {
              System.out.println(i + " " + j + " " + k);
              count++;
            }
          }
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (count == 0) {
        System.out.println("Na");
      }
      sc.close();
    }
  }

  private static int huZhi(int a, int b) {
    if (a == 0 || b == 0) {
      return 1;
    }
    if (a % b == 0) {
      return b;
    } else {
      return huZhi(b, a % b);
    }
  }
}
