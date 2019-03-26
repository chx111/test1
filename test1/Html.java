package testServerSocket;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Html {
	public String create() {
		String str = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n" + 
				"<html>\r\n" + 
				"  <head>\r\n" + 
				"    <title>My JSP 'index.jsp' starting page</title>\r\n" + 
				"  </head>\r\n" + 
				"  <body>\r\n" + 
				"     <br>\r\n" + 
				"    测试1现在的时间是： \r\n" + 
				"  </body>\r\n" + 
				"</html>\r\n" 
				;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String time=simpleDateFormat.format(new Date().getTime());
	    str = str + time;
		return str;
	}
}
