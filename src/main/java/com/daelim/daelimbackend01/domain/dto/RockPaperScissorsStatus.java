package com.daelim.daelimbackend01.domain.dto;

public enum RockPaperScissorsStatus {
    ROCK("바위"), PAPER("보자기"), SCISSORS("가위");

    private final String korean;

    RockPaperScissorsStatus(String korean) {
        this.korean = korean;
    }

    public String getKorean() {
        return korean;
    }
}
