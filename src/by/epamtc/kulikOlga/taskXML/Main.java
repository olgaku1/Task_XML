package by.epamtc.kulikOlga.taskXML;

import by.epamtc.kulikOlga.taskXML.bean.Bank;
import by.epamtc.kulikOlga.taskXML.parser.BankXMLSAXParser;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            BankXMLSAXParser bankh = new BankXMLSAXParser();
            reader.setContentHandler(bankh);
            ArrayList<Bank> banks;
            if (bankh != null) {
                reader.parse("banks.xml");
                System.out.println(bankh.getBanks());
            }
        } catch (SAXException e) {
            e.printStackTrace();
            System.out.println("Ошибка SAX парсера");


        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка I/O потока");
        }
    }

}
