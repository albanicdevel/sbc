package org.albanix.commands.base;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.albanix.anotation.QPermission;
import org.albanix.commands.CommandContext;
import org.albanix.events.ICommand;
import org.jetbrains.annotations.NotNull;

@QPermission(Permission.ADMINISTRATOR)
public class Clear implements ICommand {
    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public CommandData getCommandData() {
        return Commands.slash(getName(), "очистити чат");
    }

    @Override
    public void execute(@NotNull CommandContext ctx) {
        ctx.reply("провірено");
    }
}
