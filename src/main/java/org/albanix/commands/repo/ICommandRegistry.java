package org.albanix.commands.repo;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import org.albanix.events.ICommand;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public interface ICommandRegistry {
    void register(@NotNull ICommand command);
    void register(@NotNull ICommand... commands);
    ICommand getCommand(String name);
    Collection<CommandData> getCommandData();
    void append(JDA jda);
}
