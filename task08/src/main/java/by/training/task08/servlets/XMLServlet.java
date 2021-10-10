package by.training.task08.servlets;

import by.training.task08.beans.Result;
import by.training.task08.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@WebServlet(urlPatterns = "/XMLParsing")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
        maxFileSize=1024*1024*10,      // 10MB
        maxRequestSize=1024*1024*50)   // 50MB
public class XMLServlet extends HttpServlet {
    private static final Controller controller = new Controller();
    private static final String SAVE_DIR = "uploadFiles";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean flagUpload = true;
        String allPathFile = "";
        // gets absolute path of the web application
        String appPath = request.getServletContext().getRealPath("");
        // constructs path of the directory to save uploaded file
        String savePath = appPath + SAVE_DIR;

        // creates the save directory if it does not exists
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }

        for (Part part : request.getParts()) {

            if (part.getName().equals("parser")){
               InputStream stringBuffer = part.getInputStream();
               byte[] strByte = stringBuffer.readAllBytes();
               StringBuffer parser = new StringBuffer();
               for (byte symbol : strByte){
                   parser.append((char) symbol);
               }
               request.setAttribute("parser",parser.toString());
            } else {
                String fileName = extractFileName(part);
                allPathFile = savePath+File.separator+fileName;
                // refines the fileName in case it is an absolute path
                if (flagUpload = flagUpload&(!fileName.isEmpty())){
                    fileName = new File(fileName).getName();
                    part.write(savePath + File.separator + fileName);
                }
            }

        }

        if (flagUpload){
            request.setAttribute("message", "Загрузка файла на сервер прошла успешно!");
            Result result = controller.executeTask(request.getAttribute("parser")+" "+ allPathFile);
            if (result.isState()){
                request.setAttribute("validation","Валидация файла прошла успешно!");
                request.setAttribute("result",result);
            } else {
                request.setAttribute("validation","Что-то не так с файлом!");
            }
        } else {
            request.setAttribute("message", "Произошла ошибка загрузки файла на сервер");
        }

        getServletContext().getRequestDispatcher("/XMLResult").forward(request, response);
    }

    /**
     * Extracts file name from HTTP header content-disposition
     */
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }
}
