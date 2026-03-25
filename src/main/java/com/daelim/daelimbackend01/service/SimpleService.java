package com.daelim.daelimbackend01.service;

import com.daelim.daelimbackend01.domain.dto.LottoDto;
import com.daelim.daelimbackend01.domain.dto.PlayRockPaperScissorsReqDto;
import com.daelim.daelimbackend01.domain.dto.RockPaperScissorsStatus;
import com.daelim.daelimbackend01.domain.dto.YearNameDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Random;

// 비즈니스 로직
@Service
public class SimpleService {

    public String hello() {
        return "Hello World!!!";
    }

    public String helloByPathVariable(String name) {
        return "Hello World!!! " + name;
    }

    public String helloWithYear(Long year, String name) {
        return year + "년 " + name + "님. Hello!";
    }


    public String helloWithYearByRequestParam(Long year, String name) {
        return year + "년 " + name + "님. Hello!";
    }

    public String helloByDto(YearNameDto yearNameDto) {
        return yearNameDto.year() + "년 "
                + yearNameDto.name() + "님. Hello! 여기는 dto야.";
    }

    public String getLotto(LottoDto lottoDto) {
        ArrayList<Long> lottos = new ArrayList<>();

        return "123213213";
    }

    public String getRandom() {
        Random random = new Random();

        return String.valueOf(random.nextInt(10));
    }

    public String playRockPaperScissors(
            PlayRockPaperScissorsReqDto playRockPaperScissorsReqDto
    ) {

        RockPaperScissorsStatus clinetStatus = playRockPaperScissorsReqDto.status();

        Random random = new Random();
        Integer number = random.nextInt(3);
        RockPaperScissorsStatus serverStatus = RockPaperScissorsStatus.ROCK;

        if (number == 0) {
            serverStatus = RockPaperScissorsStatus.ROCK;
        }
        if (number == 1) {
            serverStatus = RockPaperScissorsStatus.PAPER;
        }
        if (number == 2) {
            serverStatus = RockPaperScissorsStatus.SCISSORS;
        }

        // 누가 이겼는지 판별하는 로직
        if (clinetStatus == serverStatus) {
            return "DRAW";
        }

        if (clinetStatus == RockPaperScissorsStatus.SCISSORS) {
            if (serverStatus == RockPaperScissorsStatus.ROCK) {
                return "LOSE";
            }

            if (serverStatus == RockPaperScissorsStatus.PAPER) {
                return "WIN";
            }
        }

        if (clinetStatus == RockPaperScissorsStatus.ROCK) {
            if (serverStatus == RockPaperScissorsStatus.SCISSORS) {
                return "WIN";
            }

            if (serverStatus == RockPaperScissorsStatus.PAPER) {
                return "LOSE";
            }
        }

        if (clinetStatus == RockPaperScissorsStatus.PAPER) {
            if (serverStatus == RockPaperScissorsStatus.SCISSORS) {
                return "LOSE";
            }

            if (serverStatus == RockPaperScissorsStatus.ROCK) {
                return "WIN";
            }
        }

        return "DRAW";
    }
}
