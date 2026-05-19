package org.albanix.api.commands;

import org.albanix.core.commands.Ping;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CommandRegistry {
    private final Map<String, RegisterCommand> commands = new HashMap<>();

    public CommandRegistry() {
        register(new Ping());
    }

    private void register(Object command) {
        Class<?> clazz = command.getClass();
        if(clazz.isAnnotationPresent(Command.class)) {
            Command commandAnnotation = clazz.getAnnotation(Command.class);
            String name = commandAnnotation.name();
            String description = commandAnnotation.description();
            Method[] methods = clazz.getDeclaredMethods();

            for(Method method : methods) {
                if(method.isAnnotationPresent(Execute.class)) {
                    RegisterCommand registerCommand = new RegisterCommand(command, method);
                    commands.put(name, registerCommand);
                }
            }
        }
    }
}
