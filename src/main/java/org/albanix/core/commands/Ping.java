package org.albanix.core.commands;

import org.albanix.api.commands.Command;
import org.albanix.api.commands.Execute;

@Command(name = "ping", description = "lol")
public class Ping {
    @Execute
    public void execute() {

    }
}
