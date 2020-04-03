package JfreeChartTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.KeyedValue;
import org.jfree.data.KeyedValues;
import org.jfree.data.UnknownKeyException;
import org.jfree.util.SortOrder;
import org.junit.Test;
import org.mockito.Mockito;



public class TestDefaultKeyedVlues {

/*
	@Test
	public void testB1BoolenEquel() {
		DefaultKeyedValues dkv=new DefaultKeyedValues();
		Boolean acctual=dkv.equals(dkv);

		assertTrue(acctual);

	}
*/
	@Test
	public void testB2BoolenEquel() {
		DefaultKeyedValues dkv=new DefaultKeyedValues();
		DataUtilities du=new DataUtilities() {
		};
		Boolean acctual=dkv.equals(du);
		assertFalse(acctual);

	}

	@Test
	public void testB6BoolenEquel() {
		DefaultKeyedValues dkv=new DefaultKeyedValues();
		DefaultKeyedValues ndkv=new DefaultKeyedValues();
		Number xx=5;
		dkv.setValue(1,xx);
		ndkv.setValue(1, xx);
		Boolean acctual=dkv.equals(ndkv);
		assertTrue(acctual);

	}

	@Test
	public void testB3BoolenEquel() {
		DefaultKeyedValues dkv=new DefaultKeyedValues();
		DefaultKeyedValues ndkv=new DefaultKeyedValues();
		Number xx=5;
		dkv.setValue(1,xx);
		Boolean acctual=dkv.equals(ndkv);
		assertFalse(acctual);

	}
/*
	@Test
	public void testB4BoolenEquel() {
		DefaultKeyedValues dkv=new DefaultKeyedValues();
		DefaultKeyedValues ndkv=new DefaultKeyedValues();
		Number xx=5;
		dkv.setValue(1,xx);
		ndkv.setValue(2,xx);
		Boolean acctual=dkv.equals(ndkv);
		assertFalse(acctual);

	}

	@Test
	public void testB5BoolenEquel() {
		DefaultKeyedValues dkv=new DefaultKeyedValues();
		DefaultKeyedValues ndkv=new DefaultKeyedValues();
		Number xx=5;
		Number xxx=4;
		dkv.setValue(1,xx);
		ndkv.setValue(1,xxx);
		Boolean acctual=dkv.equals(ndkv);
		assertFalse(acctual);

	}
*/
	@Test
	public void testB2hashcode() {
		DefaultKeyedValues dkv=new DefaultKeyedValues();
		Number x=2;
		dkv.setValue(1,x);
		int acctual=dkv.hashCode();
		System.out.println(acctual);
		int expected=32;
		assertEquals(expected, acctual);

	}

	@Test
	public void testB1hashcode() {
		DefaultKeyedValues dkv=new DefaultKeyedValues();
		int acctual=dkv.hashCode();
		int expected=1;
		assertEquals(expected, acctual);

	}



	@Test
	public void testB1getIndex() {
		DefaultKeyedValues dkv=new DefaultKeyedValues();
		Number x=2;
		dkv.setValue(1,x);
		x=3;
		dkv.setValue(2,x);
		Number acctual=dkv.getIndex(1);
		int expected=0;
		assertEquals(expected, acctual);

	}



	@Test
	public void testB2getIndex() {
		DefaultKeyedValues dkv=new DefaultKeyedValues();
		Number x=2;
		dkv.setValue(1,x);
		x=3;
		dkv.setValue(2,x);
		Number acctual=dkv.getIndex(2);
		int expected=dkv.getItemCount()-1;
		assertEquals(expected, acctual);

	}

	@Test
	public void testB3getIndex() {
		DefaultKeyedValues dkv=new DefaultKeyedValues();
		Number x=2;
		dkv.setValue(1,x);
		x=3;
		dkv.setValue(2,x);
		x=4;
		dkv.setValue(3,x);
		Number acctual=dkv.getIndex(2);
		int expected=1;
		assertEquals(expected, acctual);

	}

	@Test
	public void testB4getIndex() {
		DefaultKeyedValues dkv=new DefaultKeyedValues();
		Number x=2;
		dkv.setValue(1,x);
		x=3;
		dkv.setValue(2,x);
		x=4;
		dkv.setValue(3,x);
		Number acctual=dkv.getIndex(-1);
		int expected=-1;
		assertEquals(expected, acctual);

	}


	@Test
	public void testB1getkey() {
		DefaultKeyedValues dkv=new DefaultKeyedValues();
		Number x=2;
		dkv.setValue(1,x);
		x=3;
		dkv.setValue(2,x);
		Comparable acctual=dkv.getKey(0);
		int expected=1;
		assertEquals(expected, acctual);

	}





	@Test
	public void testB2getkey() {
		DefaultKeyedValues dkv=new DefaultKeyedValues();
		Number x=2;
		dkv.setValue(1,x);
		x=3;
		dkv.setValue(2,x);
		x=4;
		dkv.setValue(3,x);
		x=5;
		dkv.setValue(4,x);
		Comparable acctual=dkv.getKey(3);
		Comparable expected=4;
		assertEquals(expected, acctual);

	}



	@Test(expected=IndexOutOfBoundsException.class)
	public void testB4getkey() {
		DefaultKeyedValues dkv=new DefaultKeyedValues();
		Number x=2;
		dkv.setValue(1,x);
		x=3;
		dkv.setValue(2,x);
		x=4;
		dkv.setValue(3,x);
		x=5;
		dkv.setValue(4,x);
		dkv.getKey(-1);



	}



	@Test
	public void testB3getkey() {
		DefaultKeyedValues dkv=new DefaultKeyedValues();
		Number x=2;
		dkv.setValue(1,x);
		x=3;
		dkv.setValue(2,x);
		x=4;
		dkv.setValue(3,x);
		x=5;
		dkv.setValue(4,x);
		Comparable acctual=dkv.getKey(2);
		Comparable expected=3;
		assertEquals(expected, acctual);

	}


	@Test
	public void testB1getvalue() {
		DefaultKeyedValues dkv=new DefaultKeyedValues();
		Number x=2;
		dkv.setValue(1,x);
		x=3;
		dkv.setValue(2,x);
		x=4;
		dkv.setValue(3,x);
		x=5;
		dkv.setValue(4,x);
		Number acctual=dkv.getValue(0);
		Number expected=2;
		assertEquals(expected, acctual);

	}



	@Test
	public void testB2getvalue() {
		DefaultKeyedValues dkv=new DefaultKeyedValues();
		Number x=2;
		dkv.setValue(1,x);
		x=3;
		dkv.setValue(2,x);
		x=4;
		dkv.setValue(3,x);
		x=5;
		dkv.setValue(4,x);
		Number acctual=dkv.getValue(dkv.getItemCount()-1);
		Number expected=5;
		assertEquals(expected, acctual);

	}


	@Test
	public void testB3getvalue() {
		DefaultKeyedValues dkv=new DefaultKeyedValues();
		Number x=2;
		dkv.setValue(1,x);
		x=3;
		dkv.setValue(2,x);
		x=4;
		dkv.setValue(3,x);
		x=5;
		dkv.setValue(4,x);
		Number acctual=dkv.getValue(2);
		Number expected=4;
		assertEquals(expected, acctual);

	}




	@Test
	public void testB1getkeys(){
		DefaultKeyedValues dkv=new DefaultKeyedValues();
		Number x=2;
		dkv.setValue(1,x);
		x=3;
		dkv.setValue(2,x);
		x=4;
		dkv.setValue(3,x);
		x=5;
		dkv.setValue(4,x);
		ArrayList acctual=(ArrayList) dkv.getKeys();
		ArrayList excpected=new ArrayList();
		excpected.add(1);
		excpected.add(2);
		excpected.add(3);
		excpected.add(4);
		assertEquals(excpected.size(), acctual.size());
		for(int i=0;i<acctual.size();++i) {
			assertEquals(excpected.get(i), acctual.get(i));
		}



	}


	@Test
	public void testB2getkeys(){
		//notworked
		DefaultKeyedValues dkv=new DefaultKeyedValues();

		ArrayList acctual=(ArrayList) dkv.getKeys();
		ArrayList excpected=new ArrayList();
		assertEquals(excpected.size(), acctual.size());
		for(int i=0;i<acctual.size();++i) {
			assertEquals(excpected.get(i), acctual.get(i));
		}



	}

	@Test
	public void testB3getkeys(){

		DefaultKeyedValues dkv=new DefaultKeyedValues();

		ArrayList acctual=(ArrayList) dkv.getKeys();
		ArrayList excpected=new ArrayList();
		assertEquals(excpected.size(), acctual.size());
		for(int i=0;i<acctual.size();++i) {
			assertEquals(excpected.get(i), acctual.get(i));
		}



	}



	@Test(expected=IllegalArgumentException.class)
	public void testB1removevaluewithkey(){

		DefaultKeyedValues dkv=new DefaultKeyedValues();

		dkv.removeValue(null);


	}




	@Test(expected=UnknownKeyException.class)
	public void testB2removevaluewithkey(){

		DefaultKeyedValues dkv=new DefaultKeyedValues();
		Number x=2;
		dkv.setValue(1,x);
		Comparable k=3;
		dkv.removeValue(k);


	}





	public void testB3removevaluewithkey(){

        DefaultKeyedValues dkv=new DefaultKeyedValues();

        Number x=2;
        dkv.setValue(1,x);
        Comparable k=1;
        DefaultKeyedValues dkvs = Mockito.spy(dkv);

         Mockito.doReturn(0).when(dkvs).getIndex(k);

        dkv.removeValue(k);

        assertEquals(0,dkv.getItemCount());


    }

	@Test
	public void testclear(){
		DefaultKeyedValues dkv=new DefaultKeyedValues();
		Number x=2;
		dkv.setValue(1,x);
		x=3;
		dkv.setValue(2,x);
		x=4;
		dkv.setValue(3,x);
		x=5;
		dkv.setValue(4,x);
		dkv.clear();
		int acctual=dkv.getItemCount();
		int excpected=0;
		assertEquals(excpected, acctual);
	}


	@Test
	public void testb1sortorderbykey(){
		DefaultKeyedValues dkv=new DefaultKeyedValues();
		Number x=2;
		dkv.setValue(1,x);
		x=3;
		dkv.setValue(2,x);
		x=4;
		dkv.setValue(3,x);
		x=5;
		dkv.setValue(4,x);
		SortOrder order = null;
		dkv.sortByKeys(order.DESCENDING);
		ArrayList acctual=(ArrayList) dkv.getKeys();
		ArrayList excpected=new ArrayList();
		excpected.add(4);
		excpected.add(3);
		excpected.add(2);
		excpected.add(1);
		for(int i=0;i<acctual.size();++i) {
			assertEquals(excpected.get(i), acctual.get(i));
		}
	}

	@Test
	public void testb2sortorderbykey(){
		DefaultKeyedValues dkv=new DefaultKeyedValues();
		Number x=2;
		dkv.setValue(4,x);
		x=3;
		dkv.setValue(3,x);
		x=4;
		dkv.setValue(2,x);
		x=5;
		dkv.setValue(1,x);
		SortOrder order = null;
		dkv.sortByKeys(order.ASCENDING);
		ArrayList acctual=(ArrayList) dkv.getKeys();
		ArrayList excpected=new ArrayList();
		excpected.add(1);
		excpected.add(2);
		excpected.add(3);
		excpected.add(4);
		for(int i=0;i<acctual.size();++i) {
			assertEquals(excpected.get(i), acctual.get(i));
		}
	}

	@Test(expected=IllegalArgumentException.class)
	public void testb3sortorderbykey(){
		DefaultKeyedValues dkv=new DefaultKeyedValues();
		Number x=2;
		dkv.setValue(4,x);
		x=3;
		dkv.setValue(3,x);
		x=4;
		dkv.setValue(2,x);
		x=5;
		dkv.setValue(1,x);
		SortOrder order = null;
		dkv.sortByKeys(order);

	}

	@Test
	public void testb1sortorderbyvalue(){
		DefaultKeyedValues dkv=new DefaultKeyedValues();
		Number x=2;
		dkv.setValue(1,x);
		x=3;
		dkv.setValue(2,x);
		x=4;
		dkv.setValue(3,x);
		x=5;
		dkv.setValue(4,x);
		SortOrder order = null;
		dkv.sortByValues(order.DESCENDING);
		ArrayList acctual=(ArrayList) dkv.getKeys();
		ArrayList excpected=new ArrayList();
		excpected.add(5);
		excpected.add(4);
		excpected.add(3);
		excpected.add(2);

		for(int i=0;i<acctual.size();++i) {
			assertEquals(excpected.get(i), dkv.getValue((Comparable)acctual.get(i)));
		}
	}

	@Test
	public void testb2sortorderbyvalue(){
		DefaultKeyedValues dkv=new DefaultKeyedValues();
		Number x=5;
		dkv.setValue(1,x);
		x=4;
		dkv.setValue(2,x);
		x=3;
		dkv.setValue(3,x);
		x=2;
		dkv.setValue(4,x);
		SortOrder order = null;
		dkv.sortByValues(order.ASCENDING);
		ArrayList acctual=(ArrayList) dkv.getKeys();
		ArrayList excpected=new ArrayList();
		excpected.add(2);
		excpected.add(3);
		excpected.add(4);
		excpected.add(5);

		for(int i=0;i<acctual.size();++i) {
			assertEquals(excpected.get(i), dkv.getValue((Comparable)acctual.get(i)));
		}
	}

	@Test(expected=IllegalArgumentException.class)
	public void testb3sortorderbyvalue(){
		DefaultKeyedValues dkv=new DefaultKeyedValues();
		Number x=2;
		dkv.setValue(4,x);
		x=3;
		dkv.setValue(3,x);
		x=4;
		dkv.setValue(2,x);
		x=5;
		dkv.setValue(1,x);
		SortOrder order = null;
		dkv.sortByValues(order);

	}

	@Test(expected=IllegalArgumentException.class)
	public void test1insertvalue(){
		DefaultKeyedValues temp=new DefaultKeyedValues();
		DefaultKeyedValues dkv=Mockito.spy(temp);
		Mockito.doReturn(2).when(dkv).getItemCount();  
		Number x=2;
		dkv.setValue(1,x);
		x=3;
		dkv.setValue(2,x);
		dkv.insertValue(-1, 1, (Number)3);



	}

	@Test(expected=IllegalArgumentException.class)
	public void Itest1insertvalue(){
		DefaultKeyedValues dkv=new DefaultKeyedValues();
		Number x=2;
		dkv.setValue(1,x);
		x=3;
		dkv.setValue(2,x);
		dkv.insertValue(-1, 1, (Number)3);



	}
	@Test(expected=IllegalArgumentException.class)
	public void test11insertvalue(){
		DefaultKeyedValues temp=new DefaultKeyedValues();
		DefaultKeyedValues dkv=Mockito.spy(temp);
		Mockito.doReturn(2).when(dkv).getItemCount(); 
		Number x=2;
		dkv.setValue(1,x);
		x=3;
		dkv.setValue(2,x);
		dkv.insertValue(3, 1, (Number)3);


	}
	@Test(expected=IllegalArgumentException.class)
	public void Itest11insertvalue(){
		DefaultKeyedValues dkv=new DefaultKeyedValues();

		Number x=2;
		dkv.setValue(1,x);
		x=3;
		dkv.setValue(2,x);
		dkv.insertValue(3, 1, (Number)3);


	}

	@Test(expected=IllegalArgumentException.class)
	public void test2insertvalue(){
		DefaultKeyedValues temp=new DefaultKeyedValues();
		DefaultKeyedValues dkv=Mockito.spy(temp);
		Mockito.doReturn(2).when(dkv).getItemCount(); 
		Number x=2;
		dkv.setValue(1,x);
		x=3;
		dkv.setValue(2,x);
		dkv.insertValue(1, null, (Number)3);


	}

	@Test(expected=IllegalArgumentException.class)
	public void Itest2insertvalue(){
		DefaultKeyedValues dkv=new DefaultKeyedValues();
		Number x=2;
		dkv.setValue(1,x);
		x=3;
		dkv.setValue(2,x);
		dkv.insertValue(1, null, (Number)3);


	}

	@Test
	public void test3insertvalue(){
		DefaultKeyedValues temp=new DefaultKeyedValues();
		DefaultKeyedValues dkv=Mockito.spy(temp);
		Number x=2;
		dkv.setValue(1,x);
		x=3;
		dkv.setValue(2,x);
		Mockito.doReturn(2).when(dkv).getItemCount(); 
		Mockito.doReturn(1).when(dkv).getIndex(2);

		dkv.insertValue(1, 2, (Number)4);
		int expected=4;
		Number actaul=dkv.getValue((Comparable)2);

		assertEquals((Number)expected, actaul);


	}



	@Test
	public void Itest3insertvalue(){
		DefaultKeyedValues temp=new DefaultKeyedValues();
		DefaultKeyedValues dkv=Mockito.spy(temp);
		Number x=2;
		dkv.setValue(1,x);
		x=3;
		dkv.setValue(2,x);
		dkv.insertValue(1, 2, (Number)4);
		Mockito.doReturn(2).when(dkv).getItemCount(); 
		Mockito.doReturn(1).when(dkv).getIndex(2);

		int expected=4;
		Number actaul=dkv.getValue((Comparable)2);

		assertEquals((Number)expected, actaul);


	}



	@Test
	public void test4insertvalue(){
		DefaultKeyedValues temp=new DefaultKeyedValues();
		DefaultKeyedValues dkv=Mockito.spy(temp);
		Number x=2;
		dkv.setValue(1,x);
		x=3;
		dkv.setValue(2,x);
		Mockito.doReturn(2).when(dkv).getItemCount(); 
		Mockito.doReturn(-1).when(dkv).getIndex(3);
		dkv.insertValue(1, 3, (Number)4);
		int expected=1,actaul = 0;
		ArrayList arr=(ArrayList) dkv.getKeys();
		for(int i=0;i<dkv.getItemCount();++i) {
			if(dkv.getValue(i).equals(4)) {
				actaul=i;
				break;


			}
		}

		assertEquals(expected, actaul);




	}


	@Test
	public void Itest4insertvalue(){
		DefaultKeyedValues dkv=new DefaultKeyedValues();
		Number x=2;
		dkv.setValue(1,x);
		x=3;
		dkv.setValue(2,x);
		dkv.insertValue(1, 3, (Number)4);
		int expected=1,actaul = 0;
		ArrayList arr=(ArrayList) dkv.getKeys();
		for(int i=0;i<dkv.getItemCount();++i) {
			if(dkv.getValue(i).equals(4)) {
				actaul=i;
				break;


			}
		}

		assertEquals(expected, actaul);




	}



	@Test
	public void test5insertvalue(){
		DefaultKeyedValues temp=new DefaultKeyedValues();
		DefaultKeyedValues dkv=Mockito.spy(temp);
		Number x=2;
		dkv.setValue(1,x);
		x=3;
		dkv.setValue(2,x);
		x=5;
		dkv.setValue(3,x);
		Mockito.doReturn(3).when(dkv).getItemCount(); 
		Mockito.doReturn(0).when(dkv).getIndex(1);
		dkv.insertValue(1, 1, (Number)4);
		int expected=1,actaul = 0;
		ArrayList arr=(ArrayList) dkv.getKeys();
		for(int i=0;i<dkv.getItemCount();++i) {
			if(dkv.getValue(i).equals(4)) {
				actaul=i;
				break;


			}
		}

		assertEquals(expected, actaul);




	}






}
