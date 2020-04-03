package JfreeChartTest;
import static org.junit.Assert.*;

import javax.xml.crypto.dsig.keyinfo.KeyValue;

import org.jfree.data.DefaultKeyedValue;
import org.jfree.data.KeyedValue;
import org.jfree.data.KeyedValueComparator;
import org.jfree.data.KeyedValueComparatorType;
import org.jfree.data.Values2D;
import org.jfree.util.SortOrder;
import org.junit.Test;
import org.mockito.Mockito;
public class TestKeyValueComparator {

	public SortOrder order;

	@Test
	public void getTypeTest_Block1() 
	{
		KeyedValueComparator kvc = new KeyedValueComparator(KeyedValueComparatorType.BY_KEY,order.ASCENDING);
		String actual = kvc.getType().toString();
		String expected = "KeyedValueComparatorType.BY_KEY";
		assertEquals (expected,actual);
	}
	@Test
	public void getTypeTest_Block2() 
	{
		KeyedValueComparator kvc = new KeyedValueComparator(KeyedValueComparatorType.BY_VALUE,order.ASCENDING);
		String actual = kvc.getType().toString();
		String expected = "KeyedValueComparatorType.BY_VALUE";
		assertEquals (expected,actual);
	}

	@Test(expected = IllegalArgumentException.class)
	public void  getKeyTest_Block3() {

		KeyedValueComparator kvc = new KeyedValueComparator(null,order.ASCENDING);


	}

	@Test
	public void getOrderTest_Block1() 
	{
		KeyedValueComparator kvc = new KeyedValueComparator(KeyedValueComparatorType.BY_VALUE,order.ASCENDING);
		String actual = kvc.getOrder().toString();
		String expected = "SortOrder.ASCENDING";
		assertEquals (expected,actual);
	}

	@Test
	public void getOrderTest_Block2() 
	{
		KeyedValueComparator kvc = new KeyedValueComparator(KeyedValueComparatorType.BY_VALUE,order.DESCENDING);
		String actual = kvc.getOrder().toString();
		String expected = "SortOrder.DESCENDING";
		assertEquals (expected,actual);
	}

	@Test(expected = IllegalArgumentException.class)
	public void  getOrderTest_Block3() {

		KeyedValueComparator kvc = new KeyedValueComparator(KeyedValueComparatorType.BY_VALUE,null);


	}
	@Test 
	public void compareTest_Block1()
	{
		KeyedValueComparator kvc = new KeyedValueComparator(KeyedValueComparatorType.BY_VALUE,order.DESCENDING);
		Object obj1 = "SS";
		Object obj2 =null;

		int actual = kvc.compare(obj1, obj2);
		int expected = -1;
		assertEquals(expected,actual);
	}

	@Test 
	public void compareTest_Block2()
	{

		KeyedValueComparator kvc = new KeyedValueComparator(KeyedValueComparatorType.BY_VALUE,order.DESCENDING);
		Object obj1 = null;
		Object obj2 ="SS";
		int actual = kvc.compare(obj1, obj2);
		int expected = 1;
		assertEquals(expected,actual);
	}


	@Test 
	public void compareTest_Block3()
	{

		KeyedValueComparator kvc = new KeyedValueComparator(KeyedValueComparatorType.BY_VALUE,order.DESCENDING);
		KeyedValue kv1=Mockito.mock(KeyedValue.class);
		KeyedValue kv2=Mockito.mock(KeyedValue.class);
		Mockito.doReturn(5).when(kv1).getKey();
		Mockito.doReturn(1).when(kv2).getKey();
		Mockito.doReturn(3).when(kv1).getValue();
		Mockito.doReturn(3).when(kv2).getValue();
		int actual = kvc.compare(kv1, kv2);
		int expected = 0;
		//assertEquals(expected,actual);
	}


	@Test 
	public void compareTest_Block4()
	{

		KeyedValueComparator kvc = new KeyedValueComparator(KeyedValueComparatorType.BY_KEY,order.DESCENDING);
		KeyedValue kv1=Mockito.mock(KeyedValue.class);
		KeyedValue kv2=Mockito.mock(KeyedValue.class);
		Mockito.doReturn(5).when(kv1).getKey();
		Mockito.doReturn(5).when(kv2).getKey();
		Mockito.doReturn(2).when(kv1).getValue();
		Mockito.doReturn(3).when(kv2).getValue();
		int actual = kvc.compare(kv1, kv2);
		int expected = 0;
		assertEquals(expected,actual);
	}

	@Test 
	public void compareTest_Block5()
	{

		KeyedValueComparator kvc = new KeyedValueComparator(KeyedValueComparatorType.BY_VALUE,order.DESCENDING);
		KeyedValue kv1=Mockito.mock(KeyedValue.class);
		KeyedValue kv2=Mockito.mock(KeyedValue.class);
		Mockito.doReturn(5).when(kv1).getKey();
		Mockito.doReturn(5).when(kv2).getKey();
		Mockito.doReturn(5).when(kv1).getValue();
		Mockito.doReturn(3).when(kv2).getValue();
		int actual = kvc.compare(kv1, kv2);
		int expected = -1;
		assertEquals(expected,actual);
	}

	@Test 
	public void compareTest_Block6()
	{

		KeyedValueComparator kvc = new KeyedValueComparator(KeyedValueComparatorType.BY_VALUE,order.DESCENDING);
		KeyedValue kv1=Mockito.mock(KeyedValue.class);
		KeyedValue kv2=Mockito.mock(KeyedValue.class);
		Mockito.doReturn(5).when(kv1).getKey();
		Mockito.doReturn(5).when(kv2).getKey();
		Mockito.doReturn(3).when(kv1).getValue();
		Mockito.doReturn(5).when(kv2).getValue();
		int actual = kvc.compare(kv1, kv2);
		int expected = 1;
		assertEquals(expected,actual);
	}

	@Test 
	public void compareTest_Block7()
	{

		KeyedValueComparator kvc = new KeyedValueComparator(KeyedValueComparatorType.BY_KEY,order.DESCENDING);
		KeyedValue kv1=Mockito.mock(KeyedValue.class);
		KeyedValue kv2=Mockito.mock(KeyedValue.class);
		Mockito.doReturn(5).when(kv1).getKey();
		Mockito.doReturn(3).when(kv2).getKey();
		Mockito.doReturn(3).when(kv1).getValue();
		Mockito.doReturn(3).when(kv2).getValue();
		int actual = kvc.compare(kv1, kv2);
		int expected = -1;
		assertEquals(expected,actual);
	}

	@Test 
	public void compareTest_Block8()
	{

		KeyedValueComparator kvc = new KeyedValueComparator(KeyedValueComparatorType.BY_KEY,order.DESCENDING);
		KeyedValue kv1=Mockito.mock(KeyedValue.class);
		KeyedValue kv2=Mockito.mock(KeyedValue.class);
		Mockito.doReturn(3).when(kv1).getKey();
		Mockito.doReturn(5).when(kv2).getKey();
		Mockito.doReturn(3).when(kv1).getValue();
		Mockito.doReturn(3).when(kv2).getValue();
		int actual = kvc.compare(kv1, kv2);
		int expected = 1;
		assertEquals(expected,actual);
	}
	
	@Test 
	public void compareTest_Block9()
	{

		DefaultKeyedValue df=new DefaultKeyedValue(1,(Number)3 );
		DefaultKeyedValue dff=new DefaultKeyedValue(2,(Number)4 );
		 SortOrder order = null;
       KeyedValueComparator kvc = new KeyedValueComparator(KeyedValueComparatorType.BY_VALUE,order.DESCENDING);
		int actual = kvc.compare(df, dff);
		int expected = 1;
		assertEquals(expected,actual);
	}
	
	
	@Test 
	public void compareTest_Block10()
	{

		DefaultKeyedValue df=new DefaultKeyedValue(1,(Number)3 );
		DefaultKeyedValue dff=new DefaultKeyedValue(1,(Number)4 );
		 SortOrder order = null;
       KeyedValueComparator kvc = new KeyedValueComparator(KeyedValueComparatorType.BY_KEY,order.DESCENDING);
		int actual = kvc.compare(df, dff);
		int expected = 0;
		assertEquals(expected,actual);
	}


}
