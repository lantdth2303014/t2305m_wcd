package com.example.t2305m_wcd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Indexer {
    private Long indexId;
    private String name;
    private Float valueMin;
    private Float valueMax;
}
