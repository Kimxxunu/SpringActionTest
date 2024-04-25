package Nosunwoo.NiceTest.test.chatting.entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "chat_messages")
public class ChatMessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int messageId;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private Timestamp time;

    @ManyToOne // 다대일 관계를 나타냄
    @JoinColumn(name = "user_id", nullable = false) // 외래 키 매핑
    private UsersEntity userId;

    @ManyToOne // 다대일 관계를 나타냄
    @JoinColumn(name = "roomId", nullable = false) // 외래 키 매핑
    private ChatRoomEntity roomId;


}