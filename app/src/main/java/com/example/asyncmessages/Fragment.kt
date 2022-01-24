package com.example.asyncmessages

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import androidx.fragment.app.Fragment
import java.util.concurrent.TimeUnit

interface TaskCallbacks{
    fun onPreExecuted()
    fun onCancelled()
    fun onPostExecute(i: Int)
}

class Fragment : Fragment() {

    private var callbacks : TaskCallbacks? = null
    private var task : Task? = null
    private var handler: Handler? = null

    companion object {
        const val  TAG = "Fragment"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        startTask()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbacks = requireActivity() as TaskCallbacks
    }

    override fun onDetach() {
        super.onDetach()
        callbacks = null
    }

    private fun startTask() {
        task = Task()
        var handlerCallback: Handler.Callback = object : Handler.Callback {
            override fun handleMessage(message: Message): Boolean {
                callbacks?.onPostExecute(message.what)
                return false
            }
        }
        handler = Handler(handlerCallback)
        task?.execute()
    }

    fun cancelTask(){
        if (task == null) return
        task?.cancel(true)
    }

    inner class Task : AsyncTask<Unit, Int, Unit>() {

        override fun onPreExecute() {
            callbacks?.onPreExecuted()
        }

        override fun doInBackground(vararg p0: Unit?) {
            Log.d("TASK_STATE", "task started")
            TimeUnit.SECONDS.sleep(2)
            try{
                for (i in 1..10){
                    publishProgress(i)
                    TimeUnit.SECONDS.sleep(2)
                    if (isCancelled) break
                }
            }
            catch (e: InterruptedException){
                e.printStackTrace()
            }
        }

        override fun onCancelled() {
            callbacks?.onCancelled()
        }

        override fun onPostExecute(result: Unit?) {
            Log.d("TASK_STATE", "task finished")
        }

        override fun onProgressUpdate(vararg value: Int?) {
            callbacks?.let {
                handler?.sendEmptyMessage(value[0]!!)
            }
        }

    }
}

