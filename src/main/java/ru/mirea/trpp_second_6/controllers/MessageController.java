package ru.mirea.trpp_second_6.controllers;

import com.opencsv.bean.CsvToBeanBuilder;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

/** Контроллер для работы с сообщениями. */
@Controller("/message")
public class MessageController {

    /** Список сообщений. */
    private final List<Message> messageList;

    /** Конструктор. */
    public MessageController() {
        messageList = new CsvToBeanBuilder<Message>(new InputStreamReader(this.getClass().getResourceAsStream("/MOCK_DATA.csv"))).withType(Message.class).build().parse();
    }

    /**
     * Получить список сообщений.
     * @return список сообщений
     */
    @Get()
    public HttpResponse<List<Message>> getMessages() {
        return HttpResponse.ok(messageList);
    }

    /**
     * Найти сообщение по идентификатору.
     * @param id идентификатор сообщения
     * @return Сообщение, если есть, иначе 404 ошибка
     */
    @Get("/{id}")
    public HttpResponse<Message> findById(Long id) {
        Optional<Message> result = messageList.stream().filter(it -> it.getId().equals(id)).findAny();
        if (result.isPresent()) {
            return HttpResponse.ok(result.get());
        } else {
            return HttpResponse.notFound();
        }
    }
}
