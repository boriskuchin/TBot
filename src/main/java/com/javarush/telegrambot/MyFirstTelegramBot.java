package com.javarush.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static com.javarush.telegrambot.TelegramBotContent.*;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {
    public static final String NAME = "BorisBDay_bot"; // TODO: добавьте имя бота в кавычках
    public static final String TOKEN = "5229040491:AAE24EGFxrDgcHahZNgaaro52pfTNTsvIL0"; //TODO: добавьте токен бота в кавычках

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update updateEvent) {
        if (getMessageText().equals("/start")) {
            setUserGlory(0);

            sendTextMessageAsync(STEP_1_TEXT,
                    Map.of("Взлом холодильника", "callBack1"));
        }
        if (getCallbackQueryButtonKey().equals("callBack1")) {
            addUserGlory(20);

            sendTextMessageAsync(STEP_2_TEXT,
                    Map.of( "Взять сосиску! + 20 к славе","callBack2",
                            "Взять рабку! + 20 к славе","callBack2",
                            "Скинуть банку! + 20 к славе","callBack2"));
        }

        if (getCallbackQueryButtonKey().equals("callBack2")) {

            sendTextMessageAsync(STEP_3_TEXT,
                    Map.of("Взломать пылесос", "callBack3"));
        }
        if (getCallbackQueryButtonKey().equals("callBack3")) {
            addUserGlory(30);

            sendTextMessageAsync(STEP_4_TEXT,
                    Map.of( "Отправить робот за едой! + 30 к славе","callBack4",
                            "Покататься! + 30 к славе","callBack4",
                            "Убежать! + 30 к славе","callBack4"));
        }

        if (getCallbackQueryButtonKey().equals("callBack4")) {

            sendTextMessageAsync(STEP_5_TEXT,
                    Map.of("Включить и надеть GoPro", "callBack5"));
        }

        if (getCallbackQueryButtonKey().equals("callBack5")) {
            addUserGlory(30);

            sendTextMessageAsync(STEP_6_TEXT,
                    Map.of( "Снять видео еды! + 40 к славе" , "callBack6",
                            "Снять видео пылесоса! + 40 к славе" , "callBack6",
                            "Снать видео себч! + 40 к славе" , "callBack6"));
        }

        if (getCallbackQueryButtonKey().equals("callBack6")) {

            sendTextMessageAsync(STEP_7_TEXT,
                    Map.of("Взломать пароль от компьютера", "callBack7"));
        }

        if (getCallbackQueryButtonKey().equals("callBack7")) {
            addUserGlory(50);

            sendTextMessageAsync(STEP_8_TEXT,
                    Map.of("Выложить ведео в Интернет! + 50 к славе", "callBack8"));
        }

        if (getCallbackQueryButtonKey().equals("callBack8")) {

            sendTextMessageAsync(FINAL_TEXT);
        }

    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}
//        if (getMessageText().equals("/start")) {
//                sendTextMessageAsync("HiHi");
//                }
//                if (getMessageText().equals("/buy")) {
//                sendTextMessageAsync("Asta la vista, baby!");
//                }
//
//                if (getMessageText().contains("cat")) {
//                sendTextMessageAsync("Ваше любимое животное? ",
//                Map.of("Кот", "callbackCat",
//                "Собака", "callbackDog"));
//
//                }
//                if (getCallbackQueryButtonKey().equals("callbackCat")) {
//                sendPhotoMessageAsync("step_4_pic");
//                } else if (getCallbackQueryButtonKey().equals("callbackDog")) {
//                sendPhotoMessageAsync("step_6_pic");
//                }
//
//
//                if (getMessageText().equals("Smile")) {
//                var msg = getLastSentMessage();
//                editTextMessageAsync(msg.getMessageId(), msg.getText() + " :-) ");
//                }