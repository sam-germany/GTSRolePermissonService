package com.gst.roles.controllers;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gst.roles.dto.RoleDto;
import com.gst.roles.requests.RoleRequestModel;
import com.gst.roles.responses.JsonResponseModel;
import com.gst.roles.responses.RoleResponseModel;
import com.gst.roles.services.RoleService;

@RestController
@RequestMapping("roles")
public class RoleController {

	
	@Autowired
	RoleService roleService;
	
	@PostMapping( produces = { MediaType.APPLICATION_JSON_VALUE })
	public JsonResponseModel createRole(@RequestBody RoleRequestModel roleRequestModel) {
		
		JsonResponseModel returnValue = new JsonResponseModel();
		 
		 ModelMapper modelMapper = new ModelMapper();
		 RoleDto roleDto = modelMapper.map(roleRequestModel, RoleDto.class);
		 
		 roleDto = roleService.createRole(roleDto);

		  if(roleDto== null) {
			    returnValue.setSuccess("false");
			    returnValue.setMessage("role can not be created");
			    returnValue.setStatus_code("500");
	       }else {
	    	   returnValue.setSuccess("true");
			    returnValue.setMessage("role is created");
			    returnValue.setStatus_code("200"); 
	       }
	       
	    return returnValue;
	  }
	
	
	
	 @GetMapping(path="/{id}" , produces = { MediaType.APPLICATION_JSON_VALUE })
     public <T> T	findRolebyId(@PathVariable long id) {
		 
		 RoleResponseModel returnValue = new RoleResponseModel();
		 JsonResponseModel returnValue2 = new JsonResponseModel();

		 RoleDto  roleDto  = roleService.getRoleById(id);
		 
		 if(roleDto == null) {
			    returnValue2.setSuccess("false");
			    returnValue2.setMessage("no record found");
			    returnValue2.setStatus_code("500");
			   
			  return (T) returnValue2;  
		   }
        
		 
		 return (T) new ModelMapper().map(roleDto, RoleResponseModel.class);
	 }
	
	

     @PutMapping(path="/{id}" , produces = { MediaType.APPLICATION_JSON_VALUE })
	 public JsonResponseModel updateRoleById (@PathVariable long id , @RequestBody RoleRequestModel roleRequestModel) {
		 
    	 JsonResponseModel returnValue = new JsonResponseModel();
		 
		 ModelMapper modelMapper = new ModelMapper();
		 RoleDto roleDto = modelMapper.map(roleRequestModel, RoleDto.class);
		 
		 roleDto = roleService.updateRoleById(id, roleDto);
		 
		 if(roleDto== null) {
			    returnValue.setSuccess("false");
			    returnValue.setMessage("role can not be updated");
			    returnValue.setStatus_code("500");
	       }else {
	    	   returnValue.setSuccess("true");
			    returnValue.setMessage("role is updated");
			    returnValue.setStatus_code("200"); 
	       }
	       
	    return returnValue;
	  }

     
     
     @GetMapping (produces = { MediaType.APPLICATION_JSON_VALUE })
     public  <T> T getAllRoles(@RequestParam(value= "page", defaultValue = "0") int page,
    		                          @RequestParam(value="limit", defaultValue = "25") int limit){
    	 
    	 List<RoleResponseModel> returnValue  = new ArrayList<>();
    	 JsonResponseModel returnValue2 = new JsonResponseModel();
    	 
    	 List<RoleDto> allRoles = roleService.getAllRoles(page, limit);
    	 
    	 if(allRoles == null) {
    		 returnValue2.setSuccess("false");
 		     returnValue2.setMessage("no record found");
 		     returnValue2.setStatus_code("500");
			   
			  return (T) returnValue2;  
		   }
    	 for(RoleDto roleDto : allRoles) {
    		 returnValue.add(new ModelMapper().map(roleDto, RoleResponseModel.class));
    	 }
    	 
    	 return (T) returnValue;
     }
     
     @DeleteMapping(path = "/{id}"  , produces = { MediaType.APPLICATION_JSON_VALUE })
     public JsonResponseModel deletRole(@PathVariable long id) {
    	 
    	 JsonResponseModel returnValue = new JsonResponseModel();
    	 
    	 RoleDto roleDto = roleService.deleteRoleById(id);
    	 
    	  if(roleDto == null) {
			    returnValue.setSuccess("false");
			    returnValue.setMessage("role can not be deleted");
			    returnValue.setStatus_code("500");
	       }else {
			   returnValue.setSuccess("true");
			   returnValue.setMessage("role  deleted szccessfully");
			   returnValue.setStatus_code("200"); 
	       }
		   
		   return returnValue;
     }
     
     @GetMapping(path="/findByName/{gts_role_name}" , produces = { MediaType.APPLICATION_JSON_VALUE })
     public <T> T	findRolebyName(@PathVariable String gts_role_name) {
    	 
		 RoleResponseModel returnValue = new RoleResponseModel();
		 JsonResponseModel returnValue2 = new JsonResponseModel();
		 
        RoleDto  roleDto  = roleService.getRoleByName(gts_role_name);
        
        if(roleDto == null) {
		    returnValue2.setSuccess("false");
		    returnValue2.setMessage("no record found");
		    returnValue2.setStatus_code("500");
		   
		  return (T) returnValue2;  
	   }
    
		 return (T) new ModelMapper().map(roleDto, RoleResponseModel.class);
	 }
     
     
	 }









