import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class IteratorDemo {
	public static void main(String[] args) {
		List al = new ArrayList();
		List ll = new LinkedList();
		List vt = new Vector();
		
		al.add("1");
		al.add("2");
		al.add("3");
		
		for(Iterator it = al.iterator();it.hasNext();){
			System.out.println(it.next());
		}//Type1
		
		System.out.println("--------------------------------------");
		
		for(Object it : al){
			System.out.println(it);
		}//Type2
	}
}
