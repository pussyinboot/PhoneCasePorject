package org.example.models;

import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@Entity
@Table(name = "CUSTOMER" )
@Builder
@AllArgsConstructor
@NoArgsConstructor //이걸 안 적었구나
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerNo")
    private Long CustomerNo;

    //PK가 아닌 아이디, 비밀번호의 아이디
    @Column(unique = true, name = "Customerid", nullable = false)
    private String Customerid;
    @Column(name = "CustomerPassword", nullable = false)
    private String CustomerPassword;
    @Column(name = "CustomerName", nullable = false)
    private String CustomerName;
    @Column(name = "PhoneNumber", nullable = false)
    private String PhoneNumber;
    @Column(unique = true, name = "Email", nullable = false)
    private String Email;
}
