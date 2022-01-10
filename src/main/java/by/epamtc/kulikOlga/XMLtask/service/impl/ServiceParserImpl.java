package by.epamtc.kulikOlga.XMLtask.service.impl;


import by.epamtc.kulikOlga.XMLtask.bean.Bank;
import by.epamtc.kulikOlga.XMLtask.dao.DAOException;
import by.epamtc.kulikOlga.XMLtask.dao.DAOFactory;
import by.epamtc.kulikOlga.XMLtask.dao.DAOParser;
import by.epamtc.kulikOlga.XMLtask.service.ServiceException;
import by.epamtc.kulikOlga.XMLtask.service.ServiceParser;

import java.util.List;

public class ServiceParserImpl implements ServiceParser {

    @Override
    public List<Bank> findBanks(String parserType, String xmlPath) throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        DAOParser daoParser;
        try {
            daoParser = daoFactory.createParser(parserType);
        } catch (DAOException e) {
            throw new ServiceException("Error of creating bank parser", e);
        }
        try {
            daoParser.parseBank(xmlPath);
        } catch (DAOException e) {
            throw new ServiceException("Error of parsing", e);
        }
        List<Bank> banks = daoParser.getBanks();
        return banks;
    }


}
