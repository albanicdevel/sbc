package org.albanix.events;

import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import org.albanix.commands.CommandContext;
import org.jetbrains.annotations.NotNull;

public interface ICommand {
    String getName();
    CommandData getCommandData();
    void execute(@NotNull CommandContext ctx);
}
