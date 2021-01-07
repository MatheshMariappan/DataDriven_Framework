package com.util;

import java.util.ArrayList;

public class TestUtil {

	static Xls_Reader reader;
	static int rowCount;

	public static ArrayList<Object[]> getDataFromExcel()
	{
		ArrayList<Object[]> mydata = new ArrayList<Object[]>();
		try
		{
			reader = new Xls_Reader("/Users/hcl/Documents/Testspace/DataDrivenFramwork/src/test/java/com/testdata/TestData.xlsx");
			rowCount = reader.getRowCount("RegData");

			for(int rowNum=2;rowNum<=rowCount;rowNum++)
			{
				String FirstName=reader.getCellData("RegData", 0, rowNum);
				String LastName=reader.getCellData("RegData", 1, rowNum);
				String Email_Address=reader.getCellData("RegData", 2, rowNum);
				String Password=reader.getCellData("RegData", 3, rowNum);
				Object ob[] = {FirstName,LastName,Email_Address,Password};
				mydata.add(ob);
			}
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}

		return mydata;
	}

}
