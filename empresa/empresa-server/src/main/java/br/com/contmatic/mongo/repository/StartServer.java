package br.com.contmatic.mongo.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StartServer {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(StartServer.class);

    public static String start(final String comando) throws IOException {
        Process p = Runtime.getRuntime().exec(comando);
        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));

        String lineOut;
        while ((lineOut = input.readLine()) != null) {
           LOGGER.info(lineOut);
        }
        input.lines(); 
        input.close();
        return "SERVIDOR INICIADO COM SUCESSO!";
    }
}
