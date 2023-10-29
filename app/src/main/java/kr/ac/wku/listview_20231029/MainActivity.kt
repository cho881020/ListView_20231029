package kr.ac.wku.listview_20231029

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.ac.wku.listview_20231029.datas.StudentData

class MainActivity : AppCompatActivity() {

    val mStudentList = ArrayList<StudentData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        화면이 켜질때, 학생 목록을 ArrayList에 수기로 추가 (임시 활용)

        mStudentList.add(  StudentData("조경진", 1988, "010-5112-3237")  )
        mStudentList.add(  StudentData("김학생", 1999, "010-1111-2222")  )
        mStudentList.add(  StudentData("이학생", 2000, "010-2222-3333")  )
        mStudentList.add(  StudentData("최학생", 1998, "010-3333-4444")  )
        mStudentList.add(  StudentData("박학생", 2004, "010-4444-5555")  )




    }
}