package by.epamtc.kulikOlga.XMLtask.dao.impl.SAX;


import by.epamtc.kulikOlga.XMLtask.bean.Bank;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class BankSAXHandler extends DefaultHandler {
    private List<Bank> banks = new ArrayList<>();
    private Bank current;
    BankEnum currentEnum;


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
        if (qName.equals("banks")) {
            banks = new ArrayList<>();
        }
        if (qName.equals("bank")) {
            current = new Bank.Builder()
                    .withName(attrs.getValue("name"))
                    .withCountry(attrs.getValue("country"))
                    .build();
        }
        if (!"bank".equals(qName) && !qName.equals("banks")) {
            currentEnum = BankEnum.valueOf(qName.toUpperCase());
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("bank")) {
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
            case TIME_CONSTRAINTS:
                current.setTimeConstraints(Integer.parseInt(s));
                break;
            case ACCOUNT_ID:
                current.setAccountID(Integer.parseInt(s));
                break;
            case AMOUNT_ON_DEPOSIT:
                current.setDepositAmount(Double.parseDouble(s));
                break;
            case PROFITABILITY:
                current.setProfitability(Double.parseDouble(s));
                break;
            case TYPE:
                current.setType(s);
                break;
        }
    }

    public enum BankEnum {
        DEPOSITOR,
        TIME_CONSTRAINTS,
        ACCOUNT_ID,
        PROFITABILITY,
        AMOUNT_ON_DEPOSIT,
        TYPE
    }
}
