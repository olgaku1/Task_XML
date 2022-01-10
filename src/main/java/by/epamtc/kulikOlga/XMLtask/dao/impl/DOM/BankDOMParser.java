package by.epamtc.kulikOlga.XMLtask.dao.impl.DOM;

import by.epamtc.kulikOlga.XMLtask.bean.Bank;
import by.epamtc.kulikOlga.XMLtask.dao.DAOParser;
import by.epamtc.kulikOlga.XMLtask.dao.DAOException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BankDOMParser implements DAOParser {
    private DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    private DocumentBuilder documentBuilder;
    private List<Bank> banks;

    public BankDOMParser() {
        banks = new ArrayList<>();
    }

    @Override
    public void parseBank(String path) throws DAOException {
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(path);
            Element root = document.getDocumentElement();
            banks = BankAnalyzer.listBuilder(root);
        } catch (ParserConfigurationException e) {
            throw new DAOException("Ошибка конфигурации", e);
        } catch (SAXException e) {
            throw new DAOException("Ошибка SAX парсера", e);
        } catch (IOException e) {
            throw new DAOException("Ошибка I/O потока", e);
        }
    }

    @Override
    public List<Bank> getBanks() {
        return banks;
    }
}
