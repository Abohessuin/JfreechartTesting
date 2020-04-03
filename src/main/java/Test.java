

import org.jfree.data.DefaultKeyedValue;
import org.jfree.data.KeyedValueComparator;
import org.jfree.data.KeyedValueComparatorType;
import org.jfree.util.SortOrder;
public class Test {

	public static void main(String[] args) throws CloneNotSupportedException {
		
	
		DefaultKeyedValue df=new DefaultKeyedValue(1,(Number)3 );
		DefaultKeyedValue dff=new DefaultKeyedValue(2,(Number)4 );
		 SortOrder order = null;
       KeyedValueComparator kvc = new KeyedValueComparator(KeyedValueComparatorType.BY_VALUE,order.DESCENDING);
       System.out.println(kvc.compare(df, dff));
		
	
		
        
        
       
        
		
		
		
	}

}
