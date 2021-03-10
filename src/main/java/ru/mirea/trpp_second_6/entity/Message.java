package ru.mirea.trpp_second_6.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/** Сущность сообщения. */
@Getter
@Setter
@ToString
public class Message {

    /** Идентификатор. */
    @JsonProperty("id")
    @CsvBindByName(column = "id")
    private Long id;
    /** Идентификатор отправителя. */
    @JsonProperty("sender_id")
    @CsvBindByName(column = "sender_id")
    private String senderId;
    /** Идентификатор получателя. */
    @JsonProperty("receiver_id")
    @CsvBindByName(column = "receiver_id")
    private String receiverId;
    /** Текст. */
    @JsonProperty("text")
    @CsvBindByName(column = "text")
    private String text;
    /** Дата отправки. */
    @JsonProperty("created")
    @CsvBindByName(column = "created")
    private String created;

}
