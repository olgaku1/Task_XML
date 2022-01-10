package by.epamtc.kulikOlga.XMLtask.service;

import by.epamtc.kulikOlga.XMLtask.bean.Bank;

import java.util.List;

public interface ServiceParser {
    List<Bank> findBanks(String parserType, String xmlPath) throws ServiceException;
}
