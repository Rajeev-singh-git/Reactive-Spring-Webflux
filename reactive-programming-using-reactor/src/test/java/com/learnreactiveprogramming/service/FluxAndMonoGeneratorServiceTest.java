package com.learnreactiveprogramming.service;


import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;


class FluxAndMonoGeneratorServiceTest {

    FluxAndMonoGeneratorService fluxAndMonoGeneratorService = new FluxAndMonoGeneratorService();

    @Test
    void namFlux() {
        var nameFlux = fluxAndMonoGeneratorService.nameFlux();

        StepVerifier.create(nameFlux)
                .expectNext("alex")
                .expectNextCount(2)
                .verifyComplete();
    }


    @Test
    void nameFlux_map() {

        //given
        int stringLength = 3;

        //when
        var nameFlux = fluxAndMonoGeneratorService.nameFlux_map(stringLength);

        //then
        StepVerifier.create(nameFlux)
                .expectNext("4-ALEX","5-CHLOE")
                .verifyComplete();
    }

    @Test
    void nameFlux_immutability(){
        var namesFlux = fluxAndMonoGeneratorService.nameFlux_immutability();

        StepVerifier.create(namesFlux)
                .expectNext("alex","ben","chloe")
                .verifyComplete();
    }
}