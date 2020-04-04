package model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "`order`")
@Data
@EqualsAndHashCode(exclude = {"products", "user"})
@ToString(exclude = {"products", "user"})
public class Order implements ModelClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORD_ID")
    private int id;
    @Column(name = "ORD_DATE")
    private LocalDateTime orderDate;
    @Column(name = "ORD_PRICE")
    private BigDecimal orderPrice;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORD_USR_ID", referencedColumnName = "USR_ID")
    private User user;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "cart",
    joinColumns = {@JoinColumn(name = "CRT_PRO_ID")},
    inverseJoinColumns = {@JoinColumn(name = "CRT_ORD_ID")})
    private Set<Product> products = new HashSet<>();


}
