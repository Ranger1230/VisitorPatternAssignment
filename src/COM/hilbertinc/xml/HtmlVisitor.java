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
		xml.write("<!DOCTYPE HTML>\n");
		xml.write("<Html lang=\"en\"n");
		xml.write("<body>\n");
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
		xml.write("</body>\n");
		xml.write("</Html>\n");
		return;
	}

	@Override
	public void processDocumentType(DocumentType dtd) throws Exception {
		
	}

	@Override
	public void processElementEpilog(Element node) throws Exception {
		Writer xml = getWriter();
		xml.write(getTagClose());
		xml.write("\n");
		indentLess();
		return;	
	}

	@Override
	public void processElementProlog(Element node) throws Exception {
		Writer xml = getWriter();
		indentMore();
		xml.write(getTagOpen());
		xml.write("\n");
		xml.write(node.getNodeName());
		xml.write("\n");
		return;	
	}

	@Override
	public void processText(Text text) throws Exception {
		Writer xml = getWriter();
		xml.write(HDOMUtil.trim(text));
		xml.write("\n");
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
		for (int i = 0; i < this._indent*3; ++i)
			buffer.append(' ');
		buffer.append("<H"+this._indent+">");
		return buffer.toString();
	}
	
	private String getTagClose(){
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < this._indent*3; ++i)
			buffer.append(' ');
		buffer.append("</H"+this._indent+">");
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
