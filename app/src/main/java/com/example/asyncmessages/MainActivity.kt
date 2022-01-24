package com.example.asyncmessages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.asyncmessages.databinding.ActivityMainBinding
import com.example.asyncmessages.databinding.MessageItemBinding

class MainActivity : AppCompatActivity(), TaskCallbacks {

    private lateinit var binding: ActivityMainBinding
    private var fragment: Fragment? = null
    private var result: Int? = 0

    private val verticalLinearLayoutManager: LinearLayoutManager=
        LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    companion object {
        const val  RESULT = "RESULT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        savedInstanceState?.getInt(RESULT)?.let {
            Log.d("TAG", "RESTORE STATE = $it")
        }

        val fm = supportFragmentManager
        val oldFragment = fm.findFragmentByTag(Fragment.TAG)
        if (oldFragment == null) {
            fragment = Fragment()
            fm
                .beginTransaction()
                .add(fragment!!, Fragment.TAG)
                .commit()
        } else {
            fragment = oldFragment as Fragment
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(RESULT, result!!)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        fragment?.cancelTask()
    }

    override fun onPreExecuted() {
    }

    override fun onCancelled() {
        Log.d("TASK_STATE", "task cancelled")
    }

    override fun onPostExecute(i: Int) {
        result = i
        Log.d("PROCESS", "MESSAGE №$i")
        createNewItem(i)
    }

    private fun createNewItem(i: Int) {
        binding.messages.layoutManager = verticalLinearLayoutManager
        binding.messages.adapter = Adapter(Holder.addListItem(i))
    }
}