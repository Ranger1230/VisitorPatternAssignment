package COM.hilbertinc.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class HDOMTraverse {

	public HDOMTraverse() {
		// TODO Auto-generated constructor stub
	}
	
	public static void traverse(AbstractReflectiveVisitor visitor, Node document){
		
		visitor.dispatch(document);
		
		NodeList children = document.getChildNodes();
		int count = children.getLength();
		for (int i = 0; i < count; ++i)
			{
			Node child = (Node)children.item(i);
			traverse(visitor, child);
			}
		return;
		}	

}
