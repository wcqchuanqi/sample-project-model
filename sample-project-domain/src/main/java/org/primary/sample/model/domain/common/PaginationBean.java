package org.primary.sample.model.domain.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * 分页数据封装
 *
 * @author wangchuanqi
 * @version 0.0.1
 * @since 2020/12/22
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaginationBean<T> {
    /**
     * 总数量.
     */
    private Long totalCount;
    /**
     * 数据列表.
     */
    private List<T> dataList;
}
