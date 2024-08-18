package com.learnreactiveprogramming.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class FluxAndMonoGeneratorService {

    public Flux<String> nameFlux(){
        return Flux.fromIterable(List.of("alex","ben","chloe"));
    }

    public Mono<String> nameMono(){
        return Mono.just("alex");
    }

    public Flux<String> nameFlux_map(){

        return Flux.fromIterable(List.of("alex","ben","chloe"))
                .map(String::toUpperCase);
    }

    public static void main(String[] args) {

        FluxAndMonoGeneratorService fluxAndMonoGeneratorService = new FluxAndMonoGeneratorService();

        fluxAndMonoGeneratorService.nameFlux()
                .subscribe(name -> {
                    System.out.println("Name is : "+name);
                });

        fluxAndMonoGeneratorService.nameMono()
                .subscribe(name ->
                        System.out.println("Mono name is :" +name)
                );

        fluxAndMonoGeneratorService.nameFlux_map()
                .subscribe(name ->
                        System.out.println("Name using map : "+name)
                );

    }

}


