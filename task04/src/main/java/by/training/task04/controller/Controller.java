package by.training.task04.controller;

import by.training.task04.beans.Result;
import by.training.task04.beans.Text;
import by.training.task04.controller.command.Command;
import by.training.task04.controller.command.CommandProvider;
import by.training.task04.controller.exception.ControllerException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Controller { // TODO репозиторий синглтон, который хранит текст
    private static String language;
    private static final CommandProvider provider = new CommandProvider();
    private static final char DELIMITER_SPACE = ' ';
    private static final char DELIMITER_UNDERSСORE = '_';
    private static final Result result = new Result();
    private static final Logger logger = (Logger) LogManager.getLogger(Controller.class);

    public Controller(String language){
        this.language = language;
    }

    public Result executeTask(String request) {
        try {
            Text text = new Text();
            String [] commandAndFileArr = parseCommandArr(request);
            String currentCommand = commandAndFileArr[0];
            Command command = provider.getCommand(currentCommand);
            String arg = commandAndFileArr[1];
            if (currentCommand.equals("TEXT_ADD") || currentCommand.equals("TEXT_WRITE")){
                text = command.execute(arg,result.getText());
            } else {
                text = command.execute(arg);
            }
            result.setText(text);
            result.setState(true);
        } catch (NullPointerException e) {
            logger.error("Command have String description, but no class in repository");
            result.setState(false);
        } catch (ControllerException e){
            logger.error(e);
            result.setState(false);
        } finally {
            return result;
        }
    }

    private String [] parseCommandArr (String request){
          String [] commandAndFile = new String[2];
          StringBuilder requestStr = new StringBuilder(request);
          StringBuilder currentCommand = new StringBuilder();
          currentCommand.append(requestStr, 0, requestStr.toString().indexOf(DELIMITER_SPACE));
//        currentCommand.append(DELIMITER_UNDERSCORE);
          requestStr.delete(0, requestStr.toString().indexOf(DELIMITER_SPACE)+1);
//        currentCommand.append(requestStr, 0, requestStr.toString().indexOf(DELIMITER_SPACE));
//        currentCommand.append(DELIMITER_UNDERSCORE);
//        requestStr.delete(0, requestStr.toString().indexOf(DELIMITER_SPACE)+1);
//        currentCommand.append(requestStr, 0, requestStr.toString().indexOf(DELIMITER_SPACE));
//        requestStr.delete(0, requestStr.toString().indexOf(DELIMITER_SPACE)+1);
          commandAndFile[0] = currentCommand.toString();
          commandAndFile[1] = requestStr.toString();
          return commandAndFile;
    }

    private String [] parseCommandMatr (String request){
//        String [] commandAndArgs = new String[3];
//        StringBuilder requestStr = new StringBuilder(request);
//        StringBuilder currentCommand = new StringBuilder();
//        StringBuilder firstArg = new StringBuilder();
//        currentCommand.append(requestStr, 0, requestStr.toString().indexOf(DELIMITER_SPACE));
//        currentCommand.append(DELIMITER_UNDERSCORE);
//        requestStr.delete(0, requestStr.toString().indexOf(DELIMITER_SPACE)+1);
//        currentCommand.append(requestStr, 0, requestStr.toString().indexOf(DELIMITER_SPACE));
//        requestStr.delete(0, requestStr.toString().indexOf(DELIMITER_SPACE)+1);
//        commandAndArgs[0] = currentCommand.toString();
//        if (requestStr.toString().indexOf(DELIMITER_ARGS) != -1) {
//            firstArg.append(requestStr, 0, requestStr.toString().indexOf(DELIMITER_ARGS));
//            requestStr.delete(0, requestStr.toString().indexOf(DELIMITER_ARGS) + 1);
//            commandAndArgs[1] = firstArg.toString();
//            commandAndArgs[2] = requestStr.toString();
//        } else {
//            commandAndArgs[1] = requestStr.toString();
//        }
        return null;
    }

    public void setText (Result result){
        this.result.setText(result.getText());
    }

}
