package com.company;

public class PrintRec {
    public static void main(String[] args) {
            //subsec("abc","");
           // printPermutations("abc","");
            //printBoardPath(0,10,"");
        //System.out.println(countBoardPath(0,10));
        printMazePath(0,0,2,2,"");
        System.out.println(CountMazePath(0,0,2,2));
        printMazePathDiagonal(0,0,2,2,"");
        System.out.println(CountMazePathDiagonal(0,0,2,2));
    }


    public static void subsec(String ques ,String ans){
        if(ques.length()==0){
            System.out.println(ans);
            return;
        }

        char st=ques.charAt(0);
        String ss=ques.substring(1);

        subsec(ss,ans);
        subsec(ss,ans+st);
        return;
    }

    public static void printPermutations(String ques,String ans){
        if(ques.length()==0){
            System.out.println(ans);
            return;
        }



        for (int i = 0; i <ques.length() ; i++) {

            char ch=ques.charAt(i);

            String ss=ques.substring(0,i)+ques.substring(i+1);
            printPermutations(ss,ans+ch);

        }

        return;


    }
    public static void printBoardPath(int cr,int end,String ans ){
        if (cr == end) {
            System.out.println(ans);
            return;
        }
        if (cr > end) {

            return;
        }
        for (int dice = 1; dice <=6 ; dice++) {
            printBoardPath(cr+dice,end,ans+dice);

        }
        return;

    }

    public static int countBoardPath(int cr,int end ){
        if (cr == end) {

            return 1;
        }
        if (cr > end) {

            return 0;
        }
        int count =0;
        for (int dice = 1; dice <=6 ; dice++) {

            count=count +countBoardPath(cr+dice,end);

        }
        return count;

    }
    public static void printMazePath(int cr,int cc,int er,int ec,String ans){
        if(cr==er&&cc==ec){
            System.out.println(ans);
        }
        if(cr>er||cc>ec){
            return;
        }

        printMazePath(cr,cc+1,er,ec,ans+"h");
        printMazePath(cr+1,cc,er,ec,ans+"v");

    }
    public static void printMazePathDiagonal(int cr,int cc,int er,int ec,String ans){
        if(cr==er&&cc==ec){
            System.out.println(ans);
        }
        if(cr>er||cc>ec){
            return;
        }

        printMazePathDiagonal(cr,cc+1,er,ec,ans+"h");
        printMazePathDiagonal(cr+1,cc,er,ec,ans+"v");
        printMazePathDiagonal(cr+1,cc+1,er,ec,ans+"d");
    }
    public static int CountMazePath(int cr,int cc,int er,int ec){
        if(cr==er&&cc==ec){
            return 1;
        }
        if(cr>er||cc>ec){
            return 0;
        }
        int count=0;

        count+=CountMazePath(cr,cc+1,er,ec);
        count+=CountMazePath(cr+1,cc,er,ec);

        return count;
    }
    public static int CountMazePathDiagonal(int cr,int cc,int er,int ec){
        if(cr==er&&cc==ec){
            return 1;
        }
        if(cr>er||cc>ec){
            return 0;
        }
        int count=0;
        count+=CountMazePathDiagonal(cr,cc+1,er,ec);
        count+=CountMazePathDiagonal(cr+1,cc,er,ec);
        count+=CountMazePathDiagonal(cr+1,cc+1,er,ec);
        return count;
    }


}
