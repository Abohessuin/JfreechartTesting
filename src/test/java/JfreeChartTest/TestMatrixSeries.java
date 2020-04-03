package JfreeChartTest;
import static org.junit.Assert.assertEquals;

import org.jfree.data.xy.MatrixSeries;
import org.junit.Test;
import org.mockito.Mockito;

public class TestMatrixSeries {

	@Test
	public void Block1_Get() {

		MatrixSeries MS = new MatrixSeries("Hassan", 1, 1);
		MS.update(0, 0, 10);
		double Expected = 10.0;
		double Actual = MS.get(0, 0);
		assertEquals((int)	Expected, (int)Actual);

	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void  Block2_Get() {
		MatrixSeries MS = new MatrixSeries("Hassan", 1, 1);
		MS.update(0, 0, 10);

		MS.get(-1, 0);

	}

	@Test
	public void Block1_getItem() {
		MatrixSeries MS_ = new MatrixSeries("Hassan", 1, 1);

		MatrixSeries MS = Mockito.spy(MS_);

		MS.update(0, 0, 10);

		Mockito.doReturn(0).when(MS).getItemRow(0);
		Mockito.doReturn(0).when(MS).getItemColumn(0);
		Mockito.doReturn(10.0).when(MS).get(0,0);


		Number Expected = 10.0;
		Number Actual = MS.getItem(0);



	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void  Block2_getItem() {
		MatrixSeries MS = new MatrixSeries("Hassan", 1, 1);



		MS.update(0, 0, 10);

		MS.getItem(2);

	}


	@Test
	public void Block1_getItemcount() {
		MatrixSeries MS_ = new MatrixSeries("Hassan", 1, 1);

		MatrixSeries MS = Mockito.spy(MS_);

		Mockito.doReturn(1).when(MS).getRowCount();
		Mockito.doReturn(1).when(MS).getColumnsCount();

		int Expected = 1;
		int Actual = MS.getItemCount();
		assertEquals(Expected, Actual);
	}


	@Test
	public void Block1_getRowCount() {
		MatrixSeries MS_ = new MatrixSeries("Hassan", 1, 1);

		MatrixSeries MS = Mockito.spy(MS_);



		int Expected = 1;
		int Actual = MS.getRowCount();
		assertEquals(Expected, Actual);
	}


	@Test
	public void Block1_zeroall() {
		MatrixSeries MS_ = new MatrixSeries("Hassan", 1, 1);

		MatrixSeries MS = Mockito.spy(MS_);
		Mockito.doReturn(1).when(MS).getRowCount();
		Mockito.doReturn(1).when(MS).getColumnsCount();

		MS.zeroAll();

		double Expected = 0.0;
		double Actual = MS.get(0, 0);
		assertEquals((int)	Expected, (int)Actual);

	}


	@Test
	public void Block1_getColumnsCount() {
		MatrixSeries MS_ = new MatrixSeries("Hassan", 1, 1);

		MatrixSeries MS = Mockito.spy(MS_);



		int Expected = 1;
		int Actual = MS.getColumnsCount();
		assertEquals(Expected, Actual);
	}


	@Test
	public void Block2_getColumnsCount() {
		MatrixSeries MS_ = new MatrixSeries("Hassan", 1, 0);

		MatrixSeries MS = Mockito.spy(MS_);



		int Expected = 0;
		int Actual = MS.getColumnsCount();
		assertEquals(Expected, Actual);
	}






	@Test
	public void Block1_getItemColumn() {
		MatrixSeries MS_ = new MatrixSeries("Hassan", 1, 1);

		MatrixSeries MS = Mockito.spy(MS_);

		Mockito.doReturn(1).when(MS).getColumnsCount();


		int Expected = 0;
		int Actual = MS.getItemColumn(0);
		assertEquals(Expected, Actual);
	}


	@Test
	public void Block2_getItemColumn() {
		MatrixSeries MS_ = new MatrixSeries("Hassan", 2, 2);

		MatrixSeries MS = Mockito.spy(MS_);

		Mockito.doReturn(2).when(MS).getColumnsCount();


		int Expected = 1;
		int Actual = MS.getItemColumn(1);
		assertEquals(Expected, Actual);
	}



	@Test
	public void Block4_getItemColumn() {
		MatrixSeries MS_ = new MatrixSeries("Hassan", 4, 4);

		MatrixSeries MS = Mockito.spy(MS_);

		Mockito.doReturn(4).when(MS).getColumnsCount();


		int Expected = 2;
		int Actual = MS.getItemColumn(2);

		assertEquals(Expected, Actual);
	}


	@Test
	public void Block1_update() {
		MatrixSeries MS = new MatrixSeries("Hassan", 4, 4);


		MS.update(0, 0, 10.0);



		double Expected = 10.0;
		double Actual = MS.get(0,0);

		assertEquals((int)Expected,(int) Actual);
	}


	@Test
	public void Block2_update() {
		MatrixSeries MS = new MatrixSeries("Hassan", 4, 4);


		MS.update(3, 3, 10.0);



		double Expected = 10.0;
		double Actual = MS.get(3,3);

		assertEquals((int)Expected,(int) Actual);
	}


	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void  Block3_update() {
		MatrixSeries MS_ = new MatrixSeries("Hassan", 1, 1);

		MS_.update(0, 0, 10.0);

		MS_.get(-1,0);
	}


	@Test
	public void Block4_update() {
		MatrixSeries MS = new MatrixSeries("Hassan", 4, 4);


		MS.update(2, 2, 10.0);



		double Expected = 10.0;
		double Actual = MS.get(2,2);

		assertEquals((int)Expected,(int) Actual);
	}

	


}



