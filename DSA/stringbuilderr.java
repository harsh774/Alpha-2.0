package DSA;

public class stringbuilderr {

    public static String toUpperCase(String str){
        StringBuilder sb = new StringBuilder("");

        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        
        for(int i =1; i<str.length(); i++){
            if(str.charAt(i)==' ' && i<str.length()-1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    //String to compress
    public static String compress(String str){
        String newStr = "";
        for(int i = 0; i<str.length(); i++){
            Integer count = 1;
            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)){
                count++;
                i++;
            }
            newStr += str.charAt(i);
            if(count>1){
                newStr += count.toString();
            }
        }
        return newStr;
    }
    //Compress string using stringbuilder
    public static int compressSS(String str){
        StringBuilder sb = new StringBuilder("");

        for(int i =0; i<str.length(); i++){
            Integer count = 1;
            while(i<str.length()-1 && str.charAt(i)==(str.charAt(i+1))){
                count++;
                i++;
            }
            sb.append(str.charAt(i));
            if(count>1){
                sb.append(count);
            }
        }
        return sb.length();
    }

    public static void main(String[] args) {
        
        // String str = "aaabbbcccccddeefffff";
        // System.out.println(compressSS(str));
        String str = "ShraddhaDidi", str1 = "Apnacollege", str2 = "ShraddhaDidi";
        System.out.println(str.equals(str1)+ " "+str.equals(str2));
    }    
}
