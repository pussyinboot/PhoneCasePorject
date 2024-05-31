package org.example.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter //이 2개 존나게 편하다//
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "GOODS")
@Builder
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GoodsId", updatable = false)
    private Long Goodsid;
    @Column(name = "GoodsName", nullable = false)
    private String goodsName;
    @Column(name = "GoodsCode", nullable = false)
    private String goodsCode;
    @Column(name = "GoodsStock", nullable = false)
    private int goodsStock;
    @Column(name = "GoodsModel", nullable = false)
    private String goodsModel;
}
