package org.albanix.api.commands;

import org.albanix.api.interfaces.QCommand;

import java.util.ArrayList;
import java.util.List;

public abstract class CommandModule {
    private String name;
    private boolean isRemovable;
    private final List<QCommand> moduleCommand = new ArrayList<>();

    public CommandModule(String name, boolean isRemovable) {
        this.name = name;
        this.isRemovable = isRemovable;

    }

    public abstract void configure();

    public void registerCommands(QCommand... commands) {
        this.moduleCommand.addAll(List.of(commands));
    }

    public List<QCommand> getModuleCommand() {
        return moduleCommand;
    }
    public String getName() {
        return name;
    }

    public boolean isRemovable() {
        return isRemovable;
    }
}
