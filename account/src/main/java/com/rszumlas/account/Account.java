package com.rszumlas.account;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Account")
@Table(
        name = "account",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "unique_email_constraint",
                        columnNames = {"email"}
                )
        })
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            name = "id",
            updatable = false,
            columnDefinition = "SERIAL"
    )
    private Long id;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT",
            unique = true
    )
    private String email;

    @Column(
            name = "password",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String password;

    @Column(
            name = "eth_total",
            nullable = false
    )
    private Double eth_total;

}
