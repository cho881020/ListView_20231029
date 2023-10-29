package kr.ac.wku.listview_20231029

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import kr.ac.wku.listview_20231029.adapters.StudentAdapter
import kr.ac.wku.listview_20231029.databinding.ActivityMainBinding
import kr.ac.wku.listview_20231029.datas.StudentData

class MainActivity : AppCompatActivity() {

    val mStudentList = ArrayList<StudentData>()

    lateinit var mStdAdapter: StudentAdapter

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

//        화면이 켜질때, 학생 목록을 ArrayList에 수기로 추가 (임시 활용)

        mStudentList.add(  StudentData("조경진", 1988, "010-5112-3237")  )
        mStudentList.add(  StudentData("김학생", 1999, "010-1111-2222")  )
        mStudentList.add(  StudentData("이학생", 2000, "010-2222-3333")  )
        mStudentList.add(  StudentData("최학생", 1998, "010-3333-4444")  )
        mStudentList.add(  StudentData("박학생", 2004, "010-4444-5555")  )
        mStudentList.add(  StudentData("정학생", 2002)  )

//        어댑터 변수도 객체 생성

        mStdAdapter = StudentAdapter( this, R.layout.student_list_item, mStudentList )

//        만들어진 어댑터를 리스트뷰의 어댑터로 연결
        binding.studentListView.adapter = mStdAdapter


//        한명의 학생을 클릭하면 => 토스트로 "이름 : 연락처" 토스트로 출력

        binding.studentListView.setOnItemClickListener { adapterView, view, position, l ->

            // 이 함수의 세번째 (i, position) 변수 => 클릭 된 위치를 알려주는 역할.

//            mStudentList 중, 클릭된 위치에 맞는 학생 추출 => 활용

            val clickedStd = mStudentList[position]

            Toast.makeText(this, "${clickedStd.name} : ${clickedStd.phoneNum}", Toast.LENGTH_SHORT).show()

        }


//        한명의 학생을 오래 클릭하면 => 해당 학생 삭제

        binding.studentListView.setOnItemLongClickListener { adapterView, view, position, l ->

            // 오래 클릭된 학생 => (목록에서) 삭제

            mStudentList.removeAt(position)  // 내용물 변경 발생

            // 어댑터에게 통보
            mStdAdapter.notifyDataSetChanged()


            // LongClick이벤트는 Bool 타입의 리턴값을 받도록 되어있음.


            return@setOnItemLongClickListener true

        }




    }
}