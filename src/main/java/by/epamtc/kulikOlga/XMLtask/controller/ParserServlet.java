package by.epamtc.kulikOlga.XMLtask.controller;

import by.epamtc.kulikOlga.XMLtask.service.ServiceException;
import by.epamtc.kulikOlga.XMLtask.service.ServiceFactory;
import by.epamtc.kulikOlga.XMLtask.service.validation.ValidatorXSD;
import by.epamtc.kulikOlga.XMLtask.bean.Bank;
import by.epamtc.kulikOlga.XMLtask.service.ServiceParser;
import by.epamtc.kulikOlga.XMLtask.util.FileUploader;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ParserServlet extends HttpServlet {

    public ParserServlet() {
        super();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ServiceParser serviceParser = serviceFactory.getParserService();
        List<Bank> banks;
        Map<String, String> params;
        Logger logger = LogManager.getLogger(ParserServlet.class);
        try {
            params = FileUploader.uploadFile(request);
        } catch (FileUploadException e) {
            logger.error(e.getMessage(), e);
            throw new ServletException(e.getMessage(), e);
        }
        String xsdPath = params.get("xsd");
        String xmlPath = params.get("xml");
        String parserType = params.get("parserType");
        try {
            ValidatorXSD.validateXSD(xsdPath, xmlPath);
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
            throw new ServletException(e.getMessage(), e);
        }
        try {
            banks = serviceParser.findBanks(parserType, xmlPath);
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
            throw new ServletException(e.getMessage(), e);
        }
        request.setAttribute("banks", banks);
        request.getRequestDispatcher("banks.jsp").forward(request, response);
    }
}
