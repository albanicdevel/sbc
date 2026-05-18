package org.albanix.api.client.channel;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import org.albanix.api.interfaces.QCommandResult;

public class TextResult implements QCommandResult {
    private final String content;
    private final boolean ephemeral;

    public  TextResult(String content, boolean ephemeral) {
        this.content = content;
        this.ephemeral = ephemeral;
    }

    public TextResult(String content) {
        this(content, false);
    }

    @Override
    public void send(SlashCommandInteractionEvent event) {
        event.reply(content).setEphemeral(ephemeral).queue();
    }
    public String getContent() { return this.content; }
    public boolean isEphemeral() { return this.ephemeral; }
}
