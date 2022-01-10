package by.epamtc.kulikOlga.XMLtask.dao.impl.SAX;


import by.epamtc.kulikOlga.XMLtask.bean.Bank;
import by.epamtc.kulikOlga.XMLtask.dao.DAOParser;
import by.epamtc.kulikOlga.XMLtask.dao.DAOException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class BankSAXParser implements DAOParser {
    private XMLReader reader;
    private BankSAXHandler bankSAXHandler;
    private List<Bank> banks;

    public BankSAXParser() {
        banks = new ArrayList<>();
    }

    @Override
    public void parseBank(String path) throws DAOException {
        try {
            reader = XMLReaderFactory.createXMLReader();
            bankSAXHandler = new BankSAXHandler();
            reader.setContentHandler(bankSAXHandler);

            if (bankSAXHandler != null) {
                reader.parse(path);
            }
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
