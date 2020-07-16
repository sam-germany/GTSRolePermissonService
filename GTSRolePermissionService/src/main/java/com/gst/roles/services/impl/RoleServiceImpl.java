package com.gst.roles.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gst.roles.dto.RoleDto;
import com.gst.roles.entity.RoleEntity;
import com.gst.roles.repositories.RoleRepository;
import com.gst.roles.services.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	
	@Autowired
	RoleRepository roleRepo;
	
	@Override
	public RoleDto createRole(RoleDto roleDto) {
	
		if(roleRepo.findByName(roleDto.getGts_role_name()) != null) return null;
		
		ModelMapper modelMapper = new ModelMapper();
		RoleEntity roleEntity = modelMapper.map(roleDto, RoleEntity.class);
		
		RoleEntity createdRole = roleRepo.save(roleEntity);
		   
		return modelMapper.map(createdRole, RoleDto.class);
	}
	
	

	@Override
	public RoleDto getRoleById(long gts_role_id) {
        RoleDto returnValue = new RoleDto();
        
        
        RoleEntity roleEntity = roleRepo.findById(gts_role_id).get();
         
        if(roleEntity == null) return null;
        
		return new ModelMapper().map(roleEntity, RoleDto.class);
	}

	@Override
	public RoleDto updateRoleById(long gts_role_id, RoleDto roleDto) {
         
		RoleDto returnValue = new RoleDto();
        RoleEntity roleEntity = roleRepo.findById(gts_role_id).get(); 
		
        if(roleEntity == null) return null;
        
        roleEntity.setGts_role_name(roleDto.getGts_role_name());
        roleEntity.setGts_role_description(roleDto.getGts_role_description());
        roleEntity.setGts_role_status(roleDto.isGts_role_status());
		
        RoleEntity updatedRole = roleRepo.save(roleEntity);
        
		return new ModelMapper().map(updatedRole, RoleDto.class);
	}

	@Override
	public RoleDto deleteRoleById(long gts_role_id) {
		
		RoleDto returnValue = new RoleDto();
		RoleEntity roleEntity = roleRepo.findById(gts_role_id).get();
		
		if(roleEntity == null) return null;
		
		if(roleEntity.isGts_role_status() == false) return null;
		
		roleEntity.setGts_role_status(false);
		
		RoleEntity updatedRole = roleRepo.save(roleEntity);
		
		return  new ModelMapper().map(updatedRole, RoleDto.class);
	}

	@Override
	public List<RoleDto> getAllRoles(int page, int limit) {
    List<RoleDto> returnValue = new ArrayList<>();
    
    if(page > 0) page -=1;
    
    Pageable pageableRequest = PageRequest.of(page, limit);
    
    Page<RoleEntity> rolesPage = roleRepo.findAll(pageableRequest);
    
    if(rolesPage == null) return null;
    
    List<RoleEntity> roles = rolesPage.getContent();
    
    for(RoleEntity roleEntity :roles) {
    	returnValue.add(new ModelMapper().map(roleEntity, RoleDto.class));
    }
    
		return returnValue;
	}

	
	
	@Override
	public RoleDto getRoleByName(String gts_role_name) {
		
		RoleDto returnValue = new RoleDto();
	        
	        RoleEntity roleEntity = roleRepo.findByName(gts_role_name);
	         
	        if(roleEntity == null) return null;
	        
			return new ModelMapper().map(roleEntity, RoleDto.class);
		}
	
	
	
	
}
