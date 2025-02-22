package GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GenericFileUtility {
	public String getDataFromPrpperties(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("./TestData/common.properties");
		Properties pObj=new Properties();
		pObj.load(fis);		
		String data=pObj.getProperty(key);
		return data;		
	}
}
