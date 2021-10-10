package by.training.project.controller.command;

import by.training.project.controller.Controller;
import by.training.project.controller.command.impl.*;
import org.apache.logging.log4j.LogManager;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider { // TODO logger
    private final Map<CommandName, Command> repository = new HashMap<>();

    public CommandProvider() {
        repository.put(CommandName.MAIN, new MainPage());
        repository.put(CommandName.SHOW_SIGN_IN,new ShowSignIn());
        repository.put(CommandName.LOG_IN,new LogIn());
        repository.put(CommandName.SHOW_ERROR_PAGE,new ShowErrorPage());
        repository.put(CommandName.SHOW_SIGN_UP, new ShowSignUp());
        repository.put(CommandName.SIGN_UP, new SignUp());
        repository.put(CommandName.ERROR_404, new Error404());
    }

    public Command getCommand(String name) { // TODO page error 500, question about redirect and error
        try {
            return repository.get(CommandName.valueOf(name));
        } catch (IllegalArgumentException e){
            return repository.get(CommandName.ERROR_404);
        }
    }
}
