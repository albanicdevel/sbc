package org.albanix.api.client.channel;

import org.albanix.api.interfaces.QCommandResult;

public class TextResult implements QCommandResult {
    private final String content;
    private final boolean ephemeral;

    public  TextResult(String content, boolean ephemeral) {
        this.content = content;
        this.ephemeral = ephemeral;
    }

    public String getContent() { return this.content; }
    public boolean isEphemeral() { return this.ephemeral; }
}
