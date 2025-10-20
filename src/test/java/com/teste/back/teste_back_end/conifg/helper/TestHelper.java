package com.teste.back.teste_back_end.conifg.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TestHelper {

    private static final ObjectMapper objectMapper = getMapper();

    private static ObjectMapper getMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }

    @SneakyThrows
    public static byte[] convertObjectToJsonBytes(Object object) {
        return objectMapper.writeValueAsBytes(object);
    }

}
