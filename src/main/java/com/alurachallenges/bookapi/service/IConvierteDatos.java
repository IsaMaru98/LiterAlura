package com.alurachallenges.bookapi.service;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
