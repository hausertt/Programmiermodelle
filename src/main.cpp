//
// Created by hato0 on 12.04.2022.
//

#include <iostream>
#include <cassert>
#include "main.h"

/*
 * g(1) = 1
 * g(2) = 2
 * g(3) = 8
 * g(4) = 50
 * g(5) = 1202
 */


int g_rekursiv(int n){
    if(n<=2){
        return n;
    }
    return 2+3* g_rekursiv(n-1)* g_rekursiv(n-2);
}

int g_iterativ(int n) {
    if(n<=2){
        return n;
    }
    int gMinusTwo = 1;
    int gMinusOne = 2;
    for(int i=3;i<=n;i++) {
        int result_old = gMinusOne;
        gMinusOne = 2+3*gMinusOne*gMinusTwo;
        gMinusTwo = result_old;
    }
    return gMinusOne;
}

int g_help(int n, int g_old, int g_old_old ) {
    if(n<=1) {
        return g_old;
    }
    else {
        return g_help(n-1,2+3*g_old*g_old_old,g_old);
    }
}

int g(int n) {
    if(n==0){
        return 0;
    }
    return  g_help(n,1,0);
}

void g_rekursiv_test(){
    assert(g_rekursiv(0) == 0);
    assert(g_rekursiv(1) == 1);
    assert(g_rekursiv(2) == 2);
    assert(g_rekursiv(3) == 8);
    assert(g_rekursiv(4) == 50);
    assert(g_rekursiv(5) == 1202);
}

void g_iterativ_test() {
    assert(g_iterativ(0) == 0);
    assert(g_iterativ(1) == 1);
    assert(g_iterativ(2) == 2);
    assert(g_iterativ(3) == 8);
    assert(g_iterativ(4) == 50);
    assert(g_iterativ(5) == 1202);
}

void g_endrekursiv_test() {
    assert(g(0) == 0);
    assert(g(1) == 1);
    assert(g(2) == 2);
    assert(g(3) == 8);
    assert(g(4) == 50);
    assert(g(5) == 1202);
}

int main(){
    std::cout << "starting main..." << std::endl;
    g_rekursiv_test();
    std::cout << "g_rekursiv_test() passed" << std::endl;
    g_iterativ_test();
    std::cout << "g_iterativ_test() passed" << std::endl;
    g_endrekursiv_test();
    std::cout << "g_endrekursiv_test() passed" << std::endl;
    std::cout << "main passed..." << std::endl;
}