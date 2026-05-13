package org.albanix.commands.repo;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import org.albanix.anotation.QPermission;
import org.albanix.events.ICommand;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CommandRegistry implements ICommandRegistry {
    private final Map<String, ICommand> commandMap;
    private final Map<String, Permission[]> permissionMap;
    public CommandRegistry(Map<String, ICommand> commands) {

        this.commandMap = commands;
        permissionMap = new HashMap<>();
    }

    @Override
    public void register(@NotNull ICommand command) {
        commandMap.put(command.getName(), command);

        if(command.getClass().isAnnotationPresent(QPermission.class)) {
            QPermission ann = command.getClass().getAnnotation(QPermission.class);
            permissionMap.put(command.getName(), ann.value());
        }
    }

    @Override
    public void register(@NonNull ICommand... commands) {
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
    public Permission[] getPermission(String commandName) {
        return permissionMap.get(commandName);
    }

    @Override
    public void append(JDA jda) {
        jda.updateCommands().addCommands(getCommandData()).queue();
    }
}
