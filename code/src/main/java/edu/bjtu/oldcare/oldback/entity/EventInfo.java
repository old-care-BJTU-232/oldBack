package edu.bjtu.oldcare.oldback.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "event_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    /**
     * 事件类型
     */
    @Column(name = "event_type")
    private Integer event_type;

    @Column(name = "event_date")
    private Date event_date;

    @Column(name = "event_location")
    private String event_location;

    @Column(name = "event_desc")
    private String event_desc;

//    @ManyToOne //多个事件对象属于同一个老人：
//    @JoinColumn(name="oldperson_id") //指定了外键列： 外键列没有指定name属性，默认名称clz。
    @Column(name = "oldperson_id")
    private Integer oldperson_id;

    @Column(name = "img_url")
    private Integer img_url;
}
