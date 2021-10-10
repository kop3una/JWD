package by.training.task08.controller;

import by.training.task08.beans.Result;
import by.training.task08.controller.command.Command;
import by.training.task08.controller.command.CommandProvider;
import by.training.task08.controller.exception.ControllerException;
import by.training.task08.services.exception.ServicesException;
import by.training.task08.services.validator.XMLValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Controller {
    private static final CommandProvider provider = new CommandProvider(); // TODO NOT STATIC?
    private static final Result result = new Result();
    private static final Logger logger = (Logger) LogManager.getLogger(Controller.class);


    public Result executeTask(String request) {
        String [] commandAndFileName = parseCommand(request);
        String currentCommand = commandAndFileName[0];
        String fileName = commandAndFileName[1];
        Command command = provider.getCommand(currentCommand);
        try {
            if (new XMLValidator().isValid(fileName)){
                result.setState(true);
                result.setCandies(command.execute(fileName));
            } else {
                result.setState(false);
            }
        } catch (ServicesException | ControllerException e) {
            logger.error(e);
            result.setState(false);
        }
        return result;

    }


    private String [] parseCommand (String request){
          String [] commandAndFileName = new String[2];
          commandAndFileName[0] = request.substring(0,request.indexOf(' '));
          commandAndFileName[1] = request.substring(request.indexOf(' ')+1);
          return commandAndFileName;
    }

}
