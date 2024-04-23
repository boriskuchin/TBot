package com.javarush.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {
    public static final String NAME = "BorisBDay_bot"; // TODO: добавьте имя бота в кавычках
    public static final String TOKEN = "5229040491:AAE24EGFxrDgcHahZNgaaro52pfTNTsvIL0"; //TODO: добавьте токен бота в кавычках

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update updateEvent) {
        if (getMessageText().equals("/start")) {
            sendTextMessageAsync("HiHi");
        }
        if (getMessageText().equals("/buy")) {
            sendTextMessageAsync("Asta la vista, baby!");
        }

        if (getMessageText().contains("cat")) {
            sendTextMessageAsync("Ваше любимое животное? ",
                    Map.of("Кот", "callbackCat",
                            "Собака", "callbackDog"));

        }
        if (getCallbackQueryButtonKey().equals("callbackCat")) {
            sendPhotoMessageAsync("step_4_pic");
        } else if (getCallbackQueryButtonKey().equals("callbackDog")) {
            sendPhotoMessageAsync("step_6_pic");
        }


        if (getMessageText().equals("Smile")) {
            var msg = getLastSentMessage();
            editTextMessageAsync(msg.getMessageId(), msg.getText() + " :-) ");
        }
        }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}