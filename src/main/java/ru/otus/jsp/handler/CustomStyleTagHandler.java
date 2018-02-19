package ru.otus.jsp.handler;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class CustomStyleTagHandler extends BodyTagSupport {

    private int size = 4;

    @Override
    public int doStartTag() throws JspException {
        return super.doStartTag();
    }

//    @Override
//    public int doAfterBody() throws JspException {
//        return EVAL_BODY_AGAIN;
//    }

    @Override
    public int doEndTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();

            out.println(
                    "<font size=\"" + size + "\">"
            );
            out.print(getBodyContent().toString());//TODO:заменить вызов метода
            out.print("</font>");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return EVAL_PAGE;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
