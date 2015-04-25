import java.util.*;

public class arraylistp{
    public static void main(String Args[]){
    
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for(int i = 0;i<10;i++){
            list.add(i);      
        }
        list.remove(0);
        list.add(27);
        list.remove(0);
        
        for(int i=0;i<list.size();i++){
           System.out.println(list.get(i));
        }
    
    }
}