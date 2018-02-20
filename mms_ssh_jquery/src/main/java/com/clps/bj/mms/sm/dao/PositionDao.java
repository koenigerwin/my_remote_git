package com.clps.bj.mms.sm.dao;

import java.util.List;

import com.clps.bj.mms.sm.entity.Position;

/**
 * 
 * @description：职位实体层接口
 * @className：PositionDao
 * @author ygg
 * @version V1.0.0
 * 2018年1月19日 下午3:41:07
 */
public interface PositionDao {
	
	/**
	 * 
	 * @Description:根据职位Id获取对象信息
	 * @param positionId position's id
	 * @return position
	 * @throws Exception 
	 *
	 */
    public Position queryPositionById(Integer positionId) throws Exception;
    /**
     * 
     * @Description:根据职位名或Email 获取职位对象信息
     * @param name
     * @return position
     *
     */
    public Position queryPositionByName(String name);
    /**
     * 
     * @Description:新增职位对象数据
     * @param position
     * @throws Exception 
     *
     */
    public boolean addPosition(Position position) throws Exception;
    /**
     * 
     * @Description:根据ID删除职位信息
     * @param positionId 职位编号
     * @return boolean true 删除成功 false 删除失败
     * @throws Exception 
     *
     */
    public boolean deletePositionById(Integer positionId) throws Exception;
    /**
     * 
     * @Description:根据ID更新职位信息
     * @param position
     * @return boolean
     * @throws Exception 
     *
     */
    public boolean updatepositionById(Position position) throws Exception;
    /**
     * 
     * @Description:查询所有职位信息
     * @return List<position>
     * @throws Exception 
     *
     */
    public List<Position> queryAllpositions() throws Exception;
}
