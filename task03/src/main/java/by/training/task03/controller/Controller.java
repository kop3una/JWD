package by.training.task03.controller;

import by.training.task03.beans.Entity;
import by.training.task03.controller.command.Command;
import by.training.task03.controller.command.CommandProvider;
import by.training.task03.controller.exception.ControllerException;

public final class Controller {  // TODO no throws
    private static final CommandProvider provider = new CommandProvider();
    private static final char DELIMITER_SPACE = ' ';
    private static final char DELIMITER_UNDERSCORE = '_';
    private static final char DELIMITER_ARGS = (char) 1;

    public Entity executeTask(String request) throws ControllerException {
        Entity entity = null;
        try {
            if (parseEntity(request).equals("ARR")){
                String [] commandAndFileArr = parseCommandArr(request);
                String currentCommand = commandAndFileArr[0];
                String fileName = commandAndFileArr[1];
                Command command = provider.getCommand(currentCommand);
                entity = command.execute(fileName);
            } else {
                String [] commandAndArgsMatr = parseCommandMatr(request);
                String currentCommand = commandAndArgsMatr[0];
                String firstArg = commandAndArgsMatr[1];
                String secondArg = commandAndArgsMatr[2];
                Command command = provider.getCommand(currentCommand);
                entity = command.execute(firstArg,secondArg);
            }
        } catch (ControllerException e){
            throw new ControllerException(e);
        } catch (NullPointerException e) {
            throw new ControllerException("Command have String description, but no class in repository");
        }
        return entity;
    }

    private String [] parseCommandArr (String request){
        String [] commandAndFile = new String[2];
        StringBuilder requestStr = new StringBuilder(request);
        StringBuilder currentCommand = new StringBuilder();
        currentCommand.append(requestStr, 0, requestStr.toString().indexOf(DELIMITER_SPACE));
        currentCommand.append(DELIMITER_UNDERSCORE);
        requestStr.delete(0, requestStr.toString().indexOf(DELIMITER_SPACE)+1);
        currentCommand.append(requestStr, 0, requestStr.toString().indexOf(DELIMITER_SPACE));
        currentCommand.append(DELIMITER_UNDERSCORE);
        requestStr.delete(0, requestStr.toString().indexOf(DELIMITER_SPACE)+1);
        currentCommand.append(requestStr, 0, requestStr.toString().indexOf(DELIMITER_SPACE));
        requestStr.delete(0, requestStr.toString().indexOf(DELIMITER_SPACE)+1);
        commandAndFile[0] = currentCommand.toString();
        commandAndFile[1] = requestStr.toString();
        return commandAndFile;
    }

    private String [] parseCommandMatr (String request){
        String [] commandAndArgs = new String[3];
        StringBuilder requestStr = new StringBuilder(request);
        StringBuilder currentCommand = new StringBuilder();
        StringBuilder firstArg = new StringBuilder();
        currentCommand.append(requestStr, 0, requestStr.toString().indexOf(DELIMITER_SPACE));
        currentCommand.append(DELIMITER_UNDERSCORE);
        requestStr.delete(0, requestStr.toString().indexOf(DELIMITER_SPACE)+1);
        currentCommand.append(requestStr, 0, requestStr.toString().indexOf(DELIMITER_SPACE));
        requestStr.delete(0, requestStr.toString().indexOf(DELIMITER_SPACE)+1);
        commandAndArgs[0] = currentCommand.toString();
        if (requestStr.toString().indexOf(DELIMITER_ARGS) != -1) {
            firstArg.append(requestStr, 0, requestStr.toString().indexOf(DELIMITER_ARGS));
            requestStr.delete(0, requestStr.toString().indexOf(DELIMITER_ARGS) + 1);
            commandAndArgs[1] = firstArg.toString();
            commandAndArgs[2] = requestStr.toString();
        } else {
            commandAndArgs[1] = requestStr.toString();
        }
        return commandAndArgs;
    }

    private String parseEntity (String request){
        return request.substring(0,request.indexOf(DELIMITER_SPACE));
    }
}

