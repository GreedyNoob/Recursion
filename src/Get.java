import java.util.ArrayList;

public class Get {

    public static void main(String[] args) {
        System.out.println("Recursion Get");
        // System.out.println(gss("abc"));
        System.out.println(getPermutations("abc"));
        System.out.println(boardpath(0,10).size());
        System.out.println(mazePath(0,0,2,2));

    }

    public static ArrayList<String > gss(String str){
        if(str.length()==0){
            ArrayList<String >BaseCondition=new ArrayList<>();
            BaseCondition.add("");
            return BaseCondition;
        }

        ArrayList<String > result=new ArrayList<>();
        ArrayList<String > recResult=new ArrayList<>();
        char s=str.charAt(0);
        String st=str.substring(1);
        //System.out.println(st);
        recResult=gss(st);

        for (int i = 0; i <recResult.size() ; i++) {
            result.add(recResult.get(i));
            result.add(s+recResult.get(i));
            //System.out.println(i);



        }
        return result;



    }


    public static ArrayList<String > getPermutations(String str){
        if(str.length()==0){
            ArrayList<String> baseresut=new ArrayList<>();
            baseresut.add("");
            return baseresut;
        }
        char ch =str.charAt(0);
        String ss=str.substring(1);
        ArrayList<String> resut=new ArrayList<>();
        ArrayList<String>recResult=getPermutations(ss);
        for (String  s:recResult
             ) {
            for (int i = 0; i <=s.length() ; i++) {
                String val=s.substring(0,i)+ch+s.substring(i);
                //System.out.println(val+"yo");
                resut.add(val);
            }

            
        }
        return resut;
    }


    public static ArrayList<String> boardpath(int curr,int end){
        if(curr==end){
            ArrayList<String >Positive=new ArrayList<>();
            Positive.add("\n");
            return Positive;
        }
        if(curr>end){
            ArrayList<String >Negativetive=new ArrayList<>();
            return Negativetive;
        }

        ArrayList<String >result=new ArrayList<>();
        for (int dice = 1; dice <=6 ; dice++) {
            ArrayList<String>recResult=boardpath(dice+curr,10);

            for (String s:recResult
                 ) {
                result.add(dice+s);

            }
        }
        return result;

    }

    public static ArrayList<String > mazePath(int cr,int cc,int er,int ec){
        if(cr==er && cc==ec){
            ArrayList<String >baseResult =new ArrayList<>();
            baseResult.add("");
            return baseResult;
        }
        if(cr>er || cc>ec){
            ArrayList<String >baseResult =new ArrayList<>();
            return baseResult;
        }

        ArrayList<String >result =new ArrayList<>();

        ArrayList<String >hRecResult=mazePath(cr,cc+1,er,ec);
        for (String s:hRecResult
             ) {
            result.add("h"+s);

        }

        ArrayList<String >rRecResult=mazePath(cr+1,cc,er,ec);
        for (String s:rRecResult
        ) {
            result.add("v"+s);

        }

        ArrayList<String >dRecResult=mazePath(cr+1,cc+1,er,ec);
        for (String s:dRecResult
        ) {
            result.add("d"+s);

        }

        return result;
    }
}
