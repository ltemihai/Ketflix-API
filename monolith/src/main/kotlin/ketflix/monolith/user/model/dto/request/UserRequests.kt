data class RegisterRequest(val email: String, val password: String, val displayName: String?)
data class LoginRequest(val email: String, val password: String)
data class UserResponse(val id: String, val email: String, val displayName: String?)