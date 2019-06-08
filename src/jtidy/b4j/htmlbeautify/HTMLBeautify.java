package jtidy.b4j.htmlbeautify;

//import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import org.w3c.tidy.Tidy;

@Version(1.0f)
@ShortName("HTMLBeautify")
@DependsOn(values={"jHTMLBeautify_Jtidy"})
public class HTMLBeautify {
	
	/**
	 * This function clean an XML data using UTF-8 encoding
	 * if an exception is launched the result will be "Error to parse the XML"
	 */
	public String CleanXML(String data){
		try {
	    Tidy tidy = new Tidy();
	    tidy.setInputEncoding("UTF-8");
	    tidy.setOutputEncoding("UTF-8");
	    tidy.setWraplen(Integer.MAX_VALUE);
	    tidy.setPrintBodyOnly(true);
	    tidy.setXmlOut(true);
	    tidy.setSmartIndent(true);
	    ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes("UTF-8"));
	    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	    tidy.parseDOM(inputStream, outputStream);
	    return outputStream.toString("UTF-8");
		} catch (Exception e) {
			return "Error to parse the XML";
		}
	}
	
	/**
	 * This function clean an HTML data using UTF-8 encoding,
	 * if an exception is launched the result will be "Error to parse the HTML"
	 */
	public String CleanHTML(String data)  {
		try {
	    Tidy tidy = new Tidy();
	    tidy.setInputEncoding("UTF-8");
	    tidy.setOutputEncoding("UTF-8");
	    tidy.setXHTML(true);
	    ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes("UTF-8"));
	    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	    tidy.parseDOM(inputStream, outputStream);
	    return outputStream.toString("UTF-8");
		} catch (Exception e) {
			return "Error to parse the HTML";
		}
	}
	
	/**
	 * This function clean an HTML data using an encoding passed by value,
	 * if an exception is launched the result will be "Error to parse the HTML"
	 */
	public String CleanHTML2(String data, String encoding)  {
		try {
	    Tidy tidy = new Tidy();
	    tidy.setInputEncoding(encoding);
	    tidy.setOutputEncoding(encoding);
	    tidy.setXHTML(true);
	    ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes(encoding));
	    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	    tidy.parseDOM(inputStream, outputStream);
	    return outputStream.toString(encoding);
		} catch (Exception e) {
			return "Error to parse the HTML";
		}
	}
	
	/**
	 * This function clean an XML data using an encoding passed by value
	 * if an exception is launched the result will be "Error to parse the XML"
	 */
	public String CleanXML2(String data, String encoding)  {
		try {
	    Tidy tidy = new Tidy();
	    tidy.setInputEncoding("UTF-8");
	    tidy.setOutputEncoding("UTF-8");
	    tidy.setWraplen(Integer.MAX_VALUE);
	    tidy.setPrintBodyOnly(true);
	    tidy.setXmlOut(true);
	    tidy.setSmartIndent(true);
	    ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes("UTF-8"));
	    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	    tidy.parseDOM(inputStream, outputStream);
	    return outputStream.toString("UTF-8");
		} catch (Exception e) {
			return "Error to parse the XML";
		}
	}
}
