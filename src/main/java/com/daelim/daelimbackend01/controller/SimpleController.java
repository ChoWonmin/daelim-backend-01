package com.daelim.daelimbackend01.controller;

import com.daelim.daelimbackend01.domain.dto.*;
import com.daelim.daelimbackend01.service.SimpleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

@RestController
@RequiredArgsConstructor
public class SimpleController {
    private final SimpleService simpleService;

    @GetMapping("/hello")
    public String hello() {
        return simpleService.hello();
    }

    // HTTP 통신
    // http method : GET, POST, DELETE, PUT, PATCH ...

    // http://localhost:8080/hello-with-name/wonmin123
    @GetMapping("/hello-with-name/{name}")
    public String helloByPathVariable(@PathVariable String name) {
        return simpleService.helloByPathVariable(name);
    }

    // http://localhost:8080/hello-by-request-param?name=wonmin
    @GetMapping("/hello-by-request-param")
    public String helloByRequestParam(@RequestParam String name) {
        return "Hello World!!! " + name;
    }

    // path variable
    // year , name 클라이언트한테 받아서
    // 응답 : "${year}년 ${name}님. Hello!"
    // http://localhost:8080/hello-with-year/2026/wonmin
    @GetMapping("/hello-with-year/{year}/{name}")
    public String helloWithYear(
            @PathVariable Long year,
            @PathVariable String name) {
        return simpleService.helloWithYear(year, name);
    }

    // localhost:8080/hello-with-year-by-request-param?name=wonmin&year=2026
    @GetMapping("/hello-with-year-by-request-param")
    public String helloWithYearByRequestParam(
            @RequestParam Long year,
            @RequestParam String name) {
        return simpleService.helloWithYearByRequestParam(year, name);
    }

    // localhost:8080/hello-by-dto?name=wonmin&year=2026
    @GetMapping("hello-by-dto")
    public String helloByDto(YearNameDto yearNameDto) {
        return simpleService.helloByDto(yearNameDto);
    }

    // get method api 1개
    // 로또 번호 추첨
    // 1~45 , 6개
    // 요청 : long min , max, number
    // 응답 : string 1,2,3,4 ... [1, 2, 3, 4]
    // min~max 숫자 중에 number개 랜덤 출력

    // 번호 중복 처리는 무시 (선택사항)
    // 예외처리 (선택사항)
    // - max보다 number가 큰 경우..
    // - min이 max보다 큰 경우..
    // - min, max, number가 1 미만인 경우
    // http://localhost:8080/get-lotto
    @GetMapping("/get-lotto")
    public String getLotto(LottoDto lottoDto) {
        return simpleService.getLotto(lottoDto);
    }

    @PostMapping("/get-random")
    public String getRandom() {
        return simpleService.getRandom();
    }

    // http://localhost:8080/play-rock-paper-scissors
    @PostMapping("/play-rock-paper-scissors")
    public PlayRockPaperScissorsResDto playRockPaperScissors(
            @RequestBody PlayRockPaperScissorsReqDto playRockPaperScissorsReqDto
    ) {
        String result = simpleService.playRockPaperScissors(playRockPaperScissorsReqDto);
        return new PlayRockPaperScissorsResDto(result);
    }

}
