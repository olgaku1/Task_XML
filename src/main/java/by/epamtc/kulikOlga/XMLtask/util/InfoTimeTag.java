package by.epamtc.kulikOlga.XMLtask.util;

import by.epamtc.kulikOlga.XMLtask.controller.ParserServlet;
import by.epamtc.kulikOlga.XMLtask.service.ServiceException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.GregorianCalendar;

public class InfoTimeTag extends TagSupport {

    @Override
    public int doStartTag() {
        GregorianCalendar gc = new GregorianCalendar();
        String time = "<hr/Time: <b> " + gc.getTime() + " </b><hr/>";
        Logger logger = LogManager.getLogger(ParserServlet.class);
        try {
            JspWriter out = pageContext.getOut();
            out.write(time);
        } catch (IOException e) {
            logger.info(e.getMessage());
        }
        return SKIP_BODY;
    }
}
