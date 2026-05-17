package org.albanix.core.modules;

import org.albanix.api.commands.qAModule;
import org.albanix.core.commands.Ping;

public class CoreModules extends  qAModule {
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
