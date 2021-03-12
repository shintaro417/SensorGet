package com.example.sensorget

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sensorget.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //StringBuilderクラスのインスタンスbufferを生成
        val buffer = StringBuilder()

        //getSystemService()メソッドで、SensorManagerクラスのインスタンスを作成する。メソッドの戻り値がObjectなので、SensorManager型にキャスト
        //センサー一覧を取得
        val sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        /**
         * getSensorList()
         * センサーを取得する
         * 引数は取得したいセンサー
         * Sensor.TYPE_ALL:使用できるセンサー全て
         */
        val sList:List<Sensor> = sensorManager.getSensorList(Sensor.TYPE_ALL)

        /**
         * sListから個々のSensorオブジェクトを取得する。
         */
        for(sensor:Sensor in sList){
            buffer.append("${sensor.type},${sensor.name},${sensor.vendor}\n")
        }
        binding.txt01.text = buffer.toString()
    }
}