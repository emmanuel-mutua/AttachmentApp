package com.emmutua.attachmentapp.data.repository

import android.util.Log
import com.emmutua.attachmentapp.data.Response
import com.emmutua.util.model.AttachmentLog
import com.emmutua.util.model.RequestState
import com.emmutua.attachmentapp.presentation.auth.StudentData
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import java.time.LocalDate

typealias AddUserResponse = Response<Boolean>
typealias AttachmentLogs = RequestState<Map<LocalDate, List<AttachmentLog>>>

interface StorageService {
    suspend fun addStudent(user: StudentData): Boolean
    suspend fun getUserData(uid: String, onSuccess: (DocumentSnapshot) -> Unit)
}

class StorageServiceImpl(
    private val db: FirebaseFirestore,
) : StorageService {
    override suspend fun addStudent(user: StudentData): Boolean {
        return try {
            db.collection("users").document(user.uid).set(user)
                .await()
            Log.d("FireStore", "User Registred success")
            true
        } catch (e: Exception) {
            e.localizedMessage?.let { Log.d("FireStore", it) }
            false
        }
    }


    override suspend fun getUserData(
        uid: String,
        onSuccess: (DocumentSnapshot) -> Unit,
    ) {
        try {
            db.collection("users").document(uid).get()
                .addOnSuccessListener { document ->
                    onSuccess(document)
                }.await()
        } catch (e: Exception) {
            e.localizedMessage?.let { Log.d("FireStore", it) }
        }
    }
}
