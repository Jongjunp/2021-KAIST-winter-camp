package com.example.commontask1_pjj

//data file
class innerData{
    fun getRepoList(): List<ListItem>{
        return listOf(
            ListItem(
                name = "홍길동",
                phone = "010-1234-5678"
            ),
            ListItem(
                name = "김철수",
                phone ="010-9876-5432"
            )
        )
    }
}