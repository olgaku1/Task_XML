package by.epamtc.kulikOlga.XMLtask.service;

import by.epamtc.kulikOlga.XMLtask.service.impl.ServiceParserImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    ServiceParser serviceParser = new ServiceParserImpl();
    private ServiceFactory() {

    }
    public static ServiceFactory getInstance() {
        return instance;
    }

    public ServiceParser getParserService() {
        return serviceParser;
    }

}
