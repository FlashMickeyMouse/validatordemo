package xin.kingsman.validatordemo.customvalidationenum;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * @author songhao
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EnumCheck.EnumCheckValidator.class)
public @interface EnumCheck {
    /**
     * 是否必填 默认是必填的
     *
     * @return
     */
    boolean required() default true;

    /**
     * 验证失败的消息
     *
     * @return
     */
    String message() default "枚举的验证失败";

    /**
     * 分组的内容
     *
     * @return
     */
    Class<?>[] groups() default {};

    /**
     * 错误验证的级别
     *
     * @return
     */
    Class<? extends Payload>[] payload() default {};

    /**
     * 枚举的Class
     *
     * @return
     */
    Class<? extends Enum<?>> enumClass();

    /**
     * 枚举中的验证方法
     *
     * @return
     */
    String enumMethod() default "validation";


    /**
     * 验证方法
     */
    class EnumCheckValidator implements ConstraintValidator<EnumCheck, Object> {
        private EnumCheck enumCheck;

        @Override
        public void initialize(EnumCheck enumCheck) {
            this.enumCheck = enumCheck;
        }

        @Override
        public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
            // 注解表明为必选项 则不允许为空，否则可以为空
            if (value == null) {
                return !this.enumCheck.required();
            }
            //最终的返回结果
            Boolean result = Boolean.FALSE;
            // 获取 参数的数据类型
            Class<?> valueClass = value.getClass();
            try {
                Method method = this.enumCheck.enumClass().getMethod(this.enumCheck.enumMethod(), valueClass);
                result = (Boolean) method.invoke(null, value);
                result = result == null ? false : result;
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            return result;

        }
    }
}