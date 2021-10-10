package by.training.task03.controller.command;


import by.training.task03.controller.Controller;
import by.training.task03.controller.command.impl.*;
import org.apache.logging.log4j.LogManager;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    public CommandProvider() {
        repository.put(CommandName.ARR_BUBBLE_SORT_INCREASE,new BubbleSortIncrease());
        repository.put(CommandName.ARR_BUBBLE_SORT_DECREASE,new BubbleSortDecrease());
        repository.put(CommandName.ARR_HASHING_SORT_INCREASE,new HashingSortIncrease());
        repository.put(CommandName.ARR_HASHING_SORT_DECREASE,new HashingSortDecrease());
        repository.put(CommandName.ARR_INSERTION_SORT_INCREASE,new InsertionSortIncrease());
        repository.put(CommandName.ARR_INSERTION_SORT_DECREASE,new InsertionSortDecrease());
        repository.put(CommandName.ARR_MERGE_SORT_INCREASE,new MergeSortIncrease());
        repository.put(CommandName.ARR_MERGE_SORT_DECREASE,new MergeSortDecrease());
        repository.put(CommandName.ARR_SHAKER_SORT_INCREASE,new ShakerSortIncrease());
        repository.put(CommandName.ARR_SHAKER_SORT_DECREASE,new ShakerSortDecrease());
        repository.put(CommandName.ARR_SHELL_SORT_INCREASE,new ShellSortIncrease());
        repository.put(CommandName.ARR_SHELL_SORT_DECREASE,new ShellSortDecrease());
        repository.put(CommandName.ARR_SIMPLE_CHOICE_SORT_INCREASE, new SimpleChoiceIncrease());
        repository.put(CommandName.ARR_SIMPLE_CHOICE_SORT_DECREASE, new SimpleChoiceDecrease());
        repository.put(CommandName.MATR_SUM, new MatrSum());
        repository.put(CommandName.MATR_SUB, new MatrSub());
        repository.put(CommandName.MATR_TRANSPOSE, new MatrTranspose());
        repository.put(CommandName.MATR_POW, new MatrPow());
        repository.put(CommandName.MATR_MULTIPLY_NUMBER, new MatrMultiplyNumber());
        repository.put(CommandName.MATR_MULTIPLY_MATRIX, new MatrMultiplyMatrix());
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
