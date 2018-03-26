import java.util.HashMap;
import java.util.Map;



public class CharCountDemo {
	
	public static void main(String[] args) {
		String str = "AAAABBBBCCCCDDDD";
		char[] str1 = str.toCharArray();
		Map<Character,Integer> m = new HashMap<Character,Integer>();
		for(char c : str1){
			if(m.keySet().contains(c)){
				m.put(c, (Integer)m.get(c)+1);
			}else{
				m.put(c, 1);
			}
		}
		System.out.println(m);
	}
}
