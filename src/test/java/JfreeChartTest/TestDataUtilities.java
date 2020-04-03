package JfreeChartTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.junit.Test;
import org.mockito.Mockito;

public class TestDataUtilities {
	DataUtilities DU ;
	@Test
	public void test1equal() {
		DataUtilities du=new DataUtilities() {
		};
		double[][] b = new double[4][2];
		Boolean acaul=du.equal(null,b);	
		assertFalse(acaul);

	}


	@Test
	public void test2equal() {
		DataUtilities du=new DataUtilities() {
		};
		double[][] a = new double[4][2];
		Boolean acaul=du.equal(a,null);	
		assertFalse(acaul);

	}

	@Test
	public void test3equal() {
		DataUtilities du=new DataUtilities() {
		};
		double[][] a = new double[4][2];
		double[][] b = new double[3][2];
		Boolean acaul=du.equal(a,b);	
		assertFalse(acaul);

	}

	@Test
	public void test4equal() {
		DataUtilities du=new DataUtilities() {
		};
		double[][] a = new double[2][2];
		double[][] b = new double[2][2];
		a[0][0]=1;
		a[0][1]=2;
		b[0][0]=1;
		b[0][1]=3;
		boolean acaul=true;
		for(int i=0;i<2;++i) {
			for(int j=0;j<2;++j) {
				if(a[i][j]!=b[i][j]) {
					acaul=false;
					break;
				} 
			}
			if(acaul==false) {
				break;
			}
		}

		assertFalse(acaul);

	}
	@Test
	public void test5equal() {
		DataUtilities du=new DataUtilities() {
		};
		double[][] a = new double[2][2];
		double[][] b = new double[2][2];
		a[0][0]=1;
		a[0][1]=2;
		b[0][0]=1;
		b[0][1]=2;
		boolean acaul=true;
		for(int i=0;i<2;++i) {
			for(int j=0;j<2;++j) {
				if(a[i][j]!=b[i][j]) {
					acaul=false;

				} 
			}

		}

		assertTrue(acaul);

	}

	@Test(expected=IllegalArgumentException.class)
	public void testb1createarray2d() {
		DataUtilities du=new DataUtilities() {
		};
		du.createNumberArray2D(null);
	}



	@Test
	public void testb2createarray2d() {
		DataUtilities du=new DataUtilities() {
		};
		double[][] a = new double[2][2];
		a[0][0]=1.1;
		a[0][1]=1.2;
		a[1][0]=2.2;
		a[1][1]=2.2;
		Number actuall[][]=du.createNumberArray2D(a);
		for(int i=0;i<2;++i) {
			for(int j=0;j<2;++j) {
				Number expected=a[i][j];
				assertEquals(expected, actuall[i][j]);
			}

		}
	}

	@Test(expected=IllegalArgumentException.class)
	public void test1calculateColumnTotal() {
		DataUtilities du=new DataUtilities() {
		};
		du.calculateColumnTotal(null, 3);
	}


	@Test
	public void test2calculateColumnTotal() {
		DataUtilities du=new DataUtilities() {
		};
		Values2D data=Mockito.mock(Values2D.class);
		Mockito.doReturn(2).when(data).getRowCount();
		Mockito.doReturn(1).when(data).getValue(0,2);
		Mockito.doReturn(2).when(data).getValue(1,2);
		double actual=du.calculateColumnTotal(data, 2);
		double expected=3.0;
		assertEquals((int)expected, (int)actual);

	}

	@Test
	public void test3calculateColumnTotal() {
		DataUtilities du=new DataUtilities() {
		};
		Values2D data=Mockito.mock(Values2D.class);
		Mockito.doReturn(2).when(data).getRowCount();
		Mockito.doReturn(null).when(data).getValue(0,2);
		Mockito.doReturn(null).when(data).getValue(1,2);
		double actual=du.calculateColumnTotal(data, 2);
		double expected=0;
		assertEquals((int)expected, (int)actual);

	}


	@Test
	public void test1calculateColumnTotalwithvalidkey() {
		DataUtilities du=new DataUtilities() {
		};
		Values2D data=Mockito.mock(Values2D.class);
		Mockito.doReturn(0).when(data).getRowCount();
		Mockito.doReturn(1).when(data).getValue(0,2);
		Mockito.doReturn(2).when(data).getValue(1,2);
		int valid[]=new int[2];
		valid[0]=1;
		valid[1]=2;
		double actual=du.calculateColumnTotal(data, 2,valid);
		double expected=0;
		assertEquals((int)expected, (int)actual);

	}
	@Test
	public void test2calculateColumnTotalwithvalidkey() {
		DataUtilities du=new DataUtilities() {
		};
		Values2D data=Mockito.mock(Values2D.class);
		Mockito.doReturn(3).when(data).getRowCount();
		Mockito.doReturn(1).when(data).getValue(1,2);
		Mockito.doReturn(2).when(data).getValue(2,2);
		int valid[]=new int[2];
		valid[0]=1;
		valid[1]=2;
		double actual=du.calculateColumnTotal(data, 2,valid);
		double expected=3;
		assertEquals((int)expected, (int)actual);

	}

	@Test
	public void test3calculateColumnTotalwithvalidkey() {
		DataUtilities du=new DataUtilities() {
		};
		Values2D data=Mockito.mock(Values2D.class);
		Mockito.doReturn(3).when(data).getRowCount();
		Mockito.doReturn(null).when(data).getValue(1,2);
		Mockito.doReturn(null).when(data).getValue(2,2);
		int valid[]=new int[2];
		valid[0]=1;
		valid[1]=2;
		double actual=du.calculateColumnTotal(data, 2,valid);
		double expected=0;
		assertEquals((int)expected, (int)actual);

	}

	@Test(expected=IllegalArgumentException.class)
	public void test1getCumulativePercentages() {
		DataUtilities du=new DataUtilities() {
		};
		du.getCumulativePercentages(null);

	}


	@Test
	public void test2getCumulativePercentages() {

		KeyedValues data=Mockito.mock(KeyedValues.class);
		Mockito.doReturn(2).when(data).getItemCount();
		Mockito.doReturn(1).when(data).getValue(0);
		Mockito.doReturn(2).when(data).getValue(1);
		Mockito.doReturn(0).when(data).getKey(0);
		Mockito.doReturn(1).when(data).getKey(1);
		KeyedValues kv=DataUtilities.getCumulativePercentages(data);
		Number actual1=kv.getValue(0);
		Number actual2=kv.getValue(1);
		Number expected1=0.3333333333333333;
		Number expected2=1.0;
		assertEquals(expected1, actual1);
		assertEquals(expected2, actual2);

	}


	@Test
	public void test3getCumulativePercentages() {

		KeyedValues data=Mockito.mock(KeyedValues.class);
		Mockito.doReturn(2).when(data).getItemCount();
		Mockito.doReturn(null).when(data).getValue(0);
		Mockito.doReturn(null).when(data).getValue(1);
		Mockito.doReturn(0).when(data).getKey(0);
		Mockito.doReturn(1).when(data).getKey(1);
		KeyedValues kv=DataUtilities.getCumulativePercentages(data);
		Number actual1=kv.getValue(0);
		Number actual2=kv.getValue(1);
		System.out.println();
		String expected1="NaN";
		String  expected2="NaN";
		assertEquals(expected1, actual2.toString());
		assertEquals(expected2, actual1.toString());

	}


	@Test
	public void Block1_Clone() {
		double[][] Expected=new double[2][1];
		Expected[0][0] = 5.0;
		Expected[1][0] = 5.0;

		double [][] Actual = DU.clone(Expected);

		assertEquals(Expected, Actual);

	}


	@Test(expected = IllegalArgumentException.class)
	public void Block2_Clone() {
		double[][] Expected=null;
		DU.clone(Expected);
	}


	@Test
	public void Block3_Clone() {
		double[][] Expected=new double[2][1];

		Expected[1][0] = 5.0;

		double [][] Actual = DU.clone(Expected);

		assertEquals(Expected, Actual);

	}

	@Test
	public void Block1_createNumberArray() {
		Number[] Expected=new Number[2];
		Expected[0] = 5.0;
		Expected[1] = 5.0;
		double[] Data=new double[2];
		Data[0] = 5.0;
		Data[1] = 5.0;
		Number[] Actual = DU.createNumberArray(Data);

		assertEquals(Expected, Actual);
	}


	@Test(expected = IllegalArgumentException.class)
	public void  Block2_createNumberArray() {

		double[] Data=null;

		DU.createNumberArray(Data);
	}

	@Test
	public void test1calculateRowTotalwithvalidkey() {
		// DataUtilities du;
		Values2D data=Mockito.mock(Values2D.class);
		Mockito.doReturn(3).when(data).getColumnCount();
		Mockito.doReturn(null).when(data).getValue(2,1);
		Mockito.doReturn(null).when(data).getValue(2,2);
		int valid[]=new int[2];
		valid[0]=1;
		valid[1]=2;
		double actual=DU.calculateRowTotal(data, 2,valid);
		double expected=0;
		assertEquals((int)expected, (int)actual);

	}

	@Test
	public void test2calculateRowTotalwithvalidkey() {
		// DataUtilities du;
		Values2D data1=Mockito.mock(Values2D.class);
		Mockito.doReturn(3).when(data1).getColumnCount();
		Mockito.doReturn(1).when(data1).getValue(2,1);
		Mockito.doReturn(2).when(data1).getValue(2,2);
		int valid[]=new int[2];
		valid[0]=1;
		valid[1]=2;
		double actual=DU.calculateRowTotal(data1, 2,valid);

		double expected=3.0;
		assertEquals((int)expected, (int)actual);

	}

	@Test(expected = IllegalArgumentException.class)
	public void  test3calculateRowTotalwithvalidkey() {
		Values2D data1=null;
		int[] Data=null;

		DU.calculateRowTotal(data1, 2,Data);
	}


	@Test
	public void test1calculaterowTotal() {

		Values2D data=Mockito.mock(Values2D.class);
		Mockito.doReturn(2).when(data).getRowCount();
		Mockito.doReturn(null).when(data).getValue(2,0);
		Mockito.doReturn(null).when(data).getValue(2,1);
		double actual= DU.calculateRowTotal(data, 2);
		double expected=0;
		assertEquals((int)expected, (int)actual);

	}

	@Test
	public void test2calculaterowTotal() {

		Values2D data=Mockito.mock(Values2D.class);
		Mockito.doReturn(3).when(data).getColumnCount();
		Mockito.doReturn(1).when(data).getValue(2,0);
		Mockito.doReturn(2).when(data).getValue(2,1);
		double actual= DU.calculateRowTotal(data, 2);
		double expected=3;
		System.out.println(actual);
		assertEquals((int)expected, (int)actual);

	}
	@Test(expected = IllegalArgumentException.class)
	public void  test3calculateRowTotal() {
		Values2D data1=null;


		DU.calculateRowTotal(data1, 2);
	}

}
