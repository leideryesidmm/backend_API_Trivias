package com.gamegenius.trivia.mapper;

public interface IMapper <I, O>{
    public O map(I in);
    public I map2(O in);

}