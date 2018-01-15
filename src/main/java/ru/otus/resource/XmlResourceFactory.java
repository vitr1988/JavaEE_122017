package ru.otus.resource;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.RefAddr;
import javax.naming.Reference;
import javax.naming.spi.ObjectFactory;
import java.util.Enumeration;
import java.util.Hashtable;

public class XmlResourceFactory implements ObjectFactory {

    @Override
    public Object getObjectInstance(Object obj, Name name2, Context nameCtx, Hashtable<?, ?> environment) throws Exception {
        // Acquire an instance of our specified bean class
        XmlBean bean = new XmlBean();

        // Customize the bean properties from our attributes
        Reference ref = (Reference) obj;
        Enumeration addrs = ref.getAll();
        while (addrs.hasMoreElements()) {
            RefAddr addr = (RefAddr) addrs.nextElement();
            String name = addr.getType();
            String value = (String) addr.getContent();
            if (name.equals("path")) {
                bean.setXmlPath(value);
            }
        }
        // Return the customized instance
        return (bean);
    }
}
