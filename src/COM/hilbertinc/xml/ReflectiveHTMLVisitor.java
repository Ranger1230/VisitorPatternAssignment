package COM.hilbertinc.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class ReflectiveHTMLVisitor extends AbstractReflectiveVisitor {

	public ReflectiveHTMLVisitor() {
		super();
	}
	
	public boolean visitDocument(Document document){
		System.out.print("Document");
		return true;
	}
	
	public boolean visitElement(Element element){
		System.out.print("element");
		return true;
	}
	
	public boolean visitText(Text text){
		System.out.print("text");
		return true;
	}

}
