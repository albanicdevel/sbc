package org.albanix.api.commands;

import java.lang.reflect.Method;

public class RegisterCommand {
    private final Object commandClass;
    private final Method commandMethod;

    public RegisterCommand(Object commandClass, Method commandMethod) {
        this.commandClass = commandClass;
        this.commandMethod = commandMethod;
    }

    public Method getCommandMethod() {
        return commandMethod;
    }

    public Object getCommandClass() {
        return commandClass;
    }
}
