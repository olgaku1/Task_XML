package by.epamtc.kulikOlga.XMLtask.util;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FileUploader {
    private static final long MAX_FILE_SIZE = 5000 * 1024;
    private static final int MAX_MEM_SIZE = 500 * 1024;
    private static final String FILE_PATH = "filePath";
    private static final String TEMP_REPOSITORY_PATH = "tempRepository";
    private static final String xsdExtension = "xsd";
    private static final String xmlExtension = "xml";
    private static File file;

    public static Map<String, String> uploadFile(HttpServletRequest request) throws FileUploadException, IOException {
        String fileRepository = PropertyHolder.getProperty(TEMP_REPOSITORY_PATH);
        String filePath = PropertyHolder.getProperty(FILE_PATH);

        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(MAX_MEM_SIZE);
        factory.setRepository(new File(fileRepository));
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setSizeMax(MAX_FILE_SIZE);

        Map<String, String> params = new HashMap<>();

        List fileItems = upload.parseRequest(request);
        Iterator iterator = fileItems.iterator();
        while (iterator.hasNext()) {
            FileItem fileItem = (FileItem) iterator.next();
            if (!fileItem.isFormField()) {
                String fieldName = fileItem.getFieldName();
                String fileName = fileItem.getName();
                boolean isInMemory = fileItem.isInMemory();
                long sizeInBytes = fileItem.getSize();
                file = new File(filePath + fileName);
                try {
                    fileItem.write(file);
                } catch (FileNotFoundException e) {
                    throw new FileUploadException("Files are not uploaded. Try again.", e);
                } catch (Exception e) {
                    throw new FileUploadException("File uploading fail", e);
                }
                String path = file.getAbsolutePath();
                if (path.endsWith(xsdExtension)) {
                    params.put(xsdExtension, path);
                } else {
                    params.put(xmlExtension, path);
                }
            } else {
                params.put("parserType", fileItem.getString());
            }
        }
        return params;
    }
}
