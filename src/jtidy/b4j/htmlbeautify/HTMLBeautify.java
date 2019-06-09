package jtidy.b4j.htmlbeautify;

//import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.io.StringWriter;

import org.w3c.tidy.Tidy;

import org.jsoup.Jsoup;
import org.jsoup.parser.Parser;
import org.jsoup.nodes.Document;

@Version(0.3f)
@ShortName("HTMLBeautify")
@DependsOn(values={"jHTMLBeautify_Jtidy","jHTMLBeautify_Jsoup"})
public class HTMLBeautify {
	
	/**
	 * This function clean an XML data using UTF-8 encoding
	 * if an exception is launched the result will be "Error to parse the XML"
	 * Example:<code>
	 * Dim objHTMLBeautify as HTMLBeautify
	 * Dim xml as String = File.ReadString(File.DirApp,"demo.html")
	 * xml = objHTMLBeautify.CleanXML(xml)
	 * Log(xml)</code>
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
	 * Example:<code>
	 * Dim objHTMLBeautify as HTMLBeautify
	 * Dim html as String = File.ReadString(File.DirApp,"demo.html")
	 * html = objHTMLBeautify.CleanHTML(html)
	 * Log(html)</code>
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
	 * Example:<code>
	 * Dim objHTMLBeautify as HTMLBeautify
	 * Dim html as String = File.ReadString(File.DirApp,"demo.html")
	 * html = objHTMLBeautify.CleanHTML2(html,"UTF-8")
	 * Log(html)</code>
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
	 * Example:<code>
	 * Dim objHTMLBeautify as HTMLBeautify
	 * Dim xml as String = File.ReadString(File.DirApp,"demo.html")
	 * xml = objHTMLBeautify.CleanXML2(xml,"UTF-8")
	 * Log(xml)</code>
	 */
	public String CleanXML2(String data, String encoding)  {
		try {
	    Tidy tidy = new Tidy();
	    tidy.setInputEncoding(encoding);
	    tidy.setOutputEncoding(encoding);
	    tidy.setWraplen(Integer.MAX_VALUE);
	    tidy.setPrintBodyOnly(true);
	    tidy.setXmlOut(true);
	    tidy.setSmartIndent(true);
	    ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes(encoding));
	    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	    tidy.parseDOM(inputStream, outputStream);
	    return outputStream.toString(encoding);
		} catch (Exception e) {
			return "Error to parse the XML";
		}
	}
	
	/**
	 * This function parse XML using the Jsoup library
	 * Example:<code>
	 * Dim objHTMLBeautify as HTMLBeautify
	 * Dim xml as String = File.ReadString(File.DirApp,"demo.html")
	 * xml = objHTMLBeautify.FormatXML(xml)
	 * Log(xml)</code>
	 */
	public static String FormatXML(String html){
		try {
	        Document doc = Jsoup.parse(html, "", Parser.xmlParser());
	        return doc.toString();
		} catch (Exception e) {
        	return "Error to parse the XML";
        }	
	}
	
	/**
	 * This function parse HTML body segment using the Jsoup library
	 * Example:<code>
	 * Dim objHTMLBeautify as HTMLBeautify
	 * Dim html as String = File.ReadString(File.DirApp,"demo.html")
	 * html = objHTMLBeautify.FormatHTMLBody(html)
	 * Log(html)</code>
	 */
	public static String FormatHTMLBody(String html){
		try {
	        Document doc = Jsoup.parseBodyFragment(html);
	        return doc.toString();
		} catch (Exception e) {
        	return "Error to parse the HTML Body Fragment";
        }	
	}
	
	/**
	 * This function parse HTML using the Jsoup library
	 * Example:<code>
	 * Dim objHTMLBeautify as HTMLBeautify
	 * Dim xml as String = File.ReadString(File.DirApp,"demo.html")
	 * xml = objHTMLBeautify.FormatXML(xml)
	 * Log(xml)</code>
	 */
	public static String FormatHTML(String html){
		try {
			Document doc = Jsoup.parse(html, "", Parser.htmlParser());
	        return doc.toString();
		} catch (Exception e) {
        	return "Error to parse the HTML";
        }	
	}
	
}
