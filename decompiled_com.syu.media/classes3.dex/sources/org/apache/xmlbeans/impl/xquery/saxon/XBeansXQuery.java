package org.apache.xmlbeans.impl.xquery.saxon;

import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import net.sf.saxon.Configuration;
import net.sf.saxon.dom.NodeOverNodeInfo;
import net.sf.saxon.om.DocumentInfo;
import net.sf.saxon.om.NodeInfo;
import net.sf.saxon.query.DynamicQueryContext;
import net.sf.saxon.query.StaticQueryContext;
import net.sf.saxon.query.XQueryExpression;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlRuntimeException;
import org.apache.xmlbeans.XmlTokenSource;
import org.apache.xmlbeans.impl.store.QueryDelegate;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class XBeansXQuery implements QueryDelegate.QueryInterface {
    private Configuration config;
    private String contextVar;
    private XQueryExpression xquery;

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.XmlRuntimeException */
    public XBeansXQuery(String str, String str2, Integer num, XmlOptions xmlOptions) throws XmlRuntimeException {
        StringBuilder sbAppend;
        Configuration configuration = new Configuration();
        this.config = configuration;
        configuration.setDOMLevel(2);
        this.config.setTreeModel(0);
        StaticQueryContext staticQueryContext = new StaticQueryContext(this.config);
        Map map = (Map) xmlOptions.get("LOAD_ADDITIONAL_NAMESPACES");
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                staticQueryContext.declareNamespace((String) entry.getKey(), (String) entry.getValue());
            }
        }
        this.contextVar = str2;
        if (num.intValue() == 0) {
            sbAppend = new StringBuilder("declare variable $").append(str2).append(" external;");
        } else {
            sbAppend = new StringBuilder().append(str.substring(0, num.intValue())).append("declare variable $").append(str2).append(" external;");
            str = str.substring(num.intValue());
        }
        try {
            this.xquery = staticQueryContext.compileQuery(sbAppend.append(str).toString());
        } catch (TransformerException e) {
            throw new XmlRuntimeException(e);
        }
    }

    @Override // org.apache.xmlbeans.impl.store.QueryDelegate.QueryInterface
    public List execQuery(Object obj, Map map) {
        try {
            DocumentInfo documentInfoBuildDocument = this.config.buildDocument(new DOMSource((Node) obj));
            DynamicQueryContext dynamicQueryContext = new DynamicQueryContext(this.config);
            dynamicQueryContext.setContextItem(documentInfoBuildDocument);
            dynamicQueryContext.setParameter(this.contextVar, documentInfoBuildDocument);
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    Object value = entry.getValue();
                    if (value instanceof XmlTokenSource) {
                        dynamicQueryContext.setParameter(str, ((XmlTokenSource) value).getDomNode());
                    } else if (value instanceof String) {
                        dynamicQueryContext.setParameter(str, value);
                    }
                }
            }
            List listEvaluate = this.xquery.evaluate(dynamicQueryContext);
            ListIterator listIterator = listEvaluate.listIterator();
            while (listIterator.hasNext()) {
                Object next = listIterator.next();
                if (next instanceof NodeInfo) {
                    listIterator.set(NodeOverNodeInfo.wrap((NodeInfo) next));
                }
            }
            return listEvaluate;
        } catch (TransformerException e) {
            throw new RuntimeException("Error binding " + this.contextVar, e);
        }
    }
}
