package com.jayden.shared.repo

import com.jayden.shared.api.NetworkApi
import com.jayden.shared.applicationDispatcher
import com.jayden.shared.model.MemberModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MembersRepo(private val api: NetworkApi) {
    constructor() : this(api = NetworkApi())

    fun getMembersFromRemote(
        onSuccess: (List<MemberModel>) -> Unit,
        onFailure: (Throwable) -> Unit
    ){
        println("Getting members from remote")

        GlobalScope.launch (applicationDispatcher){
            flow{ emit(api.getMembers()) }
                .catch { onFailure(it) }
                .collect{onSuccess(it)}
        }
    }

    fun getMembersFlowFromRemote(): Flow<List<MemberModel>> {
        println("Getting members from remote")
        return flow { emit(api.getMembers()) }.flowOn(applicationDispatcher)
    }
}