package ketflix.monolith.user.controller

import RegisterRequest
import UserResponse
import ketflix.monolith.user.services.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService) {
    @PostMapping("/register")
    fun register(@RequestBody request: RegisterRequest): ResponseEntity<UserResponse> {
        val user = userService.register(request)
        return ResponseEntity.ok(user)
    }

//    @PostMapping("/login")
//    fun login(@RequestBody request: LoginRequest, session: HttpSession): ResponseEntity<UserResponse> {
//        val user = userService.login(request)
//        session.setAttribute("userId", user.id)
//        return ResponseEntity.ok(user)
//    }
//
//    @PostMapping("/logout")
//    fun logout(session: HttpSession): ResponseEntity<Void> {
//        session.invalidate()
//        return ResponseEntity.ok().build()
//    }
}