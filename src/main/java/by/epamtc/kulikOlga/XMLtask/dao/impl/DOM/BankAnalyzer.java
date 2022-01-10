package by.epamtc.kulikOlga.XMLtask.dao.impl.DOM;

import by.epamtc.kulikOlga.XMLtask.bean.Bank;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;

public class BankAnalyzer {
    public static ArrayList<Bank> listBuilder(Element root) throws SAXException, IOException {
        ArrayList<Bank> banks = new ArrayList<>();
        NodeList banksNodes = root.getElementsByTagName("bank");
        Bank bank;
        for(int i = 0; i < banksNodes.getLength(); i++) {
            bank = new Bank();
            Element bankElement = (Element) banksNodes.item(i);
            bank.setName(bankElement.getAttribute("name"));
            bank.setCountry(bankElement.getAttribute("country"));
            bank.setType(getBabyValue(bankElement, "type"));
            bank.setDepositor(getBabyValue(bankElement,"depositor"));
            bank.setAccountID(Integer.parseInt(getBabyValue(bankElement, "account-id")));
            bank.setDepositAmount(Double.parseDouble(getBabyValue(bankElement, "amount-on-deposit")));
            bank.setProfitability(Double.parseDouble(getBabyValue(bankElement, "profitability")));
            bank.setTimeConstraints(Integer.parseInt(getBabyValue(bankElement, "time-constraints")));
            banks.add(bank);
        }
        return banks;
    }
    private static Element getBaby(Element parent, String childName) {
        NodeList nodelist = parent.getElementsByTagName(childName);
        Element child = (Element) nodelist.item(0);
        return child;
    }
    private static String getBabyValue(Element parent, String childName) {
        Element child = getBaby(parent, childName);
        Node node = child.getFirstChild();
        String value = node.getNodeValue();
        return value;
    }
}
