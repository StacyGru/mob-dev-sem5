package com.example.a10greatpersons

import android.graphics.drawable.Drawable
import android.media.audiofx.AudioEffect
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.a10greatpersons.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        }

    data class Person (
        val photo: Int,
        val name: String,
        val years_of_life: String,
        val description: String,
        val gender: String
        )

    val person1 = Person (
        R.drawable.person1,
        "Екатерина II",
        "1729-1796",
        "Крым стал нашим cовсем не при Путине, а еще при Екатерине II, которая к тому же успешно одерживала победы в войнах, переписывалась с французскими философами, обожала кофе и частенько меняла любовников. Кажется, императрица знала о жизни что-то, о чем мы даже не подозреваем.",
        "ЖЕНЩИНА")
    val person2 = Person (
        R.drawable.person2,
        "Мария Склодовская-Кюри",
        "1867-1934",
        "Польская и французская учёная-экспериментатор, педагог, общественная деятельница. Первая женщина — преподавательница Сорбонны. Удостоена Нобелевских премий по физике и по химии, является первой женщиной — нобелевским лауреатом в истории и первым дважды нобелевским лауреатом в истории.",
        "ЖЕНЩИНА")
    val person3 = Person (
        R.drawable.person3,
        "Ада Августа Лавлейс",
        "1815-1852",
        "В то время как барышни XIX века изучали музыку и французский, Ада Лавлейс увлекалась точными науками, математикой и строила модели летательных аппаратов. За кропотливую работу над операциями и описанием аналитической машины ее назвали первым программистом в мире.",
        "ЖЕНЩИНА")
    val person4 = Person (
        R.drawable.person4,
        "Коко Шанель",
        "1883-1971",
        "Модернизировала женскую моду, одевала самых известных женщин своей эпохи и разрушала гендерные стереотипы. Единственный человек из мира моды, кого журнал «Тайм» внёс в список ста самых влиятельных людей XX века.",
        "ЖЕНЩИНА")
    val person5 = Person (
        R.drawable.person5,
        "Софья Ковалевская",
        "1850-1891",
        "Первая в Российской империи и Северной Европе женщина-профессор и первая в мире женщина — профессор математики. Автор ряда значительных работ в области математического анализа, уравнений в частных производных и теоретической механики.",
        "ЖЕНЩИНА")
    val person6 = Person (
        R.drawable.person6,
        "Валентина Терешкова",
        "1937-...",
        "Лётчик-космонавт СССР, первая в мире женщина-космонавт, Герой Советского Союза, генерал-майор авиации. Свой космический полёт совершила 16 июня 1963 года на космическом корабле Восток-6, он продолжался почти трое суток.",
        "ЖЕНЩИНА")
    val person7 = Person (
        R.drawable.person7,
        "Мария Трубникова",
        "1835-1897",
        "Именно благодаря ей женщины дореволюционной России получили возможность получать высшее образование. Именно с ней связывают начало феминистского движения в России. Бросала вызов предрассудкам, ограничивавшим свободу женщины, одна из первых позволила себе надеть брюки.",
        "ЖЕНЩИНА")
    val person8 = Person (
        R.drawable.person8,
        "Клара Цеткин",
        "1857-1933",
        "Немецкая политическая деятельница, участница немецкого и международного коммунистического движения, одна из основателей Коммунистической партии Германии, активистка борьбы за права женщин. Предложила учредить 8 марта как Международный день борьбы за женские права и эмансипацию.",
        "ЖЕНЩИНА")
    val person9 = Person (
        R.drawable.person9,
        "Вирджиния Вулф",
        "1882-1941",
        "Британская писательница и литературный критик, ведущая фигура модернистской литературы первой половины XX века. Вирджиния Вулф стала одной из центральных фигур феминизма в 1970-х годах, её работы привлекли большое внимание и получили широкое освещение в феминистских кругах.",
        "ЖЕНЩИНА")
    val person10 = Person (
        R.drawable.person10,
        "Майя Плисецкая",
        "1925-2015",
        "Русская балерина, народная артистка СССР, балетмейстер, хореограф, киноактриса, больше 40 лет была солисткой Большого театра. С гастролями и концертами она объездила почти весь мир: выступала с номерами из балетов, участвовала в постановках зарубежных хореографов и сама ставила спектакли.",
        "ЖЕНЩИНА")

}