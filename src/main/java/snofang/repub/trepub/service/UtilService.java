package snofang.repub.trepub.service;

import java.lang.reflect.Type;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UtilService {

	
	private ModelMapper modelMapper;
	
	public UtilService() {
		this.modelMapper = new ModelMapper();
	}
	
	public <T> T map(Object source, Type destinType){
		return this.modelMapper.map(source, destinType);
	}
}
