package br.com.contmatic.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

/**
 * The Class ValidadorAnnotionsMsgErro.
 */
public class ValidadorAnnotations {
 
	/**
     * Return annotation msg error.
     *
     * @param t the t
     * @return the string
     */
    public static boolean returnAnnotationMsgError(Object t) {
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Object>> erros = validador.validate(t);
        List<String> errosMsg = new ArrayList<>();
        for(ConstraintViolation<Object> violation : erros) {
            errosMsg.add(violation.getMessage());
        }
        String verificaErros = errosMsg.toString().replace("[", "").replace("]", "");
        if ((!(verificaErros.isEmpty() || verificaErros.length() < 2 ))) {
            return true;
        } else {
            return false;
        }
    }
}