package com.company;

public class DP {
    private static long Start;


    public static long start(){
        Start=System.currentTimeMillis();
        return Start;
    }
    public static void end(){
        System.out.println((System.currentTimeMillis()-Start));
    }

    public static void main(String[] args) {
        int[] arr=new int[11];


        //System.out.println(feboRec(40));
        //System.out.println(feboDP(40, arr));
        System.out.println(start());
        System.out.println(countBoardPathRec(0,10));
        end();

        System.out.println(start());
        System.out.println(countBoardPathDp(0,10,arr));
        end();
        countBoardPathITR(0,10);
    }


    public static int  feboRec(int num){
        if(num<=1){
            return num;
        }
        return feboRec(num-1)+feboRec(num-2);
    }

    public static int feboDP(int num,int []strg){
        if(num<=1){
            return num;
        }
        if(strg[num]!=0){
            return strg[num];
        }
        strg[num]=feboDP(num-1,strg)+feboDP(num-2,strg);
        return strg[num];

    }
    public static void feboIt(){


    }

    public static int countBoardPathRec(int start,int end){

        if(start==end){
            return 1;
        }
        if(start>end){
            return 0;
        }

        int count=0;
        for (int i = 1; i <=6 ; i++) {
            count+=countBoardPathRec(start+i, end );
        }

        return count;


    }

    public static int countBoardPathDp(int start,int end,int[] strg){

        if(start==end){
            return 1;
        }
        if(start>end){
            return 0;
        }

        if(strg[start]!=0){
            return strg[start];
        }
        int count=0;
        for (int i = 1; i <=6 ; i++) {
            count+=countBoardPathDp(start+i, end,strg );
        }

        strg[start]=count;
        return count;


    }

    public static void countBoardPathITR(int cr,int End){
        int [] arr=new int[End+1];
        //seed
        arr[End]=1;
        arr[End-1]=1;


        for (int i = End-2; i >=cr; i--) {

            for (int j = i+1; j <arr.length && j-i<=6 ; j++) {
                arr[i]+=arr[j];
            }

        }
        System.out.println(arr[0]);
    }

}
