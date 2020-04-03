package JfreeChartTest;
import static org.junit.Assert.*;


import org.junit.Test;
import org.jfree.data.DefaultKeyedValue;

public class TestDefualtkeyvalue {

	//returned is same value with original value

	@Test
	public void getKeyTest_Block1() 

	{
		DefaultKeyedValue defaultkeyedvalue = new DefaultKeyedValue (6,7);
		Number Expected=6;
		Number Actual = (Number) defaultkeyedvalue.getKey();
		assertEquals(Expected, Actual);
	} 

	@Test(expected = IllegalArgumentException.class)
	public void  getKeyTest_Block2() {

		DefaultKeyedValue defaultkeyedvalue = new DefaultKeyedValue (null,7);
		Number Expected=null;
		Number Actual = (Number) defaultkeyedvalue.getKey();
		assertEquals(Expected, Actual);
	}

	@Test
	public void getValueTest_Block1() 

	{
		DefaultKeyedValue defaultkeyedvalue = new DefaultKeyedValue (6,7);
		Number Expected=7;
		Number Actual = defaultkeyedvalue.getValue();
		assertEquals(Expected, Actual);
	} 

 
	@Test
	public void setValueTest_Block1() {
		DefaultKeyedValue defaultkeyedvalue = new DefaultKeyedValue (6,5);
		Number Expected=5;
		defaultkeyedvalue.setValue(Expected);
		Number Actual = defaultkeyedvalue.getValue();
		assertEquals(Expected, Actual);
	}

	@Test
	public void setValueTest_Block2() {
		DefaultKeyedValue defaultkeyedvalue = new DefaultKeyedValue (6,null);
		Number Expected=null;
		defaultkeyedvalue.setValue(Expected);
		Number Actual = defaultkeyedvalue.getValue();
		assertEquals(Expected, Actual);
	}

	//Parameter Null
	@Test
	public void equals_Block1()
	{
		DefaultKeyedValue defaultkeyedvalue = new DefaultKeyedValue (6,6);
		boolean Actual = defaultkeyedvalue.equals(null);
		assertFalse (Actual);

	} 

	//Keys Aren't Equal
	@Test
	public void equals_Block2()
	{
		DefaultKeyedValue defaultkeyedvalue = new DefaultKeyedValue (6,6);
		DefaultKeyedValue obj = new DefaultKeyedValue (3,6);
		boolean Actual = defaultkeyedvalue.equals(obj);
		assertFalse (Actual);

	} 

	//Values are Not Equal
	@Test
	public void equals_Block3()
	{
		DefaultKeyedValue defaultkeyedvalue = new DefaultKeyedValue (6,6);
		DefaultKeyedValue obj = new DefaultKeyedValue (6,3);
		boolean Actual = defaultkeyedvalue.equals(obj);
		assertFalse (Actual);

	} 

	//Keys&Values aren't equal
	@Test
	public void equals_Block4()
	{
		DefaultKeyedValue defaultkeyedvalue = new DefaultKeyedValue (7,6);
		DefaultKeyedValue obj = new DefaultKeyedValue (6,3);
		boolean Actual = defaultkeyedvalue.equals(obj);
		assertFalse (Actual);

	} 

	//Equal
	@Test
	public void equals_Block5()
	{
		DefaultKeyedValue defaultkeyedvalue = new DefaultKeyedValue (6,6);
		DefaultKeyedValue obj = new DefaultKeyedValue (6,6);
		boolean Actual = defaultkeyedvalue.equals(obj);
		assertTrue (Actual);

	}

	//Not Instance Of DefaultKeyedValue
	@Test
	public void equals_Block6()
	{
		DefaultKeyedValue defaultkeyedvalue = new DefaultKeyedValue (6,6);
		Object obj = new Object();
		boolean Actual = defaultkeyedvalue.equals(obj);
		assertFalse (Actual);

	} 



	@Test
	public void hashCode_Block1() {
		int Expected=181;
		DefaultKeyedValue DKV= new DefaultKeyedValue(6,7); 
		//System.out.println(DKV.hashCode());
		int Actual = DKV.hashCode();
		assertEquals(Expected, Actual);
	}


	@Test
	public void hashCode_Block2() {
		int Expected=58; 
		DefaultKeyedValue DK= new DefaultKeyedValue(2,null);
		int Actual = DK.hashCode();
		assertEquals(Expected, Actual);
	}



	//checking clone output is equal to actual string
	@Test
	public void cloneTest() throws CloneNotSupportedException
	{
		DefaultKeyedValue defaultkeyedvalue = new DefaultKeyedValue (4,6);
		String Actual =("(4, 6)");

		String Expected= defaultkeyedvalue.clone().toString();		
		assertEquals (Actual,Expected);

	} 

	@Test
	public void toString_Block1() {
		DefaultKeyedValue defaultkeyedvalue = new DefaultKeyedValue (4,6);
		String Expected = "(4, 6)";

		String Actual = defaultkeyedvalue.toString();
		assertEquals(Expected, Actual);
	}

	@Test(expected = NullPointerException.class)
	public void toString_Block2() {
		DefaultKeyedValue defaultkeyedvalue = new DefaultKeyedValue (4,null);
		String Expected = "(4, 6)";

		String Actual = defaultkeyedvalue.toString();
		assertEquals(Expected, Actual);
	}

}
