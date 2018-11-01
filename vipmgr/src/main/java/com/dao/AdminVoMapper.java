package com.dao;

import com.domain.vo.AdminVo;
import com.domain.vo.AdminVoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface AdminVoMapper {
    long countByExample(AdminVoExample example);

    int deleteByExample(AdminVoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdminVo record);

    int insertSelective(AdminVo record);

    List<AdminVo> selectByExample(AdminVoExample example);

    AdminVo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdminVo record, @Param("example") AdminVoExample example);

    int updateByExample(@Param("record") AdminVo record, @Param("example") AdminVoExample example);

    int updateByPrimaryKeySelective(AdminVo record);

    int updateByPrimaryKey(AdminVo record);
}