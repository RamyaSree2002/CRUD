package com.userproject1.UserService.service.serviceimpl;

import lombok.AllArgsConstructor;
import com.userproject1.UserService.dto.DepartmentDto;
import com.userproject1.UserService.dto.ResponseDto;
import com.userproject1.UserService.dto.UserDto;
import com.userproject1.UserService.entity.User;
import com.userproject1.UserService.exception.UserNotFoundException;
import com.userproject1.UserService.repository.UserRepository;
import com.userproject1.UserService.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository = null;
    private final RestTemplate restTemplate = new RestTemplate();
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public ResponseDto getUser(Long userId) {
        // Initialize the response DTO
        ResponseDto responseDto = new ResponseDto();

        // Fetch the user from the database with error handling for not found
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + userId));

        // Map the User entity to UserDto
        UserDto userDto = mapToUser(user);

        // Initialize DepartmentDto (it will be populated if the department exists)
        DepartmentDto departmentDto = null;

        // Fetch department information from another service with error handling for RestClientException
        try {
            ResponseEntity<DepartmentDto> responseEntity = restTemplate
                    .getForEntity("http://localhost:8082/api/departments/" + user.getDepartmentId(), DepartmentDto.class);
            departmentDto = responseEntity.getBody();
        } catch (RestClientException e) {
            departmentDto = new DepartmentDto();
            departmentDto.setDepartmentName("Unknown Department");  // Fallback value if the department service is unavailable
        }

        // Set the user and department data in the response DTO
        responseDto.setUser(userDto);
        responseDto.setDepartment(departmentDto);

        return responseDto;
    }

    private UserDto mapToUser(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}

