cmake_minimum_required(VERSION 3.21)
project(Programmiermodelle)

set(CMAKE_CXX_STANDARD 14)

include_directories(src)

add_executable(Programmiermodelle
        src/main.cpp
        src/main.h)
