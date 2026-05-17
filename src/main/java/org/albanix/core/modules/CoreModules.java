package org.albanix.core.modules;

import org.albanix.api.commands.CommandModule;
import org.albanix.core.commands.Ping;

public class CoreModules extends CommandModule {
    public CoreModules() {
        super("core", false);
    }

    @Override
    public void configure() {
        registerCommands(
                new Ping()
        );
    }
}
