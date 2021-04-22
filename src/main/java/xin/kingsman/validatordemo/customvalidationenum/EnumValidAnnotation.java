package xin.kingsman.validatordemo.customvalidationenum;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;


/**
 * @Description   :  通过让枚举类继承一个接口实现通用的枚举校验器，堪称完美设计
 * @Author        :  song_hao
 * @CreateDate    :  2019/9/27 12:00
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EnumValidAnnotation.IdentityTypeEnumValidator.class})
@Documented
public @interface EnumValidAnnotation {
    String message() default "非法的枚举值类型";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    Class<?>[] value();

    class IdentityTypeEnumValidator implements ConstraintValidator<EnumValidAnnotation, CanBeValidEnum> {

        Class<?>[] cls; //枚举类

        @Override
        public void initialize(EnumValidAnnotation constraintAnnotation) {
            cls = constraintAnnotation.value();
        }

        @Override
        public boolean isValid(CanBeValidEnum value, ConstraintValidatorContext context) {
            if (cls.length > 0) {
                for (Class<?> cl : cls) {

                    if (cl.isEnum()) {
                        //枚举类验证
                        Object[] values = cl.getEnumConstants();
                        for (Object v : values) {
                            if (v.equals(value)){
                                return true;
                            }

                        }
                    }

                }
            }
            return false;
        }
    }
}