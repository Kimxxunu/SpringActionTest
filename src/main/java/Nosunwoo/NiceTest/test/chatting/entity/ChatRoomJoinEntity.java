package Nosunwoo.NiceTest.test.chatting.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "chat_room_join")
public class ChatRoomJoinEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long join_id;

    @Column(nullable = false)
    private Long user_id;

    @Column(nullable = false)
    private Long room_id;


}