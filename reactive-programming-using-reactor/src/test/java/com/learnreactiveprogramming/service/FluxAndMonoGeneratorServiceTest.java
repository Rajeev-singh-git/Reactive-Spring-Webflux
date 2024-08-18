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
        var nameFlux = fluxAndMonoGeneratorService.nameFlux_map();

        StepVerifier.create(nameFlux)
                .expectNext("ALEX","BEN","CHLOE")
                .verifyComplete();
    }
}