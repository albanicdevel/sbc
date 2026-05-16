package org.albanix.api.interfaces;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;

import java.util.Set;

public interface QCommand {
    /**
    * Передавання даних у discord api.
    * <pre>{@code
    *   @Override
    *   CommandData getData() {
    *       return Commands.slash("name", "desc");
     *       // також можете додати опції!
    *   }
     * }</pre>
     */
    CommandData getData();

    /**
     *
     * @return Поверне {@link Set} із {@link Permission}. Ви можете дуже просто їх додати:
     *
     * <pre>{@code
     * @Override
     * Set<Permission> getRequiredPermissions() {
     *     return Set.of(Permission.ADMINISTRATOR)
     * }
     * }
     * </pre>
     *
     * Проте по дефолту значення буде Set.of();
     */
    default Set<Permission> getRequiredPermissions() {
        return Set.of();
    }

    /**
     * Взаємодія з discord api: частково клієнт, сервери, повідомлення, канали..
     * @param ctx Контекст оточення боту {@link QCommandContext}
     * @return {@link QCommandResult} - це означає, що команда більше не керує відправкою повідомлень
     */
    QCommandResult execute(QCommandContext ctx);
}
