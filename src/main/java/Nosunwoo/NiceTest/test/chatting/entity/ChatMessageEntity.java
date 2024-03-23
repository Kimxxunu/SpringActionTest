package Nosunwoo.NiceTest.test.chatting.entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "chat_messages")
public class ChatMessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long message_id;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private Date time;

    @Column(nullable = false)
    private Long user_id;

    @Column(nullable = false)
    private Long room_id;


}