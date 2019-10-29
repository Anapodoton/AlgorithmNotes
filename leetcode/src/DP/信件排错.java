package DP;

/**
 * Created by 周杰伦 on 2018/4/4.
 * 信件错排

 题目描述：有 N 个 信 和 信封，它们被打乱，求错误装信的方式数量。

 定义一个数组 dp 存储错误方式数量，dp[i] 表示前 i 个信和信封的错误方式数量。
 假设第 i 个信装到第 j 个信封里面，而第 j 个信装到第 k 个信封里面。
 根据 i 和 k 是否相等，有两种情况：
 ① i==k，交换 i 和 k 的信后，它们的信和信封在正确的位置，但是其余 i-2 封信有 dp[i-2] 种错误装信的方式。
 由于 j 有 i-1 种取值，因此共有 (i-1)*dp[i-2] 种错误装信方式。
 ② i != k，交换 i 和 j 的信后，第 i 个信和信封在正确的位置，其余 i-1 封信有 dp[i-1] 种错误装信方式。
 由于 j 有 i-1 种取值，因此共有 (n-1)*dp[i-1] 种错误装信方式。
 综上所述，错误装信数量方式数量为：



 dp[N] 即为所求。

 和上楼梯问题一样，dp[i] 只与 dp[i-1] 和 dp[i-2] 有关，因此也可以只用两个变量来存储 dp[i-1] 和 dp[i-2]。


 */
public class 信件排错 {
}
