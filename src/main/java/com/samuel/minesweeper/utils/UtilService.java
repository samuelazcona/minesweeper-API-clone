package com.samuel.minesweeper.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class UtilService {

    private static final Logger logger = LoggerFactory.getLogger(UtilService.class);


    public static <T> T copyProperties(Object from, Object to, String... attributesToSkip) {

        Set<Field> origenFields = new HashSet<>();
        Set<Field> destinoFields = new HashSet<>();

        Class<?> currentOrigen = from.getClass();
        while (currentOrigen.getSuperclass() != null) {

            origenFields.addAll(createFieldList(currentOrigen, attributesToSkip));

            currentOrigen = currentOrigen.getSuperclass();
        }

        Class<?> currentDestination = to.getClass();
        while (currentDestination.getSuperclass() != null) {

            destinoFields.addAll(createFieldList(currentDestination, attributesToSkip));
            currentDestination = currentDestination.getSuperclass();
        }

        for (Field attributeField : origenFields) {
            attributeField.setAccessible(true);
            for (Field destination : destinoFields) {
                destination.setAccessible(true);
                try {
                    if (destination.getName().equals(attributeField.getName()) && !destination.getName().equals("serialVersionUID")) {
                        logger.info("copy " + attributeField.getName() + " in " + destination.getName());
                        destination.set(to, attributeField.get(from));
                    }
                } catch (IllegalAccessException | IllegalArgumentException ignored) {

                }
            }

        }

        return (T) to;

    }

    private static Set<Field> createFieldList(Class<?> origen, String... attributosOmitir){

        Set<Field> fieldList = new HashSet<>();
        Set<Field> fieldsRemove = new HashSet<>();


        if (attributosOmitir.length > 0) {

            for (Field destinoField : origen.getDeclaredFields()) {
                destinoField.setAccessible(true);
                for (String campoName : attributosOmitir) {
                    if(StringUtils.pathEquals(campoName.toLowerCase(), destinoField.getName().toLowerCase())){
                        fieldsRemove.add(destinoField);
                    }
                }

            }
        }

        fieldList.addAll(Arrays.asList(origen.getDeclaredFields()));
        if(!fieldsRemove.isEmpty()){
            fieldList.removeAll(fieldsRemove);
        }

        return fieldList;

    }
}
