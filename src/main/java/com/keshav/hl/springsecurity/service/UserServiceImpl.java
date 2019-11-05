package com.keshav.hl.springsecurity.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.keshav.hl.springsecurity.config.exception.RecordNotFoundException;
import com.keshav.hl.springsecurity.entity.AddressEntity;
import com.keshav.hl.springsecurity.entity.RoleEntity;
import com.keshav.hl.springsecurity.entity.UserEntity;
import com.keshav.hl.springsecurity.model.AddressDTO;
import com.keshav.hl.springsecurity.model.UserDTO;
import com.keshav.hl.springsecurity.repository.RoleRepository;
import com.keshav.hl.springsecurity.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private BCryptPasswordEncoder bryptPasswordEncoder;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	UserEntity userEntity;
	UserDTO userDTO;
	AddressEntity addressEntity;
	List<UserDTO> listOfUserDtos = new ArrayList<>();
	List<RoleEntity> listOfRoles = new ArrayList<>();
	Set<AddressDTO> setofAddressDTO = new HashSet<>();
	Set<AddressEntity> listOfAddressEntity = new HashSet<>();

	@Override
	public UserDTO createUser(UserDTO userDTO) {
		userEntity = new UserEntity();
		setofAddressDTO = userDTO.getAddress();

		if (!ObjectUtils.isEmpty(userDTO)) {
			if (!ObjectUtils.isEmpty(setofAddressDTO)) {
				for (AddressDTO addressDTO : setofAddressDTO) {
					addressEntity = new AddressEntity();
					BeanUtils.copyProperties(addressDTO, addressEntity);
					addressEntity.setAddressID(UUID.randomUUID());
					listOfAddressEntity.add(addressEntity);
				}
			}

			if (!ObjectUtils.isEmpty(userDTO.getRoleName())) {
				listOfRoles = roleRepository.findAllRoleNameIn(userDTO.getRoleName());
				if (!ObjectUtils.isEmpty(listOfRoles)) {
					userEntity.setRoles(listOfRoles);
				}
			}
			BeanUtils.copyProperties(userDTO, userEntity);
			userEntity.setUserId(UUID.randomUUID());
			userEntity.setAddress(listOfAddressEntity);
			userEntity.setCreatedOn(new Date());
			userEntity.setRowStatus(1);
			userEntity.setPassword(bryptPasswordEncoder.encode(userDTO.getPassword()));
			UserEntity newUserEntity = userRepository.save(userEntity);
			userDTO = new UserDTO();
			BeanUtils.copyProperties(newUserEntity, userDTO);
		}
		return userDTO;

	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<UserEntity> listOfuserEntity = userRepository.findAll();
		if(!ObjectUtils.isEmpty(listOfuserEntity)) {
			for(UserEntity userEntity:listOfuserEntity) {
				userDTO = new UserDTO();
				BeanUtils.copyProperties(userEntity, userDTO);
				listOfUserDtos.add(userDTO);
			}
		}
		return listOfUserDtos;
	}
	
	@Override
	public List<UserDTO> getUserByUserName(String userName) {
		List<UserDTO> listOfUserDto = null;
		if (!StringUtils.isEmpty(userName)) {

			List<UserEntity> listOfuserEntity = userRepository.findByUsername(userName);
			if (!ObjectUtils.isEmpty(listOfuserEntity)) {
				 listOfUserDto = new ArrayList<>();
				for (UserEntity userEntity : listOfuserEntity) {
					userDTO = new UserDTO();
					BeanUtils.copyProperties(userEntity, userDTO);
					listOfUserDto.add(userDTO);
				}
			}else {
				
			}
		} else {
			List<UserEntity> listOfuserEntity = userRepository.findAll();
			if (!ObjectUtils.isEmpty(listOfuserEntity)) {
				 listOfUserDto = new ArrayList<>();
				for (UserEntity userEntity : listOfuserEntity) {
					userDTO = new UserDTO();
					BeanUtils.copyProperties(userEntity, userDTO);
					listOfUserDto.add(userDTO);
				}
			}
		}

		return listOfUserDto;

	}

}
