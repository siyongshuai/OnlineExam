package haue.edu.cn.dao;

import haue.edu.cn.model.PaperDetail;

public interface PaperDetailMapper {
    int insert(PaperDetail record);

    int insertSelective(PaperDetail record);
}