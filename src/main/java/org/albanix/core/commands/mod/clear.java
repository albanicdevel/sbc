package org.albanix.core.commands.mod;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.albanix.api.interfaces.QCommand;

import java.util.Set;

public class clear implements QCommand {
    @Override
    public CommandData getData() {
        return Commands.slash("admin-test", "myau");
    }

    @Override
    public Set<Permission> getRequiredPermissions() {
        return Set.of(Permission.ADMINISTRATOR);
    }

    @Override
    public void execute() {

    }
}
