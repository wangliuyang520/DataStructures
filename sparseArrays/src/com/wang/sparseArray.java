package com.wang;

import javax.xml.crypto.Data;
/**
 * 实现稀疏数组的压缩存储和解压
 */


public class sparseArray {
    public static void main(String[] args) {
        //创建一个11*11的二维数组
        //0:代表没有棋子，1代表黑子，2代表白子
        int chessArray[][] = new int[11][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 1;
        System.out.println("原始的二维数组");
        for (int[] row : chessArray) {
            for (int date: row) {
                System.out.print(date+"\t");
            }
            System.out.println();
        }
        //实现稀疏数组的压缩
        //1.先遍历原始数组得到非0的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(chessArray[i][j] !=0) {
                    sum++;
                }
            }
        }
        //2.创建对应的稀疏数组
        int[][] chessArray2 = new int[sum+1][3];
        //3.给稀疏数组赋值
        chessArray2[0][0] = 11;
        chessArray2[0][1] = 11;
        chessArray2[0][2] = sum;
        int count = 0;//记录遍历da
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(chessArray[i][j] !=0) {
                    count++;
                    chessArray2[count][0] = i;
                    chessArray2[count][1] = j;
                    chessArray2[count][2] = chessArray[i][j];
                }
            }
        }
        //遍历打印稀疏数组
        for (int[] row : chessArray2) {
            for (int date: row) {
                System.out.print(date+"\t");
            }
            System.out.println();
        }

        /*
        实现稀疏数组的还原
         */
        //1.通过稀疏数组第一行的行列数实例化一个原二维数组
        int[][] chessArray3 = new int[chessArray2[0][0]][chessArray2[0][1]];
        //2.遍历稀疏数组的每一行(从第二行正式存储元素位置开始)，得到原数组的非0元素位置以及所在位置
        for (int i = 1 ; i < chessArray2.length; i++){
            chessArray3[chessArray2[i][0]][chessArray2[i][1]] = chessArray2[i][2];
        }
        //遍历打印还原后数组
        for (int[] row : chessArray3) {
            for (int date: row) {
                System.out.print(date+"\t");
            }
            System.out.println();
        }
    }
}
