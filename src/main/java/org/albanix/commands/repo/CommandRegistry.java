package org.albanix.commands.repo;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import org.albanix.events.ICommand;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

import java.util.Collection;
import java.util.Map;

public class CommandRegistry implements ICommandRegistry {
    private final Map<String, ICommand> commandMap;

    public CommandRegistry(Map<String, ICommand> commands) {
        this.commandMap = commands;
    }

    @Override
    public void register(@NotNull ICommand command) {
        commandMap.put(command.getName(), command);
    }

    @Override
    public void register(@NonNull @NotNull ICommand... commands) {
        for(ICommand cmd : commands) {
            commandMap.put(cmd.getName(), cmd);
        }
    }

    @Override
    public ICommand getCommand(String name) {
        return commandMap.get(name);
    }

    @Override
    public Collection<CommandData> getCommandData() {
        return commandMap.values().stream().map(ICommand::getCommandData).toList();
    }

    @Override
    public void append(JDA jda) {
        jda.updateCommands().addCommands(getCommandData()).queue();
    }
}
