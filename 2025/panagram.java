import java.util.*;
public class panagram {
    static String str;
    void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String ");
        str=sc.nextLine();
    }
    static boolean ispanagram(){
        String s="abcdefghijklmnopqrstuvwxyz";
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(!str.contains(String.valueOf(ch)) && !str.contains(String.valueOf(Character.toUpperCase(ch)))){
                return false;
            }
        }
        return true;}
        String longer(String str){
            String words[]=str.split(" ");
            String longestword="";
            for(String w:words){
                if(w.length()>longestword.length()){
                    longestword=w;
                }
            }
            return longestword;
        }
        String shorter(String str){
            String words[]=str.split(" ");
            String shortestword=words[0];
            for(String w:words){
                if(w.length()<shortestword.length()){
                    shortestword=w;
                }
            }
            return shortestword;
        }
    
    public static void main(String[] args) {
        panagram obj = new panagram();
        obj.input();
        System.out.println("The string is panagram : "+ispanagram());
        System.out.println("The logest word is:"+obj.longer(str));
        System.out.println("The shortest word is:"+obj.shorter(str));
    }

}
