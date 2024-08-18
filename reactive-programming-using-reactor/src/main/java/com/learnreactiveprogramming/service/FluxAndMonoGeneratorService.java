package com.learnreactiveprogramming.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class FluxAndMonoGeneratorService {

    public Flux<String> nameFlux(){
        return Flux.fromIterable(List.of("alex","ben","chloe"));
    }

    public Mono<String> nameMono(){
        return Mono.just("alex");
    }

    public Flux<String> nameFlux_map(int stringLength){

        return Flux.fromIterable(List.of("alex","ben","chloe"))
                .map(String::toUpperCase)
                .filter(s->s.length()>stringLength)
                .map(s-> s.length() + "-"+s);
    }

    public Flux<String> nameFlux_immutability(){
        var namesFlux = Flux.fromIterable(List.of("alex","ben","chloe"));
        namesFlux.map(String::toUpperCase);
        return namesFlux;
    }

    public Flux<String> nameFlux_flatmap(int stringLength){

        return Flux.fromIterable(List.of("alex","ben","chloe"))
                .map(String::toUpperCase)
                .filter(s->s.length()>stringLength)
                .flatMap(s->splitString(s))
                .log();
    }

    public Flux<String> splitString(String name){
        var charArray = name.split("");
        return Flux.fromArray(charArray);
    }


    public Flux<String> namesFlux_flatMap_async(int stringLength){

        return Flux.fromIterable(List.of("alex","ben","chloe"))
                .map(String::toUpperCase)
                .filter(s->s.length()>stringLength)
                .flatMap(s->splitString_withDelay(s))
                .log();
    }

    public Flux<String>splitString_withDelay(String name){
        var charArray = name.split("");
        var delay = new Random().nextInt(1000);
        return Flux.fromArray(charArray)
                .delayElements(Duration.ofMillis(delay));
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

        fluxAndMonoGeneratorService.nameFlux_map(3)
                .subscribe(name ->
                        System.out.println("Name using map : "+name)
                );

    }

}


