package by.epamtc.kulikOlga.taskXML.parser;

import by.epamtc.kulikOlga.taskXML.bean.Bank;
import by.epamtc.kulikOlga.taskXML.bean.BankEnum;
import by.epamtc.kulikOlga.taskXML.bean.DepositType;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class BankXMLSAXParser extends DefaultHandler {
    ArrayList<Bank> banks = new ArrayList<>();
    Bank current = new Bank();
    BankEnum currentEnum;

    public ArrayList<Bank> getBanks() {
        return banks;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("parsing started");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
        if(qName.equals("bank")) {
            current = new Bank.Builder()
                    .withName(attrs.getValue("name"))
                    .withCountry(attrs.getValue("country"))
                    .build();
        }
        if(!"bank".equals(qName) && !qName.equals("banks")) {
            currentEnum = BankEnum.valueOf(qName.toUpperCase());
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equals("bank")) {
            banks.add(current);
        }
        currentEnum = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String s = new String(ch, start, length).trim();
        if (currentEnum == null) {
            return;
        }
        switch (currentEnum) {
            case DEPOSITOR:
                current.setDepositor(s);
                break;
            case TIMECONSTRAINTS:
                current.setTimeConstraints(s);
                break;
            case ACCOUNTID:
                current.setAccountID(Integer.parseInt(s));
                break;
            case DEPOSITAMOUNT:
                current.setDepositAmount(Double.parseDouble(s));
                break;
            case PROFITABILITY:
                current.setProfitability(Double.parseDouble(s));
                break;
            case TYPE:
                current.setType(DepositType.valueOf(s.toUpperCase()));
                break;
        }

    }
}
