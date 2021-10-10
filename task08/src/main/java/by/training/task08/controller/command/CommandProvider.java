package by.training.task08.controller.command;

import by.training.task08.controller.Controller;
import by.training.task08.controller.command.impl.DomParser;
import by.training.task08.controller.command.impl.SaxParser;
import by.training.task08.controller.command.impl.StaxParser;
import by.training.task08.controller.command.impl.WrongRequest;
import org.apache.logging.log4j.LogManager;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    public CommandProvider() {
        repository.put(CommandName.DOM, new DomParser());
        repository.put(CommandName.SAX, new SaxParser());
        repository.put(CommandName.STAX, new StaxParser());
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
