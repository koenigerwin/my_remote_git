package com.clps.bj.mms.sm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.bj.mms.sm.dao.PositionDao;
import com.clps.bj.mms.sm.entity.Position;
import com.clps.bj.mms.sm.service.IPositionService;
import com.clps.bj.mms.sm.vo.MyInfo;
import com.clps.bj.mms.sm.vo.PositionInfo;

/**
 * 
 * @description：TODO
 * @className：PositionServiceImpl
 * @author gg Yang
 * @version V1.0.0
 * @date 2018年1月24日下午4:11:54
 */
@Service
public class PositionServiceImpl implements IPositionService {
	@Autowired
	private PositionDao positionDao;        //职位测试类
	
	
	/**
	 * 将数据装载到vo层
	 * @param position
	 * @return
	 */
	public List<PositionInfo> putDataToVo(List<Position> positions,String name){
		
		List<PositionInfo> infos = new ArrayList<>();
		for(Position p:positions){
			PositionInfo info = new PositionInfo();
			info.setId(p.getPositionId());
			info.setName(p.getPositionName());
			info.setCreateDate(p.getPositionCreatedDatetime());
			info.setCreateName(String.valueOf(name));
			info.setDescription(p.getPositionDescription());
			info.setpAbbreviation(p.getPositionAbbreviation());
			
			infos.add(info);
		}
		return infos;
				
	} 
	
	@Override
	public Position queryPositionById(Integer positionId) throws Exception {
		return positionDao.queryPositionById(positionId);
		
	}

	@Override
	public Position queryPositionByName(String name) {
		
		return positionDao.queryPositionByName(name);
	}

	@Override
	public boolean addPosition(Position position) throws Exception {
		
		return positionDao.addPosition(position);
	}

	@Override
	public boolean deletePositionById(Integer positionId) throws Exception {
		
		return positionDao.deletePositionById(positionId);
	}

	@Override
	public boolean updatepositionById(Position position) throws Exception {
		
		return positionDao.updatepositionById(position);
	}

	@Override
	public List<Position> queryAllpositions() throws Exception {
		
		return positionDao.queryAllpositions();
	}

	@Override
	public List<PositionInfo> getAllPositionsVo() throws Exception {
		String name = "ygg";  ///需要调用用户的通过id，来获取姓名的方法
		List<Position> positions = queryAllpositions();
		
		List<PositionInfo> infos = putDataToVo(positions,name);
		return infos;
	}
	
	
	
}
