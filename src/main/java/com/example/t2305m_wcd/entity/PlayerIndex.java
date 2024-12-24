package com.example.t2305m_wcd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PlayerIndex {
    private Long id;
    private Long playerId;
    private Long indexId;

    private Float value;
}
