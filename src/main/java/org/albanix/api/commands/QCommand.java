package org.albanix.api.commands;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;

import java.util.Set;

public interface QCommand {
    CommandData getData();
    default Set<Permission> getRequiredPermissions() {
        return Set.of();
    }
    void execute();
}
