package com.code.recursive_cycle;

/**
 * 打印从1到最大的n位数：使用数组表示大数
 * 题目描述：
 * 输入数字n,按顺序打印出从1到最大的n位十进制数，比如输入3,则打印出1,2,3一直到最大的3位数即999
 *
 * 模拟大数的运算
 */

public class Print1ToMaxOfNDigits_17 {
    // 使用数组实现对数进行+1操作
    public static boolean increment(int[] number) {
        // 最高位产生进位标志
        boolean isOverFlow = false;
        // 进位位
        int carry = 0;
        for(int i=number.length-1;i>=0;--i){
            int sum=number[i]+carry;
            //处理个位数，每次加1
            if(i==number.length-1)
                sum++;
            if(sum>=10){
                //处理最高位的情况,如果第一个字符产生了进位，用来跳出循环
                if(i == 0){
                    isOverFlow=true;
                }
                sum-=10;
                carry=1;
                number[i]=sum;
            }else {
                number[i]++;
                break;
            }
        }
        return isOverFlow;
    }
    // 打印数组中表示的数，如果数组中表示的数字位数小于n，则不打印前面的0
    public static void print(int[] number) {
        // 标记：判断是否可以开始打印
        boolean isBeginning = false;
        for (int i = 0; i < number.length; i++) {
            if (!isBeginning && number[i] != 0) {
                isBeginning = true;
            }
            if (isBeginning)
                System.out.print(number[i]);
        }
        System.out.println();
    }
    //打印数
    public static void printNumber(StringBuffer sb){
        boolean flag = false;

        for(int i = 0; i < sb.length(); i++){
            if(!flag && sb.charAt(i) != '0'){
                flag = true;
            }
            if(flag){
                System.out.print(sb.charAt(i));
            }
        }
        if(flag)
            System.out.println();
    }

    //打印从1到n位的最大数
    public static void Print1ToMaxOfNDigits(int n){
        if(n <= 0)
            return ;

        //初始化数字（用StringBuffer表示）
        StringBuffer sb = new StringBuffer(n);
        for(int i = 0; i < n; i++){
            sb.append('0');
        }

        print1ToMaxOfNDigits_Recursely(sb, n, 0);
    }

    private static void print1ToMaxOfNDigits_Recursely(StringBuffer sb, int n, int index) {
        if(index==n){
            printNumber(sb);
            return;
        }
        for(int i=0;i<n;i++){
            sb.setCharAt(index,(char)(i+'0'));
            print1ToMaxOfNDigits_Recursely(sb,n,index+1);
        }
    }

    public static void main(String[] args) {
        Print1ToMaxOfNDigits(3);
    }
}
