package com.emmutua.util.model

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import java.time.Instant
import java.util.*

val currentUser: FirebaseUser? = FirebaseAuth.getInstance().currentUser
private val currentUserId = currentUser?.uid ?: ""
data class AttachmentLog(
    var id: String = UUID.randomUUID().toString(),
    val studentId: String = currentUserId,
    var title: String = "",
    var description: String = "",
    var images: List<String> = emptyList(),
    var date : Long = Instant.now().toEpochMilli(),
)

