package ru.otus.jsp.handler;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class CounterTagHandler extends SimpleTagSupport {

    public static final String COUNTER_APPLICATION_ATTRIBUTE = "counter";

    @Override
    public void doTag() throws JspException, IOException {
        PageContext context = (PageContext) getJspContext();
        Map<String, Long> counterMap = (Map<String, Long>) context.getServletContext().getAttribute(COUNTER_APPLICATION_ATTRIBUTE);
        if (counterMap == null) {
            counterMap = new ConcurrentHashMap<>();
            context.getServletContext().setAttribute(COUNTER_APPLICATION_ATTRIBUTE, counterMap);
        }

        final Map<String, Long> result = counterMap;

        String key = context.getPage().getClass().getSimpleName();
        Long value = result.getOrDefault(key, 0L) + 1;
        counterMap.put(key, value);
        context.getOut().print(value);
    }
}
