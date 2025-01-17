package net.projetoreviver.sgp.annotations.AnnotationImpl;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import net.projetoreviver.sgp.annotations.ValidChamadaDate;
import net.projetoreviver.sgp.models.Chamada;

public class ChamadaDateValidator implements ConstraintValidator<ValidChamadaDate, Object> {
    @Override
    public void initialize(ValidChamadaDate constraintAnnotation){
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        Chamada chamada = (Chamada) obj;
        LocalDate dateInicio = chamada.getDataInicio();
        LocalDate dateFinal = chamada.getDataTermino();
        if (dateInicio == null || dateFinal == null){
            return true;
        }
        int comparacaoDates = dateInicio.compareTo(dateFinal);
       
        if(comparacaoDates >= 0){
            return false;
        }
        return true;
    }
}