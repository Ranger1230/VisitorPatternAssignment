package COM.hilbertinc.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class ReflectiveHTMLVisitor extends AbstractReflectiveVisitor {

	public ReflectiveHTMLVisitor() {
		super();
	}
	
	public boolean visitDocument(Document document){
		System.out.print("<h1>Document name: " + document.getNodeName() + ", Document value: " + document.getNodeValue() + "<h1>\n");
		return true;
	}
	
	public boolean visitElement(Element element){
		System.out.print("<h2>Element name: " + element.getNodeName() + ", Element value: " + element.getNodeValue() + "<h2>\n");
		return true;
	}
	
	public boolean visitText(Text text){
		System.out.print("<h3>Text name: " + text.getNodeName() + ", Text value: " + text.getNodeValue() + "<h3>\n");
		return true;
	}

}
