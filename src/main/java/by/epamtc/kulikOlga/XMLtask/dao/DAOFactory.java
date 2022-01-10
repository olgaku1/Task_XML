package by.epamtc.kulikOlga.XMLtask.dao;


import by.epamtc.kulikOlga.XMLtask.dao.impl.DOM.BankDOMParser;
import by.epamtc.kulikOlga.XMLtask.dao.impl.StAX.BankStAXParser;

import java.util.HashMap;
import java.util.Map;

public class DAOFactory {
    private Map<ParserType, DAOParser> parsers = new HashMap<>();
    private final static DAOFactory instance = new DAOFactory();

    public static DAOFactory getInstance() {
        return instance;
    }

    public DAOFactory() {
        parsers.put(ParserType.DOM, new BankDOMParser());
        parsers.put(ParserType.SAX, new BankDOMParser());
        parsers.put(ParserType.STAX, new BankStAXParser());
    }

    public DAOParser createParser(String type) throws DAOException {
        ParserType parserType;
        parserType = ParserType.valueOf(type.toUpperCase());
        return parsers.get(parserType);
    }

    public enum ParserType {
        DOM,
        STAX,
        SAX
    }
}


