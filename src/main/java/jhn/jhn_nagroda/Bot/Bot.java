package jhn.jhn_nagroda.Bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

import java.io.IOException;
import java.util.Collections;
import jhn.jhn_nagroda.Functions.Reward;
public class Bot extends ListenerAdapter {
    public JDA jda;

    public void startBot(String token) {
        jda = JDABuilder.createLight(token, Collections.emptyList())
                .addEventListeners(this)
                .setActivity(Activity.playing("/nagroda"))
                .build();

        jda.updateCommands().addCommands(
                Commands.slash("nagroda", "Calculate ping of the bot")
                        .setGuildOnly(true)
                        .addOption(OptionType.STRING, "nick", "Podaj nick", true) // optional reason
        ).queue();
    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        Reward reward = new Reward();

        switch (event.getName()) {
            case "nagroda":
                String nick = event.getOption("nick").getAsString();
                System.out.println("Gracz "+nick+" Uzyl komendy odbierz");
                event.reply(reward.add(nick)).setEphemeral(true).queue();
                break;
            default:
                System.out.printf("Unknown command %s used by %#s%n", event.getName(), event.getUser());
        }
    }
}
