package com.example.navigationdrawerdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.example.navigationdrawerdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var toogle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


       binding.apply {
           navVview.bringToFront() //bring it to front layer

           setSupportActionBar(toolbar) //action bar activated

           toogle = ActionBarDrawerToggle(this@MainActivity,drawerLayout,R.string.nav_open,R.string.nav_close)

           drawerLayout.addDrawerListener(toogle)

           navVview.setNavigationItemSelectedListener{
               when(it.itemId){
                   R.id.home -> {
                       Toast.makeText(this@MainActivity, "Home is Selected", Toast.LENGTH_SHORT).show()
                   drawerLayout.closeDrawer(GravityCompat.START) // it will close the open drawer automatically
                   }

                   R.id.relax -> {
                       Toast.makeText(this@MainActivity, "Relax is Selected", Toast.LENGTH_SHORT).show()}
               }
               true
           }

       }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return if (toogle.onOptionsItemSelected(item)){
            true
        }else{
            return super.onOptionsItemSelected(item)
        }
    }
}