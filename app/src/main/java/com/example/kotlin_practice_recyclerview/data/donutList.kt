package com.example.kotlin_practice_recyclerview.data

import com.example.kotlin_practice_recyclerview.R
import com.example.standard_base2.data.Donut

fun donutList(): MutableList<Donut> {
    return mutableListOf(
        Donut(
            name = "병아리 도넛",
            price = "9.99",
            image = R.drawable.icon_donut,
            "맛있는 도넛1이다.\n만드는 방법은\n1.밀가루 반죽을 한 뒤\n2.오븐에 넣어준다."
        ),
        Donut(
            name = "김말이 도넛",
            price = "9.99",
            image = R.drawable.icon_like,
            "맛있는 도넛1이다.\n만드는 방법은\n1.밀가루 반죽을 한 뒤\n2.오븐에 넣어준다."
        ),
        Donut(
            name = "치킨 도넛",
            price = "9.99",
            image = R.drawable.icon_donut,
            "맛있는 도넛1이다.\n만드는 방법은\n1.밀가루 반죽을 한 뒤\n2.오븐에 넣어준다."
        ),
        Donut(
            name = "초코 도넛",
            price = "9.99",
            image = R.drawable.ic_android_black_24dp,
            "맛있는 도넛1이다.\n만드는 방법은\n1.밀가루 반죽을 한 뒤\n2.오븐에 넣어준다."
        ),
        Donut(
            name = "딸기 도넛",
            price = "9.99",
            image = R.drawable.baseline_cancel_24,
            "맛있는 도넛1이다.\n만드는 방법은\n1.밀가루 반죽을 한 뒤\n2.오븐에 넣어준다."
        ),
        Donut(
            name = "메론 도넛",
            price = "9.99",
            image = R.drawable.icon_donut,
            "맛있는 도넛1이다.\n만드는 방법은\n1.밀가루 반죽을 한 뒤\n2.오븐에 넣어준다."
        )
    )
}
