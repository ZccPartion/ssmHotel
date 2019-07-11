package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.AttributeDao;
import com.pojo.AttributePo;
import com.service.AttributeService;

@Transactional
@Service(value="attributeService")
public class AttributeServiceImpl implements AttributeService {
    
	@Autowired
	private AttributeDao attributeDao;
	
	
	//客房等级
	@Override
	public List<AttributePo> selectGuestRoomLevel() {
		return attributeDao.selectGuestRoomLevel();
	}
   
	//房间状态
	@Override
	public List<AttributePo> selectRoomState() {
		return attributeDao.selectRoomState();
	}
	
    ////商品类别
	@Override
	public List<AttributePo> selectCommodityType() {
		return attributeDao.selectCommodityType();
	}
    
	//计量单位
	@Override
	public List<AttributePo> selectUOM() {
		return attributeDao.selectUOM();
	}

	

	@Override
	public int deleteById(Integer id) {
		return attributeDao.deleteById(id);
	}

	@Override
	public int insertAll(int newid, String newname) {
		return attributeDao.insertAll(newid, newname);
	}

	@Override
	public List<AttributePo> selectTargetType() {
		return attributeDao.selectTargetType();
	}

	@Override
	public List<AttributePo> selectGender() {
		return attributeDao.selectGender();
	}

	@Override
	public List<AttributePo> selectNation() {
		return attributeDao.selectNation();
	}

	@Override
	public List<AttributePo> selectPassengerLevel() {
		return attributeDao.selectPassengerLevel();
	}

	@Override
	public List<AttributePo> selectEducationDegree() {
		return attributeDao.selectEducationDegree();
	}

	@Override
	public List<AttributePo> selectPapers() {
		return attributeDao.selectPapers();
	}

	@Override
	public List<AttributePo> selectThingReason() {
		return attributeDao.selectThingReason();
	}

	@Override
	public List<AttributePo> selectPassengerType() {
		return attributeDao.selectPassengerType();
	}

	@Override
	public List<AttributePo> selectBillUnit() {
		return attributeDao.selectBillUnit();
	}

	@Override
	public List<AttributePo> selectPayWay() {
		return attributeDao.selectPayWay();
	}

	@Override
	public List<AttributePo> selectRentOutType() {
		return attributeDao.selectRentOutType();
	}

	@Override
	public List<AttributePo> selectIsPay() {
		return attributeDao.selectIsPay();
	}

	@Override
	public List<AttributePo> selectPredetermineState() {
		return attributeDao.selectPredetermineState();
	}

}
