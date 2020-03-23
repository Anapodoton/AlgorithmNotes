package com.code.array;

public class FindInPartiallySortedMatrix_04 {
    /**
     * 分析：
     * 首先我们选取数组右上角的数字9.由于9大于7，并且9还是第4列的第一个（也是最小的）数字，因此7不可能出现在数字9所在的列，于是只需要分析剩下的3列，
     * 在剩下的矩阵中，位于右上角的数字还是8.同样8大于7，因此8所在的列也可以剔除。
     * 接下来只需分析剩下的两列，由于2小于7，那么要查找的7可能在2的右边和下边。
     * 由于2的右边都已经被剔除，所以只可能出现在2的下边，将2所在的行剔除，只剩下三行两列，再和前面同样的方法查找，当找到7时就结束了。
     * <p>
     *
     * 总结规律如下：首先选取矩阵右上角的数字。如果等于要查找的数字，查找过程结束；
     * 如果大于要查找的数字，则剔除这个数字所在的列，如果小于要查找的数字，则剔除这个数字所在的行。
     * 这样每一步都可以缩减查找范围，直到找到要查找的数字，或者查找失败。
     */

    public static boolean Find(int target, int[][] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int rows = arr.length;
        int columns = arr[0].length;
        // 初始化行列
        int row = 0;
        int column = columns - 1;
        while (row < rows && column >= 0) {
            // 找到元素
            if (arr[row][column] == target) {
                return true;
                // 该值大于target，排除所在列
            } else if (arr[row][column] > target) {
                column--;
                // 否则排除所在行
            } else {
                row++;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        // 测试用例
        int array[][] = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        boolean flag = Find(15, array);
        System.out.println(flag);
    }
}