package ketflix.monolith.user.services

import LoginRequest
import RegisterRequest
import UserResponse
import org.springframework.stereotype.Service

@Service
class UserService {
    fun register(request: RegisterRequest): JwtResponse {
        // Registration logic...
        val user = /* create and save user */
        val token = jwtUtil.generateToken(user)
        return JwtResponse(token)
    }

    fun login(request: LoginRequest): JwtResponse {
        // Authentication logic...
        val user = /* authenticate user */
        val token = jwtUtil.generateToken(user)
        return JwtResponse(token)
    }
}