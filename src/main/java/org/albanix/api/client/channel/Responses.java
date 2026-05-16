package org.albanix.api.client.channel;

import org.albanix.api.interfaces.QCommandResult;

public class Responses {
    public static QCommandResult text(String text, boolean ephemeral) {
        return new TextResult(text, ephemeral);
    }
}
