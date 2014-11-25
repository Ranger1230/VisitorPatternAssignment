package COM.hilbertinc.xml;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class HtmlVisitor implements HDOMVisitor {
	
	private Writer _writer;
	private int _indent;
	
	public HtmlVisitor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean continueTraversal() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void processDocumentEpilog(org.w3c.dom.Document document)
	throws Exception 
	{
		Writer xml = getWriter();
		xml.write("<Html lang=\"en\"n");
		xml.write("<body><br>");
		return;
	}

	private Writer getWriter() {
		if(this._writer == null){
			this._writer = new PrintWriter(System.out);
		}
		return this._writer;
	}

	@Override
	public void processDocumentProlog(org.w3c.dom.Document document)
	throws Exception
	{
		Writer xml = getWriter();
		xml.write("</body><br>");
		xml.write("</Html><br>");
		return;
	}

	@Override
	public void processDocumentType(DocumentType dtd) throws Exception {
		Writer xml = getWriter();
		xml.write("<!DOCTYPE HTML><br>");
		return;
	}

	@Override
	public void processElementEpilog(Element node) throws Exception {
		Writer xml = getWriter();
		xml.write(getTagOpen());
		xml.write("&lt;&sol;");//add a '<' and an '\' in html
		xml.write(node.getNodeName());
		xml.write("&gt;");//add a '>' in html
		xml.write("<br>");
		xml.write(getTagClose());
		indentLess();
		return;	
	}

	@Override
	public void processElementProlog(Element node) throws Exception {
		Writer xml = getWriter();
		indentMore();
		xml.write(getTagOpen());
		xml.write("&lt;");//add a '<' in html
		xml.write(node.getNodeName());
		xml.write("&gt;");//add a '>' in html
		xml.write("<br>");
		xml.write(getTagClose());
		return;	
	}

	@Override
	public void processText(Text text) throws Exception {
		Writer xml = getWriter();
		if(text.toString() != ""){
			indentMore();
			xml.write(getTagOpen());
			xml.write(HDOMUtil.trim(text));
			xml.write(getTagClose());
			indentLess();
		}
		return;
	}
	
	public void flush()
	throws IOException
	{
		getWriter().flush();
		return;
	}
	
	private String getTagOpen() 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("<H"+(this._indent)+">\n");
		buffer.append("<div style=\"margin-left:"+(this._indent*3)+"em\">");
		return buffer.toString();
	}
	
	private String getTagClose(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("</div>");
		buffer.append("</H"+(this._indent)+">\n");
		return buffer.toString();
	}

	private void indentLess() 
	{
		this._indent -= 1;
	}

	private void indentMore() 
	{
		this._indent += 1;
	}
}
