package xin.kingsman.validatordemo.vo;


import lombok.Data;
import xin.kingsman.validatordemo.conzt.BookCategoryEnum;
import xin.kingsman.validatordemo.customvalidationenum.EnumCheck;
import xin.kingsman.validatordemo.validationgroup.BookCreateGroup;
import xin.kingsman.validatordemo.validationgroup.BookUpdateGroup;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

/**
 * 业务类 书
 *
 * @author songhao
 * <p>
 * 创建书 id，书名，作者  BookCreateGroup
 * 更新书 id，书名，作者，出版社，售价，版本  BookUpdateGroup
 * 目录列表 都需要校验 Default
 *
 */
@Data
public class Book {

    /**
     * id
     */
    @NotNull(groups = {BookCreateGroup.class})
    private Integer id;

    /**
     * 书名
     */
    @NotEmpty(groups = {BookCreateGroup.class})
    private String title;

    /**
     * 作者
     */
    @NotEmpty(groups = {BookCreateGroup.class})
    private String author;

    /**
     * 出版社
     */
    @NotEmpty(groups = {BookUpdateGroup.class})
    private String press;

    /**
     * 售价
     */
    @NotNull(groups = {BookUpdateGroup.class})
    private BigDecimal price;

    /**
     * 版本
     */
    @NotEmpty(groups = {BookUpdateGroup.class})
    private String version;


    /**
     * 目录列表
     */
    @Valid
    @NotNull
    @Size(min = 1)
    private List<BookDirectory> bookDirectoryList;

    /**
     * 类别
     *
     * @see BookCategoryEnum
     */
    @EnumCheck(enumClass = BookCategoryEnum.class)
    private Integer categoryEnum;

}