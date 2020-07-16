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

import com.gst.roles.dto.PermissionDto;
import com.gst.roles.requests.PermissionRequestModel;
import com.gst.roles.responses.JsonResponseModel;
import com.gst.roles.responses.PermissionResponseModel;
import com.gst.roles.services.PermissionService;

@RestController
@RequestMapping("permissions")
public class PermissionController {

	@Autowired
	PermissionService permService;
	
	@PostMapping( produces = { MediaType.APPLICATION_JSON_VALUE })
	public JsonResponseModel createPermission(@RequestBody PermissionRequestModel permRequestModel) {
		
		JsonResponseModel returnValue = new JsonResponseModel();
		 
		 ModelMapper modelMapper = new ModelMapper();
		 PermissionDto permissionDto = modelMapper.map(permRequestModel, PermissionDto.class);
		 
		 permissionDto = permService.createPermission(permissionDto);

		 if(permissionDto == null) {
			    returnValue.setSuccess("false");
			    returnValue.setMessage("permission can not be created");
			    returnValue.setStatus_code("500");
	       }else {
	    	   returnValue.setSuccess("true");
			    returnValue.setMessage("permission is created");
			    returnValue.setStatus_code("200"); 
	       }
	       
	    return returnValue;
	  }

	 @GetMapping(path="/{id}" , produces = { MediaType.APPLICATION_JSON_VALUE })
     public <T> T findPermissionById(@PathVariable long id) {
		 
		 PermissionResponseModel returnValue = new PermissionResponseModel();
		 JsonResponseModel returnValue2 = new JsonResponseModel();
		 
        PermissionDto  permissionDto  = permService.getPermissionById(id);
        
        if(permissionDto == null) {
		    returnValue2.setSuccess("false");
		    returnValue2.setMessage("no record found");
		    returnValue2.setStatus_code("500");
		   
		  return (T) returnValue2;  
	   }
        
		 return (T) new ModelMapper().map(permissionDto, PermissionResponseModel.class);
	 }
	 
	 
	 
	 @PutMapping(path="/{id}" , produces = { MediaType.APPLICATION_JSON_VALUE })
	 public JsonResponseModel updateRoleById (@PathVariable long id , @RequestBody PermissionRequestModel permRequestModel) {
		 
		 JsonResponseModel returnValue = new JsonResponseModel();
		 
		 ModelMapper modelMapper = new ModelMapper();
		 PermissionDto permissionDto = modelMapper.map(permRequestModel, PermissionDto.class);
		 
		 permissionDto = permService.updatePermission(id, permissionDto);
 
		 if(permissionDto == null) {
			    returnValue.setSuccess("false");
			    returnValue.setMessage("permission can not be updated");
			    returnValue.setStatus_code("500");
	       }else {
	    	   returnValue.setSuccess("true");
			    returnValue.setMessage("permission is updated");
			    returnValue.setStatus_code("200"); 
	       }
	       
	    return returnValue;
	  }
	
	 
	 
	 @DeleteMapping(path = "/{id}"  , produces = { MediaType.APPLICATION_JSON_VALUE })
     public JsonResponseModel deletRole(@PathVariable long id) {
    
	     JsonResponseModel  returnValue = new JsonResponseModel();
	 
	     PermissionDto permDto = permService.deletePermission(id);
	 
	  if(permDto == null) {
		    returnValue.setSuccess("false");
		    returnValue.setMessage("permission can not be deleted");
		    returnValue.setStatus_code("500");
       }else {
		   returnValue.setSuccess("true");
		   returnValue.setMessage("permission deleted sucessfully");
		   returnValue.setStatus_code("200"); 
       }
	   
	   return returnValue;
         }
	 
	 
	 @GetMapping (produces = { MediaType.APPLICATION_JSON_VALUE })
     public <T> T getAllRoles(@RequestParam(value= "page", defaultValue = "0") int page,
    		                          @RequestParam(value="limit", defaultValue = "25") int limit){
    	 
    	 List<PermissionResponseModel> returnValue  = new ArrayList<>();
    	 JsonResponseModel returnValue2 = new JsonResponseModel();
    	 
    	 List<PermissionDto> allPermissions = permService.getAllPermissions(page, limit);
    	 
    	 if(allPermissions == null) {
    		 returnValue2.setSuccess("false");
 		     returnValue2.setMessage("no records found");
 		     returnValue2.setStatus_code("500");
			   
			  return (T) returnValue2;  
		   }
    	 
    	 for(PermissionDto permissionDto : allPermissions) {
    		 returnValue.add(new ModelMapper().map(permissionDto, PermissionResponseModel.class));
    	 }
    	 
    	 return (T) returnValue;
     }
	 
	 @GetMapping(path="/findByName/{gts_permission_name}" , produces = { MediaType.APPLICATION_JSON_VALUE })
     public <T> T	findRolebyName(@PathVariable String gts_permission_name) {
		 
		 PermissionResponseModel returnValue = new PermissionResponseModel();
		 JsonResponseModel returnValue2 = new JsonResponseModel();
		 
		 PermissionDto  permissionDto  = permService.getPermissionByName(gts_permission_name);
        
		 if(permissionDto == null) {
			    returnValue2.setSuccess("false");
			    returnValue2.setMessage("no record found");
			    returnValue2.setStatus_code("500");
			   
			  return (T) returnValue2;  
		   }
		 
		 
		 
		 return (T) new ModelMapper().map(permissionDto, PermissionResponseModel.class);
	 }
     
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
