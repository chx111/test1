package testServerSocket;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
public class ServerTest {
	    private static int port = 8866;
	    private static Socket accept;
	    private static ServerSocket socket;
	    private static BufferedWriter bw;
	    public static int  i = 0;
	    public static void main(String[] args) throws Exception {
	        socket = new ServerSocket(port);
	        System.out.println("服务器开启，等待连接....");
	        while (true){
	        	
	            accept = socket.accept();
	            System.out.println("浏览连接成功");	
	            InputStreamReader r = new InputStreamReader(accept.getInputStream());
	            BufferedReader br = new BufferedReader(r);
	            String readLine = br.readLine();
	            writeHtml(readLine);
	        }
	    }
	    public static void writeHtml(String str) throws Exception{
	    	System.out.println(str);
	    	ArrayList<String> list = new ArrayList<String>();
	    	list.add("Html");
	    	list.add("Html1");
	    	i++;
	    	if(i%2!=0) {
	    		String [] str1 = str.split("/");
	    		String[] str2 = str1[1].split(" ");
	    		System.out.println(str2[0]);
	    		 String className = str2[0];
//	    		 if(str2[0].equals("test")) {
	    		 if(list.contains(className)) {
	   	    	 StringBuilder sb = new StringBuilder();
	   	    	 sb.append("http/1.1 200 ok").append("\n\n");
	   	    	 
	   	    	 Method[] methods=Class.forName("testServerSocket."+className).getMethods();
	   			 String str3 = (String) methods[0].invoke(Class.forName("testServerSocket."+className).newInstance(),null);
	   	    	 
	   	    	 sb.append(str3);
	   	         bw = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
	   	         bw.write(sb.toString());
	   	         bw.flush();
	   	         bw.close();
	   	        
	   	        }
	        }
	    		
	    }
}
