package org.apache.xmlbeans.impl.xpath.saxon;

import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import net.sf.saxon.Configuration;
import net.sf.saxon.dom.NodeWrapper;
import net.sf.saxon.om.Item;
import net.sf.saxon.om.NodeInfo;
import net.sf.saxon.om.VirtualNode;
import net.sf.saxon.sxpath.IndependentContext;
import net.sf.saxon.sxpath.XPathDynamicContext;
import net.sf.saxon.sxpath.XPathEvaluator;
import net.sf.saxon.sxpath.XPathExpression;
import net.sf.saxon.sxpath.XPathVariable;
import net.sf.saxon.value.Value;
import org.apache.xmlbeans.impl.store.PathDelegate;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class XBeansXPath implements PathDelegate.SelectPathInterface {
    private String contextVar;
    private String defaultNS;
    private Object[] namespaceMap;
    private String path;

    public XBeansXPath(String str, String str2, Map map, String str3) {
        this.path = str;
        this.contextVar = str2;
        this.defaultNS = str3;
        this.namespaceMap = map.entrySet().toArray();
    }

    public List selectNodes(Object obj) {
        try {
            Node node = (Node) obj;
            XPathEvaluator xPathEvaluator = new XPathEvaluator();
            Configuration configuration = new Configuration();
            configuration.setDOMLevel(2);
            int i = 0;
            configuration.setTreeModel(0);
            IndependentContext independentContext = new IndependentContext(configuration);
            String str = this.defaultNS;
            if (str != null) {
                independentContext.setDefaultElementNamespace(str);
            }
            while (true) {
                Object[] objArr = this.namespaceMap;
                if (i >= objArr.length) {
                    break;
                }
                Map.Entry entry = (Map.Entry) objArr[i];
                independentContext.declareNamespace((String) entry.getKey(), (String) entry.getValue());
                i++;
            }
            xPathEvaluator.setStaticContext(independentContext);
            XPathVariable xPathVariableDeclareVariable = xPathEvaluator.declareVariable("", this.contextVar);
            XPathExpression xPathExpressionCreateExpression = xPathEvaluator.createExpression(this.path);
            NodeInfo nodeInfoUnravel = configuration.unravel(new DOMSource(node));
            XPathDynamicContext xPathDynamicContextCreateDynamicContext = xPathExpressionCreateExpression.createDynamicContext((Item) null);
            xPathDynamicContextCreateDynamicContext.setContextItem(nodeInfoUnravel);
            xPathDynamicContextCreateDynamicContext.setVariable(xPathVariableDeclareVariable, nodeInfoUnravel);
            List listEvaluate = xPathExpressionCreateExpression.evaluate(xPathDynamicContextCreateDynamicContext);
            ListIterator listIterator = listEvaluate.listIterator();
            while (listIterator.hasNext()) {
                Object next = listIterator.next();
                if (next instanceof NodeInfo) {
                    if (next instanceof NodeWrapper) {
                        listIterator.set(getUnderlyingNode((NodeWrapper) next));
                    } else {
                        listIterator.set(((NodeInfo) next).getStringValue());
                    }
                } else if (next instanceof Item) {
                    listIterator.set(Value.convertToJava((Item) next));
                }
            }
            return listEvaluate;
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // org.apache.xmlbeans.impl.store.PathDelegate.SelectPathInterface
    public List selectPath(Object obj) {
        return selectNodes(obj);
    }

    private static Node getUnderlyingNode(VirtualNode virtualNode) {
        Object underlyingNode = virtualNode;
        while (underlyingNode instanceof VirtualNode) {
            underlyingNode = ((VirtualNode) underlyingNode).getUnderlyingNode();
        }
        return (Node) underlyingNode;
    }
}
