package xin.kingsman.validatordemo.conzt;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 图书分类枚举
 *
 * @author songhao
 */
@Getter
@AllArgsConstructor
public enum BookCategoryEnum {
    /**
     * 思辨哲学
     */
    BD(1, "思辨哲学"),
    /**
     * 文明史
     */
    CB(2, "文明史"),
    /**
     * 自然地理
     */
    GB(3, "自然地理");

    private final Integer number;
    private final String name;

    /**
     * 判断值是否满足枚举中的value
     *
     * @param value
     * @return
     */
    public static boolean validation(Integer value) {
        for (BookCategoryEnum categoryEnum : BookCategoryEnum.values()) {
            if (categoryEnum.getNumber().equals(value)) {
                return true;
            }
        }
        return false;
    }
}