package by.training.task04.controller.command;

import by.training.task04.controller.Controller;
import by.training.task04.controller.command.impl.*;
import org.apache.logging.log4j.LogManager;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    public CommandProvider() {
        repository.put(CommandName.TEXT_READ, new TextRead());
        repository.put(CommandName.TEXT_ADD, new TextAdd());
        repository.put(CommandName.TEXT_WRITE, new TextWrite());
        repository.put(CommandName.TEXT_GENERATE,new TextGenerate());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
    }

    public Command getCommand(String name) {
        final var logger = LogManager.getLogger(Controller.class);
        CommandName commandName;
        Command command;
        try {
            commandName = CommandName.valueOf(name);
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            logger.error("WRONG REQUEST");
            command = repository.get(CommandName.WRONG_REQUEST);
        }
        return command;
    }
}
