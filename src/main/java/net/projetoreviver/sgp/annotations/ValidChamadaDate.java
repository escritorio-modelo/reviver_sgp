package net.projetoreviver.sgp.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import net.projetoreviver.sgp.annotations.AnnotationImpl.ChamadaDateValidator;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ChamadaDateValidator.class)
@Documented
public @interface ValidChamadaDate {
    String message() default "Data de término tem que ser maior que a data de início";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}