package com.example.standard_base2.data


class DataSource {
    companion object {
        private var INSTANCE : DataSource?=null
        fun getDataSource(): DataSource {
            return synchronized(DataSource::class) {
                val newInstance = INSTANCE ?: DataSource()
                INSTANCE = newInstance
                newInstance
            }
        }
    }
    fun getDonutList() : List<Donut>{
        return donutList()
    }

/*    fun getDonutForId(id:Long) : Donut{
        donutList().let {
            return it.first{it.id==id}
        }
    }*/
}



/* synchronized ?
* 공유된 자원에 대한 동기화를 달성하기 위해 사용된다.
* 일단, 위에 코드는 들어온 Data를 SingleTon으로 사용하려고 만든 코드이다.
* 그렇다면, 여러 스레드가 동시에 접근하여 변경할 수있는 공유 자원에 대한 접근을 제어해야한다.
* synchronized를 사용하면, 오직 하나의 스레드만 진입하여 작업을 수행할 수 있도록 한다.
* 다른 스레드는 끝날 때까지 대기한다.
*
* 사용방법
* synchronized(데이터){
*   해당 부분에서 작업 수행
* }
* */