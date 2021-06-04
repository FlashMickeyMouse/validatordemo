package xin.kingsman.validatordemo.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 目录
 * @author songhao
 */
@Data
public class BookDirectory {



    /**
     * 悯农
     */
    @NotNull
    private String name;

    /**
     * 18页
     */
    @NotNull
    private Integer pageNum;
}
