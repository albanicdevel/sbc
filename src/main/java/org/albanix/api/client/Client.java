package org.albanix.api.client;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client {
    private static final Logger log = LoggerFactory.getLogger(Client.class);
    private final JDA jda;

    /**
     * Startup bot with your token
     * @param token token
     */
    public Client(@NotNull String token) {
        JDABuilder builder = JDABuilder.createDefault(token);
        jda = builder.build();
    }

    /**
     * change status of the bot
     * @param status as {@link String}
     */
    public void changeStatus(@NotNull String status) {
        try {
            this.jda.awaitReady();
            this.jda.getPresence().setStatus(OnlineStatus.IDLE);
            this.jda.getPresence().setActivity(Activity.playing(status));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
