package Nosunwoo.NiceTest.test.chatting.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@Table(name = "chat_room_join")
public class ChatRoomJoinEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int joinId;

    @ManyToOne // 다대일 관계를 나타냄
    @JoinColumn(name = "userId", nullable = false) // 외래 키 매핑
    private UsersEntity userId;

    @ManyToOne // 다대일 관계를 나타냄
    @JoinColumn(name = "roomId", nullable = false) // 외래 키 매핑
    private ChatRoomEntity roomId;


}