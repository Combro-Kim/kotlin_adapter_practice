package com.example.standard_base2.data

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Donut(
    val id : Long,
    val name : String,
    val price : String,
    @DrawableRes //drawalbe 리소스 참조
    //요소의 값이 이 애너테이션들이 의미하는 리소스 타입에 해당하는 리소스의 아이디임을 의미한다.
    // Android의 모든 리소스는 R 클래스에 의해 int 타입의 id로 관리된다.
    // 정리하자면, drawable 타입 리소스의 아이디를 넣어야 할 곳에 문자열 리소스의 아이디나 정수 리터럴을 넣는 등 실수를 방지할 수 있다.
    val image : Int,
    val description : String
): Parcelable