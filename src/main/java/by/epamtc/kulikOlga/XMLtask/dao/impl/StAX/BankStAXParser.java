package by.epamtc.kulikOlga.XMLtask.dao.impl.StAX;

import by.epamtc.kulikOlga.XMLtask.bean.Bank;
import by.epamtc.kulikOlga.XMLtask.dao.DAOParser;
import by.epamtc.kulikOlga.XMLtask.dao.DAOException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BankStAXParser implements DAOParser {
    private List<Bank> banks;
    private Bank currentBank;
    private XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

    public BankStAXParser(){
        banks = new ArrayList<>();
    }

    @Override
    public void parseBank(String xmlPath) throws DAOException {
        Path path = Paths.get(xmlPath);
        XMLStreamReader reader;
        try {
            reader = xmlInputFactory.createXMLStreamReader(new FileInputStream(path.toFile()));
        } catch (XMLStreamException | FileNotFoundException e) {
            throw new DAOException("fail to create xml stream reader");
        }
        try {
            while (reader.hasNext()) {
                buildBank(reader);
            }
        } catch (XMLStreamException e) {
            throw new DAOException("fail in building flower - STAX");
        }
    }

    public void buildBank(XMLStreamReader reader) throws XMLStreamException {
        int eventType;
        eventType = reader.next();
        if (eventType == XMLEvent.START_ELEMENT) {
            String tagName = reader.getName().getLocalPart();
            switch (tagName) {
                case "bank":
                    currentBank = new Bank();
                    String name = reader.getAttributeValue(null, "name");
                    currentBank.setName(name);
                    String country = reader.getAttributeValue(null, "country");
                    currentBank.setCountry(country);
                    break;
                case "type":
                    eventType = reader.next();
                    if (eventType == XMLEvent.CHARACTERS) {
                        String type = reader.getText();
                        currentBank.setType(type);
                    }
                    break;

                case "depositor":
                    eventType = reader.next();
                    if (eventType == XMLEvent.CHARACTERS) {
                        String depositor = reader.getText();
                        currentBank.setDepositor(depositor);
                    }
                    break;

                case "account-id":
                    eventType = reader.next();
                    if (eventType == XMLEvent.CHARACTERS) {
                        int accountId = Integer.parseInt(reader.getText());
                        currentBank.setAccountID(accountId);
                    }
                    break;

                case "amount-on-deposit":
                    eventType = reader.next();
                    if (eventType == XMLEvent.CHARACTERS) {
                        double depositAmount = Double.parseDouble(reader.getText());
                        currentBank.setDepositAmount(depositAmount);
                    }
                    break;
                case "profitability":
                    eventType = reader.next();
                    if (eventType == XMLEvent.CHARACTERS) {
                        double profitability = Double.parseDouble(reader.getText());
                        currentBank.setProfitability(profitability);
                    }
                    break;
                case "time-constraints":
                    eventType = reader.next();
                    if (eventType == XMLEvent.CHARACTERS) {
                        int timeConstraints = Integer.parseInt(reader.getText());
                        currentBank.setTimeConstraints(timeConstraints);
                    }
                    break;

            }
        }
        if (eventType == XMLEvent.END_ELEMENT) {
            String tag = reader.getName().getLocalPart();
            if (tag.equals("bank")) {
                banks.add(currentBank);
            }
        }
    }



    @Override
    public List<Bank> getBanks() {
        return banks;
    }
}
